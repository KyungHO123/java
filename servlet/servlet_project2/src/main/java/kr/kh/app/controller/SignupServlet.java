package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.MemberService;
import kr.kh.app.service.MemberServiceImp;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService = new MemberServiceImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");// from 태그 안 입력 태그에 name이 id요소의 값을 가져옴
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		// 이용중이라는 회원 상태가 DB에 저장되어 있는 경우
		MemberVO member = new MemberVO(id, pw, email, "이용중");
		boolean res = memberService.signup(member);
		if (res) {
			request.setAttribute("msg", "회원 가입에 성공 했습니다.");
			request.setAttribute("url", "");
//			response.sendRedirect(request.getContextPath()+"/");
		} else {
			request.setAttribute("msg", "회원 가입에 실패 했습니다.");
			request.setAttribute("url", "signup");
//			response.sendRedirect(request.getContextPath()+"/signup"); // get방식으로 새로고침
//			doGet(request, response); 화면만 연결 알림창이 계속 뜸
		}
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);

	}

}
