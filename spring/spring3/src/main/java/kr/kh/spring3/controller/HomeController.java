package kr.kh.spring3.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.service.MemberService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class HomeController {

	@Autowired
	MemberService memberService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("안녕하세요. 스프링 메인입니다.");
		int count = memberService.getMemberCount();
		log.info("등록된 회원 수 : " + count);

		return "/main/home";
	}

	// 겟 싸인업
	@GetMapping("/signup")
	public String getSignup(Model model) {
		model.addAttribute("title", "회원가입");
		return "/member/signup";
	}

	// 포스트 싸인업
	@PostMapping("/signup")
	public String postSignup(Model model, MemberVO member) {
		boolean res = memberService.signup(member);
		if (res) {
			model.addAttribute("msg", "회원가입을 했습니다.");
			model.addAttribute("url", "/");
		} else {
			model.addAttribute("msg", "회원가입을 하지 못했습니다.");
			model.addAttribute("url", "/signup");
		}
		return "message";

	}

	// 겟 로그인
	@GetMapping("/login")
	public String getLogin(Model model, MemberVO member) {
		model.addAttribute("title", "로그인");

		return "/member/login";

	}

	// 포스트 로그인
	@PostMapping("/login")
	public String postLogin(Model model, MemberVO member) {
		MemberVO user = memberService.login(member);
		model.addAttribute("user", user); // user라는 이름으로 전송
		if (user != null) {
			model.addAttribute("msg", "로그인 했습니다.");
			model.addAttribute("url", "/");
		} else {
			model.addAttribute("msg", "로그인을 하지 못했습니다.");
			model.addAttribute("url", "/login");
		}
		return "message";

	}
	// 겟 로그아웃
		@GetMapping("/logout")
		public String getLogout(Model model, HttpSession session) {
			session.removeAttribute("user");
			model.addAttribute("msg", "로그아웃 했습니다.");
			model.addAttribute("url", "/");
			return "message";

		}

}
