package data.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassRegDao {
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
	
	
	public void procedure_openclass_save(int memcode, int occode){
		String procedureSql = "{call openclass_save(?,?)}";
		try {
			connect();

			cstmt = conn.prepareCall(procedureSql);
			
			cstmt.setInt(1, memcode);
			cstmt.setInt(2, occode);

			
			rs = cstmt.executeQuery();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
	
	}
}
