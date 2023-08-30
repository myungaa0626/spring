package com.javassem.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javassem.domain.DeptVO;

@Repository("deptDAO")
public class DeptDAOImpl implements DeptDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public List<DeptVO> selectAllDept(DeptVO vo) {
		return mybatis.selectList("DeptDAO.selectAllDept");
	}

}
