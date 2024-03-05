package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/board/update")
@MultipartConfig(
	maxFileSize = 1024 * 1024 * 10, //10Mb
	maxRequestSize = 1024 * 1024 * 10 * 3, //10Mb 최대 3개
	fileSizeThreshold = 1024 * 1024 //1Mb : 파일 업로드 시 메모리에 저장되는 임시 파일 크기
)
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService boardService = new BoardServiceImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//게시글을 가져와서 화면에 전달
		//화면에서 전송한 게시글 번호를 가져옴
		int num;
		try {
			num = Integer.parseInt(request.getParameter("num"));
		}catch(Exception e) {
			num = 0;
		}
		//서비스에게 게시글 번호를 주면서 게시글을 가져오라고 시킴 : 이미 구현 
		BoardVO board = boardService.getBoard(num);
		//가져온 게시글을 화면에 전송
		request.setAttribute("board", board);
		
		//작성자가 맞는지 확인
		//세션에서 회원 정보를 가져옴
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		//게시글 작성자와 회원아이디가 같은지 확인
		//다르면 게시글 상세로 보내고, 작성자가 아닙니다라고 메시세지를 띄움
		if( board == null || 
			//user == null || 
			!board.getBo_me_id().equals(user.getMe_id())) {
			request.setAttribute("msg", "작성자가 아닙니다");
			request.setAttribute("url", "board/detail?num="+num);
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
			return;
		}
		
		//게시글의 첨부파일을 가져와서 화면에 전송
		ArrayList<FileVO> fileList = boardService.getFile(num);
		request.setAttribute("fileList", fileList);
		//같으면		
		//게시판을 가져와서 화면에 전달
		//서비스에게 게시판 리스트를 가져오라고 시킴
		ArrayList<CommunityVO> list = boardService.getCommunityList();
		//게시판 리스트를 화면에 전송
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/board/update.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인한 회원 정보를 가져옴 : 세션에 있는 회원 정보를 가져옴
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		
		//화면에서 전송한 제목, 내용, 번호, 게시판을 가져옴
		int num , community;
		try {
			num = Integer.parseInt(request.getParameter("num"));
			community = Integer.parseInt(request.getParameter("community"));
		}catch(Exception e) {
			num = 0;
			community = 0;
		}
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		//게시글 객체로 생성
		BoardVO board = new BoardVO(num, title, content, community);
		
		//새로 추가된 첨부파일 정보 가져옴
		ArrayList<Part> fileList = (ArrayList<Part>) request.getParts();
		//삭제할 첨부파일 정보 가져옴
		String numsStr [] = request.getParameterValues("fi_num");
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		if(numsStr != null) {
			for(String numStr : numsStr) {
				try {
					int fi_num = Integer.parseInt(numStr);
					nums.add(fi_num);
				}catch (Exception e) {
				}
			}
		}
		//서비스에게 게시글과 회원정보를 주면서 게시글 수정하라고 요청
		boolean res = boardService.updateBoard(board, user, nums, fileList);
		//성공하면 성공했다고 알리고 게시글 상세로 이동
		if(res) {
			request.setAttribute("msg", "게시글을 수정했습니다.");	
		}
		//실패하면 실패했다고 알리고 게시글 상세로 이동
		else {
			request.setAttribute("msg", "게시글을 수정하지 못했습니다.");
		}
		request.setAttribute("url", "board/detail?num="+num);
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		
	}

}