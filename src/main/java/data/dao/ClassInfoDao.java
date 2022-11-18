package data.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
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
import data.dto.ClassInfo;

public class ClassInfoDao {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	//DB connect
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

	
	//DB disconnect
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

	
	//get classinfo json
	public static String getClassInfo() { 
		String jsonStr = "";
		try {
			StringBuilder urlBuilder = new StringBuilder("https://api.odcloud.kr/api/15063301/v1/uddi:074c8870-e68b-4174-8ebf-900c95e802b1"); 
			urlBuilder.append("?" + URLEncoder.encode("page","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); 
			urlBuilder.append("&" + URLEncoder.encode("perPage","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); 

			urlBuilder.append("&" + URLEncoder.encode("serviceKey","UTF-8") + "=zWdHzw8MlJ6vDL%2FPqYJw8Fb%2BhsdMFEFXQ%2BGsTTNGK9GN2RKdeUx8ePK8mj6%2BKFzzq10ve41bjsrn9M6TSl2UQg%3D%3D"); 

			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn.getResponseCode()); 
			BufferedReader rd;
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {

				rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			} else {	
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
			}
			StringBuilder sb = new StringBuilder(); 
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line); 
			}
			rd.close();
			conn.disconnect();

			//			System.out.println(sb.toString());
			jsonStr = sb.toString();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*Service Key*/

		return jsonStr;
	}

	
	//select center from p_centerinfo where center's ct_code in class's ct_code
	public List<CenterInfo> selectCenterInfoList(){
		String sql = "select * "
				+ " from p_centerinfo "
				+ " where 시설코드 IN (select 시설코드 "
				+ "                  FROM p_openclass) "; 

		List<CenterInfo> centerInfoList = null;

		try {
			connect();
			
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();

			centerInfoList = new ArrayList<CenterInfo>();
			
			while(rs.next()) {
				CenterInfo centerInfo = new CenterInfo();

				centerInfo.setCt_code(rs.getString("시설코드")); 
				centerInfo.setCt_name(rs.getString("시설명칭"));
				centerInfo.setCt_facName(rs.getString("주요시설")); 
				centerInfo.setCt_facKind(rs.getString("세부시설"));
				centerInfo.setCt_address(rs.getString("주소"));
				centerInfo.setCt_tel(rs.getString("시설전화번호"));
				centerInfo.setCt_Ava(rs.getString("대관가능여부"));
				
				centerInfoList.add(centerInfo);				
			}

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			disConnect();
		}

		return centerInfoList;
	}
	
	
	//select classinfo from p_classinfo where center's ct_code == class's ct_code
	public List<ClassInfo> selectClassInfoList(String ct_code){
		String sql = "select *"
				+ " from p_classinfo c "
				+ " where 강좌코드 IN (select 강좌코드 "
				+ "                    FROM p_openclass oc, p_centerinfo ct "
				+ "                    WHERE oc.시설코드 = '%'||?||'%'"; 

		List<ClassInfo> classInfoList = null;

		try {
			connect();
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, ct_code);
			
			rs = psmt.executeQuery();

			classInfoList = new ArrayList<ClassInfo>();
			
			while(rs.next()) {
				ClassInfo classInfo = new ClassInfo();

				classInfo.setC_code(rs.getString("강좌코드")); 
				classInfo.setC_group(rs.getString("강좌분류"));
				classInfo.setC_name(rs.getString("강좌명")); 
				classInfo.setC_personnel(rs.getInt("정원"));
				classInfo.setC_intro(rs.getString("강좌소개"));
				classInfo.setC_material(rs.getString("준비물"));
				
				classInfoList.add(classInfo);				
			}

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			disConnect();
		}

		return classInfoList;
	}

	
	//insert Classinfo into p_classinfo
	public void insertClassInfo(ArrayList<String> classInfo) {

		String sqlQ = "INSERT INTO P_CLASSINFO VALUES("
				+ " (CONCAT('C',classInfoSEQ.NEXTVAL))"
				+ ", ?"
				+ ", ?"
				+ ", c_personnel"
				+ ", 'c_intro'"
				+ ", 'c_material')";
		try {
			connect();

			psmt = conn.prepareStatement(sqlQ);

			psmt.setString(1, "classname");
			psmt.setString(2, classInfo.get(23));
			int resultCnt = psmt.executeUpdate();
			if(resultCnt > 0) {
				System.out.println("Insert success");
			}else {
				System.out.println("Insert fail");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}

}