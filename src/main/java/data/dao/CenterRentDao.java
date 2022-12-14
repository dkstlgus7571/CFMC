package data.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.dto.CenterRent;
import data.dto.OpenCenter;

public class CenterRentDao {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	CallableStatement cstmt = null;

	public void connect() throws Exception{
		String db_url = "jdbc:oracle:thin:@localhost:1521:orcl"; 
		String db_id = "scott";
		String db_pw = "tiger";

		Class.forName("oracle.jdbc.driver.OracleDriver");

		if(conn != null) { 
			conn.close();
		}
		conn = DriverManager.getConnection(db_url, db_id, db_pw);
	}

	public void disConnect() {
		try {
			if(rs != null) {
				rs.close(); }

			if(psmt != null) {
				psmt.close(); }

			if(conn != null) {
				conn.close();}
			
			if(cstmt != null) {
				cstmt.close();}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//프로시저 수행 - 회원코드, 시설코드, 이용가능일자, 회차를 매개변수로 받아 프로시저를 실행함. 프로시저 실행 시 시설예약정보가 DB에 넘어감
	public void procedure_centerrent_save(int memcode, String ctcode, Date avaperi, String epi){
		String procedureSql = "{call centerrent_save(?,?,?,?)}";

		try {
			connect();

			cstmt = conn.prepareCall(procedureSql);
			
			cstmt.setInt(1, memcode);
			cstmt.setString(2, ctcode);
			cstmt.setDate(3,avaperi);
			cstmt.setString(4, epi);
			
			rs = cstmt.executeQuery();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
	
	}
}
