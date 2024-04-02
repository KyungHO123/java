package kr.kh.spring3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.kh.spring3.dao.MemberDAO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	private MemberDAO memberDao;

	@Override
	public int getMemberCount() {

		return memberDao.selectMemberCount();
	}

}
