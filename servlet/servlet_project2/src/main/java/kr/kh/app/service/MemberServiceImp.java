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

	MemberDAO memberDao;

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
	public boolean signup(MemberVO member) {
		if (member == null) {
			return false;
		}
		// 필수 항목 체크
		if (member.getMe_id() == null || member.getMe_pw() == null || member.getMe_email() == null) {
			return false;
		}
		// 아이디 중복 체크

		// 각 항복 유효성 검사

		// 아래 예외 처리는 아이디 중복체크 검사를 안 했기 때문에 발생하는 예외를 임시 처리하기 위한 방법
		try {
			boolean res = memberDao.insertMember(member);
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public MemberVO getMember(LoginDTO loginDto) {
		if (loginDto == null) {
			return null;
		}
		
		MemberVO user = memberDao.selectMember(loginDto.getId());
		if (user == null) {
			return null;
		}
		if(user.getMe_pw().equals(loginDto.getPw())) {
			return user;
		}
		return null;
	}
}
