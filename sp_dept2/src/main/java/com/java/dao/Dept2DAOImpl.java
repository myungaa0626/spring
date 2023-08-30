package com.java.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.domain.Dept2DTO;

@Repository("dept2DAO")
public class Dept2DAOImpl implements Dept2DAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	

	@Override
	public List<Dept2DTO> getAllDepts(Dept2DTO dto) {
		System.out.println("Dept2DAOImpl");

		return sqlSession.selectList("Dept2DAO.getAllDepts");
		

	}
}
