package com.example.security.model.dao;

import java.util.Map;

public interface UserDAO {
	
	
	public int insertUser(Map<String,String> map);

	Map<String, Object> selectUser(String userid);
	

}
