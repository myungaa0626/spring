package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.dto.DeptDTO;
import com.test.service.DeptService;

@Controller
public class DeptController {
	
	@Autowired
    private DeptService deptService;
	
	@RequestMapping("/deptlist")
    public String list(Model model, DeptDTO dto) {
        List dept = deptService.selectAllDept(dto);
        model.addAttribute("dept", dept);
        return "deptList";
    }

}
