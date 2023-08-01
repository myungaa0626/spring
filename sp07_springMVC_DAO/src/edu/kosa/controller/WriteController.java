package edu.kosa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kosa.model.DeptDAO;
import edu.kosa.model.DeptDTO;

@Controller
public class WriteController {

	@Autowired
	private DeptDAO deptDao;

	@RequestMapping("/write.do")
	public String write(Model model, HttpServletRequest request) {

		int no = Integer.parseInt(request.getParameter("deptno"));
		String name = request.getParameter("deptname");
		String loc = request.getParameter("deptloc");

		System.out.println(no + "\t," + name + "\t," + loc);
		// DB Save
		
		DeptDTO dto = new DeptDTO();
		
		dto.setDeptno(no);
		dto.setDname(name);
		dto.setLoc(loc);
		
		deptDao.insertDept(dto);

		return "redirect:list.do"; //
	}
}
