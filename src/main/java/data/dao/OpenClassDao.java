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
	//강좌명이랑 분류명
	public ArrayList<OpenClass> selectAllList(){
		String cNameSql =  "select c.강좌명, c.정원, oc.신청인원, ci.시설명칭, t.이름, ei.이용시작시간, ei.이용종료시간, ei.회차\"\r\n"
				+ "				+ \" from p_openClass oc, p_classinfo c, p_centerinfo ci, p_tutorinfo t, p_epiInfo ei \"\r\n"
				+ "				+ \" where oc.강좌코드 = c.강좌코드 \"\r\n"
				+ "				+ \" and oc.시설코드 = ci.시설코드 \"\r\n"
				+ "				+ \" and oc.강사코드 = t.강사코드 \"\r\n"
				+ "				+ \" and oc.회차 = ei.회차\"\r\n"
				+ "				+ \"and ci.시설명칭 LIKE '%'?'%' \"\r\n"
				+ "				+ \"and c.강좌분류 LIKE  '%'?'%' ";
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

	
	//수강요일이 있는 경우
//	public ArrayList<OpenClass> selectSearchBySelDay(String[] array){
//		
//	}
	
	
	//텍스트가 있는 경우
	public ArrayList<OpenClass> selectSearchByText(String centerName, String classSep, String textCN){
		String sql =  " select c.강좌명, c.강좌분류, c.정원, oc.신청인원, oc.수강요일, oc.접수시작일, oc.접수마감일, oc.강좌시작일, oc.강좌종료일, ci.시설명칭, ei.이용시작시간, ei.이용종료시간, ei.회차"
				+ " from p_openClass oc, p_classinfo c, p_centerinfo ci, p_epiInfo ei "
				+ " where oc.강좌코드 = c.강좌코드 "
				+ " and oc.시설코드 = ci.시설코드 "
				+ " and oc.회차 = ei.회차 "
				+ " and ci.시설명칭 LIKE '%'||?||'%' "
				+ " and c.강좌분류 LIKE  '%'||?||'%' " 
				+ " and c.강좌명 like '%'||?||'%'";
		ArrayList<OpenClass> selectByTextList = null;
		
		try {
			connect();
			selectByTextList = new ArrayList<OpenClass>();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, centerName);
			psmt.setString(2, classSep);
			psmt.setString(3, textCN);
			rs = psmt.executeQuery();
			while(rs.next()) {
				OpenClass openClass = new OpenClass();
				openClass.setC_name(rs.getString("강좌명"));
				openClass.setC_group(rs.getString("강좌분류"));
				openClass.setC_personnel(rs.getInt("정원"));
				openClass.setOc_appliNum(rs.getInt("신청인원"));
				openClass.setOc_day(rs.getString("수강요일"));
				openClass.setOc_acceptStart((rs.getDate("접수시작일")).toLocalDate());
				openClass.setOc_acceptEnd((rs.getDate("접수마감일")).toLocalDate());
				openClass.setOc_classStart((rs.getDate("강좌시작일")).toLocalDate());
				openClass.setOc_classEnd((rs.getDate("강좌종료일")).toLocalDate());
				openClass.setCt_name(rs.getString("시설명칭"));
				openClass.setEp_useStart(rs.getString("이용시작시간")); //강의 시작시간
				openClass.setEp_useEnd(rs.getString("이용종료시간")); 
				openClass.setEp_epi(rs.getString("회차"));
				selectByTextList.add(openClass);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}return selectByTextList;
		
		
	}
	
	
	//수강요일, 텍스트 모두 있는 경우
	public ArrayList<OpenClass> selectSearchByAll(String centerName, String classSep, String[] array, String textCN){
		String sql = " select c.강좌코드, c.강좌명, c.강좌분류, c.정원, oc.개설코드, oc.신청인원, oc.수강요일, oc.접수시작일, oc.접수마감일, oc.강좌시작일, oc.강좌종료일, ci.시설코드, ci.시설명칭, ei.이용시작시간, ei.이용종료시간, ei.회차 "
				+ " from p_openClass oc, p_classinfo c, p_centerinfo ci, p_epiinfo ei "
				+ " where oc.강좌코드 = c.강좌코드"
				+ " and oc.시설코드 = ci.시설코드"
				+ " and oc.회차 = ei.회차"
				+ " and ci.시설명칭 like '%'||?||'%'"
				+ " and c.강좌분류 like '%'||?||'%'"
				+ " and c.강좌명 like '%'||?||'%'"
				+ " and regexp_like(oc.수강요일, ?)"; 
		ArrayList<OpenClass> selectByAll = null;
		String daylist = "";
		try {
			connect();
			selectByAll = new ArrayList<OpenClass>();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, centerName);
			psmt.setString(2, classSep);
			psmt.setString(3, textCN);
			
			
			
			for(int i=0; i<array.length; i++) {
				if(i == 0) {
					daylist = array[i];
				} else {
					daylist += "|" + array[i];
				}
			}
			psmt.setString(4, daylist);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				OpenClass openClass = new OpenClass();
				openClass.setC_code(rs.getString("강좌코드"));
				openClass.setC_name(rs.getString("강좌명"));
				openClass.setC_group(rs.getString("강좌분류"));
				openClass.setC_personnel(rs.getInt("정원"));
				openClass.setOc_appliNum(rs.getInt("신청인원"));
				openClass.setOc_day(rs.getString("수강요일"));
				openClass.setOc_acceptStart((rs.getDate("접수시작일")).toLocalDate());
				openClass.setOc_acceptEnd((rs.getDate("접수마감일")).toLocalDate());
				openClass.setOc_classStart((rs.getDate("강좌시작일")).toLocalDate());
				openClass.setOc_classEnd((rs.getDate("강좌종료일")).toLocalDate());
				openClass.setCt_code(rs.getString("시설코드"));
				openClass.setCt_name(rs.getString("시설명칭"));
				openClass.setEp_useStart(rs.getString("이용시작시간")); //강의 시작시간
				openClass.setEp_useEnd(rs.getString("이용종료시간")); 
				openClass.setEp_epi(rs.getString("회차"));
				selectByAll.add(openClass);
			}
		}catch(Exception e){
			e.printStackTrace();
		}return selectByAll;
	}

	
}