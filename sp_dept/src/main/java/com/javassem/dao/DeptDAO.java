package com.javassem.dao;

import java.util.List;

import com.javassem.domain.DeptVO;

public interface DeptDAO {
	
	public List<DeptVO> selectAllDept(DeptVO vo);

}
