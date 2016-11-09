package com.bit2016.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bit2016.mysite.vo.UserVo;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler/*HandleMethod*/)
			throws Exception {
		
		// 1. handler 종류
		if (handler instanceof HandlerMethod == false) {
			return true;
		}
		
		// 2. @Auth가 붙어 있는지 없는지...
		Auth auth = ((HandlerMethod)handler).getMethodAnnotation(Auth.class);
		if (auth == null) { // 접근 제어가 필요없는 Handler
			return true;
		}
		
		// 3. 접근 제어
		HttpSession session = request.getSession();
		if (session == null) {
			response.sendRedirect(request.getContextPath() + "/user/loginform");
		}
		
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if (authUser == null) {
			response.sendRedirect(request.getContextPath() + "/user/loginform");
			return false;
		}
		
		// 4. 인증된 사용자
		
		return true;
	}
	
}
