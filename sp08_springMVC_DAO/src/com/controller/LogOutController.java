package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogOutController {

	@RequestMapping("/logout.kosa")
	public String out(HttpSession session) {
		session.invalidate();

		return "loginForm";

//		return "redirect:loginForm.kosa";

	}

}
