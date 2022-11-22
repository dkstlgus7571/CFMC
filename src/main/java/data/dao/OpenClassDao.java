package data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.If;
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

	
	//OPENCLASS의 시설명칭을 중복없이 출력하는 메소드
	public ArrayList<OpenClass> selectCtNameOpenclassList(){
		String ctNameSql =  "select distinct cti.시설명칭 "
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

	//센터명과 맞는 강좌분류를 출력하는 메소드
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

	//센터명, 강좌분류에 맞는 강좌명을 출력하는 메소드
	public ArrayList<OpenClass> selectClassNameList(){
		String cNameSql =  "select distinct cti.시설명칭, ci.강좌분류, ci.강좌명"
				+ " from p_classinfo ci, p_openclass oc , p_centerinfo cti "
				+ " where oc.강좌코드 = ci.강좌코드 and oc.시설코드 = cti.시설코드";
		ArrayList<OpenClass> selectClassNameList = null;

		try {
			connect();

			psmt = conn.prepareStatement(cNameSql);
			rs = psmt.executeQuery();

			selectClassNameList = new ArrayList<OpenClass>();
			while(rs.next()) {
				OpenClass openClass = new OpenClass();
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

	//강좌조회시 사용)강좌정보를 출력하는 메소드 :: 기본 값(센터명, 강좌분류)만 받는 경우
	public ArrayList<OpenClass> selectAllList(String clctName, String cGroup){
		String cNameSql = " select distinct c.강좌명, c.강좌분류, c.정원, oc.개설코드, oc.신청인원, oc.수강요일, oc.접수시작일, oc.접수마감일, oc.강좌시작일, oc.강좌종료일, ci.시설코드, ci.시설명칭, ei.이용시작시간, ei.이용종료시간, ei.회차"
				+ " from p_openClass oc, p_classinfo c, p_centerinfo ci, p_epiInfo ei "
				+ " where oc.강좌코드 = c.강좌코드 "
				+ " and oc.시설코드 = ci.시설코드 "
				+ " and oc.회차 = ei.회차 "
				+ " and ci.시설명칭 LIKE '%'||?||'%' "
				+ " and c.강좌분류 LIKE  '%'||?||'%' "
				+ "order by oc.개설코드, oc.강좌시작일, ei.회차";

		ArrayList<OpenClass> selectAList = null;
		OpenClass openClass = null;

		try {
			connect();

			psmt = conn.prepareStatement(cNameSql);

			psmt.setString(1, clctName);
			psmt.setString(2, cGroup);

			rs = psmt.executeQuery();

			selectAList = new ArrayList<OpenClass>();
			
			while(rs.next()) {
				openClass = new OpenClass();
				
				openClass.setC_name(rs.getString("강좌명"));
				openClass.setC_group(rs.getString("강좌분류"));
				openClass.setC_personnel(rs.getInt("정원"));
				openClass.setOcCode(rs.getInt("개설코드"));
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

				selectAList.add(openClass);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return selectAList;
	}


	//강좌조회시 사용)강좌정보를 출력하는 메소드 :: 기본 값(센터명, 강좌분류)+수강요일이 있는 경우
	public ArrayList<OpenClass> selectSearchBySelDay(String clctName, String cGroup, String[] selDay){
		String cNameSql = " select c.강좌코드, c.강좌명, c.강좌분류, c.정원, oc.개설코드, oc.신청인원, oc.수강요일, oc.접수시작일, oc.접수마감일, oc.강좌시작일, oc.강좌종료일, ci.시설코드, ci.시설명칭, ei.이용시작시간, ei.이용종료시간, ei.회차 "
				+ "	from p_openClass oc, p_classinfo c, p_centerinfo ci, p_epiInfo ei "
				+ " where oc.강좌코드 = c.강좌코드 "
				+ " and oc.시설코드 = ci.시설코드 "
				+ " and oc.회차 = ei.회차 "
				+ " and ci.시설명칭 LIKE '%'||?||'%' "
				+ " and c.강좌분류 LIKE  '%'||?||'%' "
				+ " AND REGEXP_LIKE(oc.수강요일, ?)"
				+ "order by oc.개설코드, oc.강좌시작일, ei.회차";
		
		ArrayList<OpenClass> selectAList = null;
		OpenClass openClass = null;
		String seldayList = "";

		try {
			connect();

			psmt = conn.prepareStatement(cNameSql);

			psmt.setString(1, clctName);
			psmt.setString(2, cGroup);

			for(int i = 0; i<selDay.length; i++) {
				seldayList += selDay[i];
				if(i!=selDay.length-1) {
					seldayList += "|";
				}
			}

			psmt.setString(3, seldayList);

			rs = psmt.executeQuery();

			selectAList = new ArrayList<OpenClass>();
			
			while(rs.next()) {
				openClass = new OpenClass();
				
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

				selectAList.add(openClass);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return selectAList;
	}


	//강좌조회시 사용)강좌정보를 출력하는 메소드 :: 기본 값(센터명, 강좌분류)+텍스트가 있는 경우
	public ArrayList<OpenClass> selectSearchByText(String centerName, String classSep, String textCN){
			String sql =  " select distinct c.강좌명, c.강좌분류, c.정원, oc.신청인원, oc.수강요일, oc.접수시작일, oc.접수마감일, oc.강좌시작일, oc.강좌종료일, ci.시설명칭, ei.이용시작시간, ei.이용종료시간, ei.회차 "
					+ " from p_openClass oc, p_classinfo c, p_centerinfo ci, p_epiInfo ei "
					+ " where oc.강좌코드 = c.강좌코드 "
					+ " and oc.시설코드 = ci.시설코드 "
					+ " and oc.회차 = ei.회차 "
					+ " and ci.시설명칭 LIKE '%'||?||'%' "
					+ " and c.강좌분류 LIKE  '%'||?||'%' "
					+ " and c.강좌명 like '%'||?||'%' "
					+ "order by oc.개설코드, oc.강좌시작일, ei.회차";
			
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
	
	
	//강좌조회시 사용)강좌정보를 출력하는 메소드 :: 기본 값(센터명, 강좌분류)+수강요일+텍스트가 모두 있는 경우
	public ArrayList<OpenClass> selectSearchByAll(String centerName, String classSep, String[] array, String textCN){
		String sql = " select c.강좌코드, c.강좌명, c.강좌분류, c.정원, oc.개설코드, oc.신청인원, oc.수강요일, oc.접수시작일, oc.접수마감일, oc.강좌시작일, oc.강좌종료일, ci.시설코드, ci.시설명칭, ei.이용시작시간, ei.이용종료시간, ei.회차 "
				+ "	from p_openClass oc, p_classinfo c, p_centerinfo ci, p_epiInfo ei "
				+ " where oc.강좌코드 = c.강좌코드"
				+ " and oc.시설코드 = ci.시설코드"
				+ " and oc.회차 = ei.회차"
				+ " and ci.시설명칭 LIKE '%'||?||'%' "
				+ " and c.강좌분류 LIKE  '%'||?||'%' "
				+ " and regexp_like(oc.수강요일, ?)"
				+ " and c.강좌명 like '%'||?||'%' "
				+ "order by oc.개설코드, oc.강좌시작일, ei.회차";
		
		ArrayList<OpenClass> selectByAll = null;
		String daylist = "";
		OpenClass openClass = null;
		
		try {
			connect();
			
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, centerName);
			psmt.setString(2, classSep);
			
			for(int i=0; i<array.length; i++) {
				if(i == 0) {
					daylist = array[i];
				} else {
					daylist += "|" + array[i];
				}
			}
			psmt.setString(3, daylist);
			psmt.setString(4, textCN);
			
			rs = psmt.executeQuery();

			selectByAll = new ArrayList<OpenClass>();
			
			while(rs.next()) {
				openClass = new OpenClass();
				
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