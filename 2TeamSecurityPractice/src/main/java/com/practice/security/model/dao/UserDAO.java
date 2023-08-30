package com.practice.security.model.dao;

import java.util.Map;

import com.practice.security.model.dto.UserDTO;

public interface UserDAO {

	public int insertUser(Map<String,String> map);
	
	public Map<String,Object> selectUser(String userid);
	
	public Map<String, Object> selectById(String userid);
	
	public void updateUser(Map<String, Object> map);
}
