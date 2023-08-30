package com.practice.security.model.dao;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.practice.security.model.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public int insertUser(Map<String, String> map) {
		return sqlSession.insert("user.insertUser",map);
	}

	@Override
	public Map<String, Object> selectUser(String userid) {
		return sqlSession.selectOne("user.selectMember",userid);
	}
	
	@Override
	public Map<String, Object> selectById(String userid) {
		return sqlSession.selectOne("user.selectById",userid);
	}
	
	@Override
	public void updateUser(Map<String, Object> map) {
		sqlSession.update("user.updateUser", map);
	}

}
