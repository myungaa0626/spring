package com.test.dao;

import java.util.List;

import com.test.dto.DeptDTO;

public interface DeptDAO {
	
	public List<DeptDTO> selectAllDept(DeptDTO dto);

}
