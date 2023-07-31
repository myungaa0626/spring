package edu.kosa.dao_di;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;

import edu.kosa.model.UserVO;

public class UserDAO {

	@Autowired
	private ConnectionMaker connectionMaker; // has-a

//	public UserDAO(ConnectionMaker connectionMaker) { // DI - constructor
//		
//		this.connectionMaker = connectionMaker;
//	}

	public UserDAO() {
	}

//	public void setConnectionMaker(ConnectionMaker connectionMaker) {// DI - setter method
//		this.connectionMaker = connectionMaker;
//	}

	// 3. DML 명령어
	// insert
	public void insert(UserVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = connectionMaker.MakeConnection(); // db connect

			String sql = "INSERT INTO USERS(ID, NAME, PASSWORD) VALUES(? ,? ,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPassword());
			int result = pstmt.executeUpdate();
			System.out.println(result + "개 입력 성공!!! connectionMaker");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} // end try

	}

	// selectAll
	public void selectAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
//				conn = getConnection();
			conn = connectionMaker.MakeConnection();

			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from users");

			System.out.println("\nID \t Name \t PWD");
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String pwd = rs.getString("password");
				System.out.println(id + "\t" + name + "\t" + pwd);

			} // while end

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // try end
	}

	// selectById
	// updateById
	public void updateByID(String id, String name, String pwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = connectionMaker.MakeConnection();
			pstmt = conn.prepareStatement("update users set name = ?, password = ? where id = ?");
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			pstmt.setString(3, id);
			
			pstmt.executeQuery();
			
			

			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	// deleteById
	
	public void deleteByID(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = connectionMaker.MakeConnection();
			pstmt = conn.prepareStatement("delete from users where id = ?");
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}
	
	
	

	// menu
	public void menu() {

		System.out.println("선택하세요:\n1.Insert ");
		System.out.println("2.selectAll \n3.SelectById \n4.update \n5.Delete ");

	}

}
