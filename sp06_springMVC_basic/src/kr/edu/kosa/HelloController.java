package kr.edu.kosa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// ModelAndView 데이터 저장, 이동할 뷰 페이지 등록
		logger.info("Welcome hello.jsp page move");
		
		// 1. 
		ModelAndView mav = new ModelAndView();
		mav.addObject("nickname","kingsmile"); // data save
//		mav.setViewName("/WEB-INF/views/hello.jsp");   // move view page 
	
		// 2.
		mav.setViewName("hello"); /// WEB-INF/views/ + hello + .jsp
		
		return mav;
	}

}
