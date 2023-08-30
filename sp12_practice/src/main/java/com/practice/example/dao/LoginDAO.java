package com.practice.example.dao;

import java.util.Map;

public interface LoginDAO {

//	회원 가입처리

	public int insertUser(Map<String, String> map);

//	로그인 처리	

	public Map<String, Object> selectUser(String id);

}
