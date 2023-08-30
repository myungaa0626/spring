package com.practice.security.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class UserLoginFailureHandler 
	implements AuthenticationFailureHandler {
	
	//濡쒓렇�씤�씠 �떎�뙣�뻽�쓣 �븣�쓽 泥섎━
	@Override
	public void onAuthenticationFailure(	HttpServletRequest request, 
									HttpServletResponse response,
									AuthenticationException exception) 
											throws IOException, ServletException {
		//request �쁺�뿭�뿉 蹂��닔 ���옣
		request.setAttribute("errMsg", "로그인에 실패하였습니다.");
		//forward
		request.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(request, response);
	}
}



