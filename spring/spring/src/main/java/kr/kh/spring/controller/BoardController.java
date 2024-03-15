package kr.kh.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.CommunityVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;

//	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	@GetMapping("/board/list")
	public String boardList(Model model, Criteria cri) {
		cri.setPerPageNum(5);
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		int totalcount = boardService.getBoardTotalCount(cri);
		PageMaker pm = new PageMaker(3, cri, totalcount);
		model.addAttribute("list", list); // 화면에 보내기
		model.addAttribute("pm", pm); // 화면에 보내기
		return "/board/list";
	}

	@GetMapping("/board/insert")
	public String boardInsert(Model model) {
		// 커뮤니티 리스트를 가져와서 화면에 전송
		ArrayList<CommunityVO> list = boardService.getCommunityList();
		model.addAttribute("list", list);
		return "/board/insert";
	}

	@PostMapping("/board/insert")
	public String boardInsertPost(Model model, BoardVO board, HttpServletRequest request) {
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		if (boardService.insertBoard(board, user)) {
			model.addAttribute("msg", "게시글을 등록 했습니다.");
			model.addAttribute("url", "/board/list");
		} else {
			model.addAttribute("msg", "게시글을 등록하지 못했습니다.");
			model.addAttribute("url", "/board/insert");
		}
		return "message";
	}

}
