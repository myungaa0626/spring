package com.practice.example.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.practice.example.dto.LoginDTO;

public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {

		// 인증된 사용자의 정보 리턴
		LoginDTO dto = (LoginDTO) auth.getPrincipal();
		String msg = auth.getName() + "님 환영합니다.";
		request.setAttribute("msg", msg); // request 영역에 저장

		// 시작페이지로 포워딩
//		RequestDispatcher rd=request.getRequestDispatcher("/");
//		rd.forward(request, response); 
		response.sendRedirect(request.getContextPath() + "/");

	}

}
