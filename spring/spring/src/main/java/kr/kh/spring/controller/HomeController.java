package kr.kh.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring.model.dto.LoginDTO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.MemberService;

@Controller
public class HomeController {

	@Autowired
	private MemberService memberService;

	// 메서드명은 경로명이랑 똑같이 해야 안 헷갈림
	// 화면에 보낼땐 addAttribute
	// value : url , mehod : 전송방식 GET 또는 POST
	// Locale locale : 지역 정보
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		return "home";
	}

	// 회원가입 메서드
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {

		return "member/signup";
	}

	// 로그인 메서드
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {

		return "member/login";
	}

	// 회원가입 메서드
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(Model model, MemberVO member) {
		if (memberService.insertMemner(member)) {
			model.addAttribute("msg", "회원가입을 완료 했습니다.");
			model.addAttribute("url", "/");
		} else {
			model.addAttribute("msg", "회원가입에 실패 했습니다.");
			model.addAttribute("url", "/signup");
		}

		return "message";
	}
	// 로그인 메서드
		@RequestMapping(value = "/login", method = RequestMethod.POST)
		public String loginPost(Model model,LoginDTO loginDto) {
			MemberVO user = memberService.login(loginDto);
			System.out.println(user);
			if(user != null) {
				model.addAttribute("msg", "로그인 했습니다.");
				model.addAttribute("url", "/");
			} else {
				model.addAttribute("msg", "로그인에 실패 했습니다.");
				model.addAttribute("url", "/login");
			}
			return "message";
		}
}
