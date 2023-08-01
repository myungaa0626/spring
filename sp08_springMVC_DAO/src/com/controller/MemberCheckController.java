package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.MemberDAO;

@Controller
@RequestMapping("/check.kosa")
public class MemberCheckController {

	@Autowired
	private MemberDAO memberDAO;

	@RequestMapping(method = RequestMethod.GET)
	public String form() {

		return "membercheckForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(@RequestParam(value = "id",required = true ) String id) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		List list = memberDAO.memberById(id);
		
		
		mav.addObject("memberok", list);
		
//		if(list.size() > 0) 
//		if(list !=null)
//		if(!list.isEmpty())
		
		if(list.size() > 0) mav.setViewName("membercheckSuccess"); // move view page
		else mav.setViewName("memberCheckForm");
		
		
		
		return mav;
		
		
	}
	
	
	
}
