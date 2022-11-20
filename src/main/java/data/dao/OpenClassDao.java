package data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import data.dto.CenterInfo;
import data.dto.OpenClass;

public class OpenClassDao {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

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

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<OpenClass> selectCtNameOpenclassList(){
;		String ctNameSql =  "select distinct cti.시설명칭 "
				+ " from p_classinfo ci, p_openclass oc , p_centerinfo cti where oc.강좌코드 = ci.강좌코드 and oc.시설코드 = cti.시설코드";
		ArrayList<OpenClass> selectCtNameOpenclassList = null;

		try {
			connect();

			psmt = conn.prepareStatement(ctNameSql);
			rs = psmt.executeQuery();


			selectCtNameOpenclassList = new ArrayList<OpenClass>();
			while(rs.next()) {
				OpenClass openClass = new OpenClass();;
				openClass.setCt_name(rs.getString("시설명칭"));
				selectCtNameOpenclassList.add(openClass);
				System.out.println(openClass.ct_name);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return selectCtNameOpenclassList;
	}	
	
	public ArrayList<OpenClass> selectGruopOpenclassList(){
		String groupSql =  "select distinct cti.시설명칭, ci.강좌분류"
				+ " from p_classinfo ci, p_openclass oc , p_centerinfo cti where oc.강좌코드 = ci.강좌코드 and oc.시설코드 = cti.시설코드";
		ArrayList<OpenClass> selectGruopOpenclassList = null;

		try {
			connect();

			psmt = conn.prepareStatement(groupSql);
			rs = psmt.executeQuery();


			selectGruopOpenclassList = new ArrayList<OpenClass>();
			while(rs.next()) {
				OpenClass openClass = new OpenClass();;
				openClass.setCt_name(rs.getString("시설명칭"));
				openClass.setC_group(rs.getString("강좌분류"));
				selectGruopOpenclassList.add(openClass);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return selectGruopOpenclassList;
	}

	
	public ArrayList<OpenClass> selectClassNameList(){
		String cNameSql =  "select distinct cti.시설명칭, ci.강좌분류, ci.강좌명"
				+ " from p_classinfo ci, p_openclass oc , p_centerinfo cti where oc.강좌코드 = ci.강좌코드 and oc.시설코드 = cti.시설코드";
		ArrayList<OpenClass> selectClassNameList = null;

		try {
			connect();

			psmt = conn.prepareStatement(cNameSql);
			rs = psmt.executeQuery();


			selectClassNameList = new ArrayList<OpenClass>();
			while(rs.next()) {
				OpenClass openClass = new OpenClass();;
				openClass.setCt_name(rs.getString("시설명칭"));
				openClass.setC_group(rs.getString("강좌분류"));
				openClass.setC_name(rs.getString("강좌명"));
				selectClassNameList.add(openClass);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return selectClassNameList;
	}
}