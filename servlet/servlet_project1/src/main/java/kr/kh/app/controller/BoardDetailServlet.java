package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.RecommendVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService boardService = new BoardServiceImp();  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//화면에서 보낸 게시글 번호를 가져옴
		int num;
		
		try {
			num = Integer.parseInt(request.getParameter("num"));
		}catch (Exception e) {
			num = 0;
		}
		//서비스에게 게시글 번호를 주면서 게시글 조회수를 증가하라고 시킴
		boardService.updateView(num);
		//서비스에게 게시글 번호를 주면서 게시글을 가져오라고 시킴
		BoardVO board = boardService.getBoard(num);
		//화면에 게시글을 전송
		request.setAttribute("board", board);
		
		//서비스에게 게시글 번호를 주면서 첨부파일을 가져오라고 시킴
		ArrayList<FileVO> fileList = boardService.getFile(num);
		//첨부파일을 화면에 전송
		request.setAttribute("fileList", fileList);
		
		//회원의 추천 상태를 가져옴
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		RecommendVO recommend = boardService.getRecommend(user, num);
		request.setAttribute("recommend", recommend);
		//화면을 전송
		request.getRequestDispatcher("/WEB-INF/views/board/detail.jsp").forward(request, response);
		
	}

}