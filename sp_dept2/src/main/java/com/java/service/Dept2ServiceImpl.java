package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.Dept2DAOImpl;
import com.java.domain.Dept2DTO;

@Service("dept2Service")
public class Dept2ServiceImpl implements Dept2Service{
	@Autowired
	private Dept2DAOImpl dept2DAO;


	
	public List<Dept2DTO> getAllDepts(Dept2DTO dto) {
		System.out.println("Dept2ServiceImpl");
		return dept2DAO.getAllDepts(dto);
	}
}
