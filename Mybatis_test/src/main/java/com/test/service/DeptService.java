package com.test.service;

import java.util.List;

import com.test.dto.DeptDTO;

public interface DeptService {
	
	List<DeptDTO> selectAllDept(DeptDTO dto);

}
