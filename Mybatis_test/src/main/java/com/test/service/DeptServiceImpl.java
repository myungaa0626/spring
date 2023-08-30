package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.DeptDAOImpl;
import com.test.dto.DeptDTO;

@Service("deptService")
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	private DeptDAOImpl deptDAO;

	public List<DeptDTO> selectAllDept(DeptDTO dto) {
		return deptDAO.selectAllDept(dto);
	}

}
