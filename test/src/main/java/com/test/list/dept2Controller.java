package com.test.list;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.model.dept2DAO;
import com.test.model.dept2DTO;

@Controller
public class dept2Controller {

	@Autowired
	private dept2DAO dept2dao;

	
	@RequestMapping("/list")
	public String list (Model model) {
		
		List list = dept2dao.listDept2();
		dept2DTO dto = new dept2DTO();

		
		model.addAttribute("list", list);
		return "list";
	}
}
