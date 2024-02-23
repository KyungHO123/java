package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.MemberDAO;
import kr.kh.app.model.dto.LoginDTO;
import kr.kh.app.model.vo.MemberVO;

public class MemberServiceImp implements MemberService {

	private MemberDAO memberDao;

	public MemberServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sessionFactory.openSession(true);
			memberDao = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean signup(MemberVO memberVO) {
		if (memberVO == null || memberVO.getMe_id() == null || memberVO.getMe_pw() == null
				|| memberVO.getMe_email() == null) {
			return false;
		}
		// 정규 표현식 체크 : to do
		/*아이디는 [^a-zA-Z0-9]*$
		 *비번은 [^a-zA-Z0-9\!,@,#,$\]*$
		 * 
		 * */
		try {
			// 아이디가 중복되면 예외가 발생
			return memberDao.insertMember(memberVO);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public MemberVO login(LoginDTO loginDTO) {
		if(loginDTO == null) {
			return null;
		}
		MemberVO user = memberDao.selectMember(loginDTO.getId());
		// 아이디를 잘못 입력하면 null을 return
		if(user == null) {
			return null;
		}
		//비번이 같은 지 확인
		if(user.getMe_pw().equals(loginDTO.getPw())) {
			return user;
		}
		return null;
	}

}
