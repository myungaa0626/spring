package com.test.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dto.DeptDTO;

@Repository("deptDAO")
public class DeptDAOImpl implements DeptDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public List<DeptDTO> selectAllDept(DeptDTO dto) {
		return mybatis.selectList("DeptDAO.selectAllDept");
	}

}
