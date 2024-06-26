package kr.kh.spring3.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.model.vo.CommunityVO;
import kr.kh.spring3.model.vo.FileVO;
import kr.kh.spring3.model.vo.MemberVO;
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
	@GetMapping("/post/insert")
	public String getPostInsert(Model model) {
		
		ArrayList<CommunityVO> list = boardService.selectCommunity();
		model.addAttribute("list",list);
		model.addAttribute("title","게시글 등록");
		
		return "/post/insert";
	}
	@PostMapping("/post/insert")
	public String postPostInsert(Model model,BoardVO board,HttpSession session
		,MultipartFile [] files) {
		model.addAttribute("title","게시글 등록");
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res= boardService.insertBoard(board,user,files);
		if(res) {
			model.addAttribute("msg","게시글을 등록했습니다");
			model.addAttribute("url","/post/list");
		}else {
			model.addAttribute("msg","게시글을 등록 하지 못했습니다");
			model.addAttribute("url","/post/insert");
		}
		
		return "message";
	}
	@GetMapping("/post/detail")
	public String getPostDetail(Model model,int bo_num) {
		model.addAttribute("title", "게시글 상세페이지");
		// 게시글 조화수 증가
		boardService.updateView(bo_num);
		// 게시글을 가져옴
		BoardVO board= boardService.getBoard(bo_num);
		//게시글 첨부파일을 가져옴
		ArrayList<FileVO> list = boardService.getFileList(bo_num);
		log.info(list);
		//화면에 게시글, 첨부파일을 전송
		model.addAttribute("board",board);
		model.addAttribute("list",list);
		return "/post/detail";
	}

}
