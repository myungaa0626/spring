package edu.kosa.dao_di;

import java.sql.Connection;
import java.sql.DriverManager;


// Oracle DB Connection
public class ConnectionMakerImpl implements ConnectionMaker {

	@Override
	public Connection MakeConnection() throws Exception {
				Class.forName("oracle.jdbc.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:orcl";
				String uid = "newsys";
				String pwd = "kosa1234";
				
				Connection conn = DriverManager.getConnection(url, uid, pwd);
				
				return conn;
	}

}
