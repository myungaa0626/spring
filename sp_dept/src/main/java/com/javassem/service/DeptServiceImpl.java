package com.javassem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javassem.dao.DeptDAOImpl;
import com.javassem.domain.DeptVO;

@Service("deptService")
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	private DeptDAOImpl deptDAO;

	public List<DeptVO> selectAllDept(DeptVO vo) {
		return deptDAO.selectAllDept(vo);
	}

}
