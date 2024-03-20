package kr.kh.spring.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.MemberDAO;
import kr.kh.spring.model.dto.LoginDTO;
import kr.kh.spring.model.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private MemberDAO memberDao;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	private boolean checkString(String str) {
		return str != null && str.length() != 0;
	}

	private String randomPassword1(int size) {
		String strs ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#";
		String newPw ="";
		int min = 0, max = strs.length() -1;
		while (newPw.length() < 6) {
			int r = (int)(Math.random()*(max-min+1)+min);
			newPw +=strs.charAt(r);
		}
		return newPw;
	}
	private String randomPassword2(int size) {
		int min = 0,max = 26+26+10+3-1;
		String newPw="";
		while (newPw.length() < 6) {
			int r = (int)(Math.random()*(max-min+1)+min);
			//r : 0~9 => 숫자 0~9
			if(r<10) {
				newPw += r;
			}
			//r:10~35 =>a~z
			else if(r<36) {
				newPw +=(char)('a'+r-10);
			}
			//r:36~61 => A-Z
			else if(r < 62) {
				newPw +=(char)('A'+r-10);
			}
			//r:62 => !
			else if(r < 62) {
				newPw +='!';
			}
			//r:63 => @
			else if(r < 63) {
				newPw +='@';
			}
			//r:64 => #
			else if(r < 64) {
				newPw +='#';
			}
		}
		return newPw;
	}

	@Override
	public boolean insertMember(MemberVO member) {
		if (member == null || !checkString(member.getMe_id()) || !checkString(member.getMe_pw())
				|| !checkString(member.getMe_email())) {
			return false;
		}
		// 아이디 중복 체크
		MemberVO user = memberDao.selectMember(member.getMe_id());
		if (user != null) {
			return false;
		}
		// 비밀번호 암호화
		String encPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encPw);

		return memberDao.insertMember(member);
	}

	@Override
	public MemberVO login(LoginDTO loginDto) {
		if (loginDto == null || !checkString(loginDto.getId()) || !checkString(loginDto.getPw()))
			return null;

		// 아이디와 일치하는 회원 정보 가져옴
		MemberVO user = memberDao.selectMember(loginDto.getId());
		// 회원 정보가 없거나 비번이 다르면
		if (user == null || !passwordEncoder.matches(loginDto.getPw(), user.getMe_pw()))
			return null;

		return user;
	}

	@Override
	public boolean idCheck(String id) {
		MemberVO member = memberDao.selectMember(id);
		return member == null;
	}

	@Override
	public boolean findPw(String id) {
		// 회원의 정보를 가져옴
		MemberVO member = memberDao.selectMember(id);
		if (member == null) {
			return false;
		}
		// 임시 새 비밀번호를 생성
		String newPw = randomPassword2(6);

		// 이메일을 전송
		String title = "새 비밀번호입니다.";
		String content = "새 비밀번호는 <b>" + newPw + "</b>입니다.";
		boolean res = mailSend(member.getMe_email(), title, content);

		// 임시 새 비밀번호를 암호화해서 DB에 저장
		String encPw = passwordEncoder.encode(newPw);
		memberDao.updatePassword(id,encPw);
		return res;
	}

	public boolean mailSend(String to, String title, String content) {

		String setfrom = "gksrbqmffn@gmail.com";
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			messageHelper.setFrom(setfrom);// 보내는사람 생략하거나 하면 정상작동을 안함
			messageHelper.setTo(to);// 받는사람 이메일
			messageHelper.setSubject(title);// 메일제목은 생략이 가능하다
			messageHelper.setText(content, true);// 메일 내용

			mailSender.send(message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}