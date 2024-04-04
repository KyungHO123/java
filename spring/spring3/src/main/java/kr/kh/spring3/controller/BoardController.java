package kr.kh.spring3.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.pagination.Criteria;
import kr.kh.spring3.pagination.PageMaker;
import kr.kh.spring3.service.BoardService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class BoardController {

	@Autowired
	BoardService boardService;

	@RequestMapping(value = "/post/list", method = RequestMethod.GET)
	public String postList( Model model,Criteria cri) {
		ArrayList<BoardVO> list = boardService.selectBoardList(cri);
		int TotalCount = boardService.getBoardTotalCount(cri); // cri 추가
		PageMaker pm = new PageMaker(3, cri, TotalCount);
		model.addAttribute("pm", pm);
		model.addAttribute("list", list);
		model.addAttribute("title","게시글");
		return "/post/list";
	}

}
