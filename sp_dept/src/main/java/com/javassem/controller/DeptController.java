package com.javassem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javassem.domain.DeptVO;
import com.javassem.service.DeptService;

@Controller
public class DeptController {
	
	@Autowired
    private DeptService deptService;
	
	@RequestMapping("/deptlist")
    public String list(Model model, DeptVO vo) {
        List dept = deptService.selectAllDept(vo);
        model.addAttribute("dept", dept);
        return "board/deptList";
    }

}
