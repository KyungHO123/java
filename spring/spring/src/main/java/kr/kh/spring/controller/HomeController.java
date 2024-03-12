package kr.kh.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring.model.dto.TestDTO;
import kr.kh.spring.service.MemberService;

@Controller
public class HomeController {
	
	@Autowired
	private MemberService memberService;
	

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	//메서드명은 경로명이랑 똑같이 해야 안 헷갈림
	// 화면에 보낼땐 addAttribute
	// value : url , mehod : 전송방식 GET 또는 POST
	// Locale locale : 지역 정보
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		//테스트용으로 등록된 회원 수를 조회
		int count = memberService.testCountMember();
		System.out.println("등록된 회원 수 : " + count);
		// model.addAttribute("화면에서 사용할 이름", "보낼 데이터");
		model.addAttribute("name", "홍길동");

		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homePost(Model model, TestDTO testDto/* ,String name, int age */) {
		/*
		 * System.out.println("이름" + name); System.out.println("나이" + age); TestDTO
		 * tesDto = new TestDTO(name,age);
		 */

		System.out.println(testDto);
		return "home";
	}

	@RequestMapping(value = "/test/{num}", method = RequestMethod.GET)
	public String test(Model model,@PathVariable("num")int num) {
		System.out.println("경로 데이터 : " + num);
		return "redirect:/";
	}

}
