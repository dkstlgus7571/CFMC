package data.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.dto.MemberInfo;


public class MemberInfoDao {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;


	public void connect() throws Exception{ //DB ����
		String db_url = "jdbc:oracle:thin:@localhost:1521:orcl"; 
		String db_id = "scott";
		String db_pw = "tiger";

		Class.forName("oracle.jdbc.driver.OracleDriver");

		if(conn != null) { 
			conn.close();
		}
		conn = DriverManager.getConnection(db_url, db_id, db_pw);
	}

	public void disConnect() {	//DB ���� ����
		try {
			if(rs != null) {
				rs.close(); }

			if(psmt != null) {
				psmt.close(); }

			if(conn != null) {
				conn.close();}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int login(String m_email, String m_pw) {
		String SQL = "SELECT 비밀번호 from p_memberinfo where 이메일 = ?";
		try {
			connect();
			psmt = conn.prepareStatement(SQL);
			psmt.setString(1, m_email);
			rs = psmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("비밀번호").equals(m_pw)) {
					return 1; // 로그인 성공
				}else
					return 0; //비밀번호 불일치
			}
			return -1;
		}catch (Exception e) {
			e.printStackTrace();
		} 
		
		return -2;
	}
	
	public int join(MemberInfo user) {
		String SQL = "INSERT INTO p_memberInfo VALUES (CONCAT(?, memberInfoSEQ.NEXTVAL), ?, ?, ?, ?, ?,sysdate)";
		try {
			connect();
			psmt = conn.prepareStatement(SQL);
			psmt.setInt(1, user.getmBirth());
			psmt.setString(2, user.getmName());
			psmt.setInt(3, user.getmBirth());
			psmt.setString(4, user.getmPhoneNum());
			psmt.setString(5, user.getmEmail());
			psmt.setString(6, user.getmPw());
			
			return psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}
	
}
