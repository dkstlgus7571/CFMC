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

