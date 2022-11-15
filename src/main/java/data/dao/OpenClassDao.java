package data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OpenClassDao {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	public void connect() throws Exception{ //연결부분 가져옴
		String db_url = "jdbc:oracle:thin:@localhost:1521:orcl"; //@뒤에 db서버
		String db_id = "scott";
		String db_pw = "tiger";

		Class.forName("oracle.jdbc.driver.OracleDriver");

		if(conn != null) { //이미 connection 되어 있는 경우 한번 종료시켜주기
			conn.close();
		}
		conn = DriverManager.getConnection(db_url, db_id, db_pw);
	}

	public void disConnect() {	//연결해서 사용했던 db 끊기
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

	public int selectCtCode(String locationName) { //위치명을 받아 시설 명칭과 일치할 경우, 시설 코드를 반환하는 메소드
		int ctCode = 0;

		String sqlQuery = "SELECT * "
				+ " FROM P_CENTERINFO "
				+ " WHERE 시설명칭 IN ( SUBSTR(?, 1, instr(?, ' ', 1, 1)-1) ) "
				+ " AND 주요시설 IN ( SUBSTR(?, instr(?, ' ', 1, 1)+1, (? - instr(?, ' ', 1, 1) ) ) )";

		try {
			connect();

			psmt = conn.prepareStatement(sqlQuery);

			//가능하면 자바에서 잘라서 넘기도록 해볼것
			psmt.setString(1, locationName);
			psmt.setString(2, locationName);
			psmt.setString(3, locationName);
			psmt.setString(4, locationName);
			psmt.setInt(5, locationName.length());
			psmt.setString(6, locationName);

			rs = psmt.executeQuery();

			while (rs.next()) {
				ctCode = rs.getInt("시설코드");
			}

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally { //연결해서 사용했던 db 끊기
			disConnect();
		}

		return ctCode;

	}
}