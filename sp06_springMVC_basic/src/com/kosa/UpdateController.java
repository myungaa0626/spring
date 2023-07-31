package com.kosa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UpdateController {
	
//	@RequestMapping("/update.bo")
//	@RequestMapping(value =  "/update.bo", method = RequestMethod.GET )
//	public String update(Model model) {
//		
//		String name="강감찬";
//		model.addAttribute("name", name);
//		model.addAttribute("update", "Update Page 입니다");
//		
//		return "update"; //   /WEB-INF/views/update.jsp
//		
//	}
	
	
	@RequestMapping(value =  "/update.bo", method = RequestMethod.GET )
	public ModelAndView update(Model model) {
		
		ModelAndView mav = new ModelAndView();
		
		String name="강감찬";
		mav.addObject("name", name);
		mav.addObject("update", "Update Page333 입니다");

		return mav;
//		return "update"; //   /WEB-INF/views/update.jsp
	}
}
