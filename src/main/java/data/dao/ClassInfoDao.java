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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import data.dto.ClassInfo;

public class ClassInfoDao {
Connection conn = null;
PreparedStatement psmt = null;
ResultSet rs = null;

	public void connect() throws Exception{ //DB ����
		String db_url = "jdbc:oracle:thin:@localhost:1521:orcl"; 
		String db_id = "scott";
		String db_pw = "tiger";

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

public void insertClassInfo(ArrayList<String> classInfo) {

	String sqlQ = "INSERT INTO P_CLASSINFO VALUES("
			+ " (CONCAT('C',classInfoSEQ.NEXTVAL))"
			+ ", ?"
			+ ", ?"
			+ ", 20"
			+ ", '단시간 투자로 전문성, 체계성,효율성,기초체력,건강증진 및 삶의 질 향상을 위한 운동'"
			+ ", '실내전용 운동화, 운동복')";
	try {
		connect();

		psmt = conn.prepareStatement(sqlQ);

		psmt.setString(1, "농구");
		psmt.setString(2, classInfo.get(23));
		int resultCnt = psmt.executeUpdate();
		if(resultCnt > 0) {
			System.out.println("Insert 성공");
		}else {
			System.out.println("Insert 실패");
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
	public void disConnect() {	
		try {
			if(rs != null) {
				rs.close(); }

public static String getClassInfo() { //json ��ȯ �޼ҵ�
	String jsonStr = "";
	try {
		StringBuilder urlBuilder = new StringBuilder("https://api.odcloud.kr/api/15063301/v1/uddi:074c8870-e68b-4174-8ebf-900c95e802b1");
		urlBuilder.append("?" + URLEncoder.encode("page","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("perPage","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8"));

		urlBuilder.append("&" + URLEncoder.encode("serviceKey","UTF-8") + "=QzILSVlkcA7ltIv2%2B4YDPMKcSNxncfi9xa%2B7lfD6DJub%2B1H%2BuvCeEgDMoq8E4obYtACKt2cP%2BEFXelSm996NOQ%3D%3D");

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
	}

	public void insertClassInfo(ArrayList<String> classInfo) {
		
		String sqlQ = "INSERT INTO P_CLASSINFO VALUES("
				+ " (CONCAT('C',classInfoSEQ.NEXTVAL))"
				+ ", ?"
				+ ", ?"
				+ ", 20"
				+ ", '배드민턴 기초과정1주차(그립잡기,클리어,언더스윙)2주차(헤어핀,푸쉬)3주차(스매쉬,드롭)4주차(전후 스텝, 배드민턴 규칙 등)'"
				+ ", '배드민턴 전용화, 라켓')";
		try {
			connect();
			
			psmt = conn.prepareStatement(sqlQ);

			psmt.setString(1, "배드민턴");
			psmt.setString(2, classInfo.get(28));
			int resultCnt = psmt.executeUpdate();
			if(resultCnt > 0) {
				System.out.println("Insert 성공");
			}else {
				System.out.println("Insert 실패");
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
	
	public static String getClassInfo() { //json ��ȯ �޼ҵ�
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

			System.out.println(sb.toString());
			jsonStr = sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*Service Key*/

		return jsonStr;
	}






		System.out.println(sb.toString());
		jsonStr = sb.toString();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} /*Service Key*/

	return jsonStr;
}
}