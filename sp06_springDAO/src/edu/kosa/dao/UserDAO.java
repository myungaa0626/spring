package edu.kosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import edu.kosa.model.UserVO;

public abstract class UserDAO { // 추상클래스

	// DB 연결 관련 메소드
	public abstract Connection getConnection() throws Exception; // 추상메소드

	// 3. 사용 (DML 명령어)

	// insert
	public void insert(UserVO vo) throws Exception {
		Connection conn = getConnection();
		String sql = "INSERT INTO USERS(ID, NAME, PASSWORD) VALUES(? ,? ,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getName());
		pstmt.setString(3, vo.getPassword());
		int result = pstmt.executeUpdate();
		System.out.println(result + "개 입력 성공!!!");

		pstmt.close();
		conn.close();

	} // end insert()

	// selectAll
	public void selectAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
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
	public void selectByID(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from users where id = ?");
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			System.out.println("\nID \t Name \t PWD");
			while (rs.next()) {

				String name = rs.getString("name");
				String pwd = rs.getString("password");
				System.out.println(id + "\t" + name + "\t" + pwd);

			} // while end

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // try end
	}

	// update

	// delete

	// menu
	public void menu() {
		System.out.println("선택하세요:\n1.Insert ");
		System.out.println("2.selectAll \n3.SelectById \n4.update \n5.Delete ");

	}

}
