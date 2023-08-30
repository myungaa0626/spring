package com.javassem.service;

import java.util.List;

import com.javassem.domain.DeptVO;

public interface DeptService {
	
	List<DeptVO> selectAllDept(DeptVO vo);

}
