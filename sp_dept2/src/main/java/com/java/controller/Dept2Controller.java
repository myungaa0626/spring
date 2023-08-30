package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.domain.Dept2DTO;
import com.java.service.Dept2Service;

@Controller
public class Dept2Controller {

	@Autowired
	private Dept2Service dept2Service;

	@RequestMapping(value = "/list")
	public String list(Model model, Dept2DTO dto) {
		
		System.out.println("==========================");
		System.out.println();
		System.out.println("no1: Dept2Controller2");
		List dept2List = dept2Service.getAllDepts(dto);
		
		System.out.println("no2: Dept2Controller2");
		
		model.addAttribute("dept2List", dept2List);
		
		
		
		return "dept2/List";
	}
	
}
