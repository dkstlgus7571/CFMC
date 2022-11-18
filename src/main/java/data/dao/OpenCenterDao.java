package data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.dto.CenterInfo;
import data.dto.OpenCenter;

public class OpenCenterDao {
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

	public void disConnect() {
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
	
	public ArrayList<OpenCenter> selectOpenCenter(){
		String ctInfoListSql =  "select ct.시설명칭, ct.주요시설, ct.세부시설, oc.예약마감일자, oc.이용가능일자, oc.예약가능여부"
				+ " ,ct.주소, ct.시설전화번호, oc.회차 "
				+ " from p_centerinfo ct, p_opencenter oc "
				+ " where ct.시설코드 = oc.시설코드";
		ArrayList<OpenCenter> openCenterList = null;

		try {
			connect();

			psmt = conn.prepareStatement(ctInfoListSql);
			rs = psmt.executeQuery();
			
			openCenterList = new ArrayList<OpenCenter>();
			
			
			while(rs.next()) {
				OpenCenter opencenter = new OpenCenter();;
				opencenter.setCt_name(rs.getString("시설명칭"));
				opencenter.setCt_facName(rs.getString("주요시설"));
				opencenter.setCt_facKind(rs.getString("세부시설"));
				opencenter.setOct_revPeri(rs.getTimestamp("예약마감일자").toLocalDateTime());
				opencenter.setOct_avaPeri(rs.getTimestamp("이용가능일자").toLocalDateTime());
				opencenter.setOct_revAva(rs.getString("예약가능여부"));
				opencenter.setCt_address(rs.getString("주소"));
				opencenter.setCt_tel(rs.getString("시설전화번호"));
				opencenter.setOct_epi(rs.getString("회차"));
				openCenterList.add(opencenter);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return openCenterList;
	}
	
}
																						