package edu.kosa.model;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class DeptDAOImpl implements DeptDAO {


	private JdbcTemplate jdbcTemplate; // DML 명령 처리 클래스 - insert, update, delete, select
	
	
	
	@Override
	public List listDept() {

		return null;
	}

	@Override
	public void insertDept(DeptDTO DTO) {

		
	}

}
