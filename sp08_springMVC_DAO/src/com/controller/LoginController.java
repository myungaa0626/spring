package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.MemberDAO;

@Controller
@RequestMapping("/login.kosa")
public class LoginController {

	@Autowired
	private MemberDAO memberDAO;

	@RequestMapping(method = RequestMethod.GET)
	public String form() {

		return "loginForm"; // /WEB-INF/views/+ loginFrom + .jsp

	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(@RequestParam(value = "id") String id, @RequestParam(value = "pwd") String pwd,
			HttpSession session // session 객체를 얻기
	) throws Exception {

		String viewPage = null;
		boolean isMember = memberDAO.memberCheck(id, pwd);

		if (isMember) {
			session.setAttribute("USERID", id); // data save
			viewPage = "loginSuccess"; // WEB-INF/views/ + loginSuccess + .jsp
		} else {
			viewPage = "loginForm";
		}

		return viewPage;

	}
}
