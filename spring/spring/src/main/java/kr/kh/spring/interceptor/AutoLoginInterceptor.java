package kr.kh.spring.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.MemberService;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter {

	/* preHandle에서 return값이 true이면 가려던 컨트롤러로 가서 작업을 진행
	 * return값이 false이면 가려던 컨트롤러로 가지 마세요. 리다이렉트할 경로가 있으면 해당 경로로 이동
	 * */
	@Autowired
	MemberService memberService;
	
	@Override
	public boolean preHandle(
		HttpServletRequest request, 
		HttpServletResponse response, 
		Object handler)
	    throws Exception {
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		//로그인이 안되어 있다면 자동 로그인 체크를 해야 함.
		if(user == null) {
			//loginCookie 정보를 가져옴
			Cookie cookie = WebUtils.getCookie(request, "loginCookie");
			//쿠키가 있으면 자동 로그인을 진행함.
			if(cookie != null) {
				//쿠키에 value로 넣었던 세션 아이디 값을 가져옴.
				String sessionId = cookie.getValue();
				//회원 정보를 가져옴
				user = memberService.getMemberByCookie(sessionId);
				if(user != null) {
					//회원 정보를 화면에 저장
					request.getSession().setAttribute("user", user);
					
				}
				
			}
		}
		
		return true;
	}

}