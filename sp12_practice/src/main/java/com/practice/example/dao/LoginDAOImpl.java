package com.practice.example.dao;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;



@Repository
public class LoginDAOImpl implements LoginDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public int insertUser(Map<String, String> map) {
		
		
		return 0;

		
		
	}

	@Override
	public Map<String, Object> selectUser(String id) {

		
		
		return null;
	}

}
