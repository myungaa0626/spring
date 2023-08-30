package com.test.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class dept2DAOImpl implements dept2DAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List listDept2() {
		String sql = "SELECT * FROM DEPT2";
		dept2DTO dto = new dept2DTO();
		return jdbcTemplate.queryForList(sql);
	}
}
