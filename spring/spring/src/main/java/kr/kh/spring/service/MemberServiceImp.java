package kr.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.MemberDAO;
import kr.kh.spring.model.dto.LoginDTO;
import kr.kh.spring.model.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	private MemberDAO memberDao;
	
	private boolean checkString(String str) {
		return str!=null && str.length() != 0;
	}

	@Override
	public boolean insertMemner(MemberVO member) {
		if(member == null ||
				!checkString(member.getMe_id())||
				!checkString(member.getMe_pw())||
				!checkString(member.getMe_email())) {
			return false;
		}
		//아이디 중복 체크
		MemberVO user = memberDao.selectMember(member.getMe_id());
		if(user != null) {
			return false;
		}
		return memberDao.insertMember(member);
	}

	@Override
	public MemberVO login(LoginDTO loginDto) {
		if(loginDto == null ||
				!checkString(loginDto.getId())||
				!checkString(loginDto.getPw())) {
			return null;
		}
		MemberVO user = memberDao.selectMember(loginDto.getId());
		
		if(user == null || !user.getMe_pw().equals(loginDto.getPw())) {
			return null;
		}
		return user;
	}

}
