package com.practice.example.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class UserDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		request.setAttribute("errMsg", "관리자만 사용할 수 있는 기능입니다.");
		
		String url="/WEB-INF/views/user/denied.jsp";
		
		RequestDispatcher rd=request.getRequestDispatcher(url);
		
		rd.forward(request, response);
//		req.getRequestDispatcher(
//				"/WEB-INF/views/user/denied.jsp").forward(req, res);

	}

}
