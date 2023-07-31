package edu.kosa.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleUserDAOImpl extends UserDAO {

	@Override
	public Connection getConnection() throws Exception {
		// 1. Driver load... exception
		Class.forName("oracle.jdbc.OracleDriver");

		// 2. Connection & Open
		// driver:@IP:portNumber:SID( or 전역데이터베이스명)
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String uid = "newsys";
		String pwd = "kosa1234";

		Connection conn = DriverManager.getConnection(url, uid, pwd);

		return conn;

	}

}
