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

	public void connect() throws Exception{ //DB 占쏙옙占쏙옙
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

public void insertClassInfo(ArrayList<String> classInfo) {

	String sqlQ = "INSERT INTO P_CLASSINFO VALUES("
			+ " (CONCAT('C',classInfoSEQ.NEXTVAL))"
			+ ", ?"
			+ ", ?"
			+ ", 20"
			+ ", '�떒�떆媛� �닾�옄濡� �쟾臾몄꽦, 泥닿퀎�꽦,�슚�쑉�꽦,湲곗큹泥대젰,嫄닿컯利앹쭊 諛� �궣�쓽 吏� �뼢�긽�쓣 �쐞�븳 �슫�룞'"
			+ ", '�떎�궡�쟾�슜 �슫�룞�솕, �슫�룞蹂�')";
	try {
		connect();

		psmt = conn.prepareStatement(sqlQ);

		psmt.setString(1, "�냽援�");
		psmt.setString(2, classInfo.get(23));
		int resultCnt = psmt.executeUpdate();
		if(resultCnt > 0) {
			System.out.println("Insert �꽦怨�");
		}else {
			System.out.println("Insert �떎�뙣");
		}
		conn = DriverManager.getConnection(db_url, db_id, db_pw);
	}
}
	
	
	public static String getClassInfo() { //json 占쏙옙환 占쌨소듸옙
		String jsonStr = "";
		try {
			StringBuilder urlBuilder = new StringBuilder("https://api.odcloud.kr/api/15063301/v1/uddi:074c8870-e68b-4174-8ebf-900c95e802b1"); 
			urlBuilder.append("?" + URLEncoder.encode("page","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); 
			urlBuilder.append("&" + URLEncoder.encode("perPage","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); 

				

					
					public static String getClassInfo() { //json ��ȯ �޼ҵ�
						String jsonStr = "";
						try {
							StringBuilder urlBuilder = new StringBuilder("https://api.odcloud.kr/api/15063301/v1/uddi:074c8870-e68b-4174-8ebf-900c95e802b1"); 
							urlBuilder.append("?" + URLEncoder.encode("page","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); 
							urlBuilder.append("&" + URLEncoder.encode("perPage","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); 

							urlBuilder.append("&" + URLEncoder.encode("serviceKey","UTF-8") + "=zWdHzw8MlJ6vDL%2FPqYJw8Fb%2BhsdMFEFXQ%2BGsTTNGK9GN2RKdeUx8ePK8mj6%2BKFzzq10ve41bjsrn9M6TSl2UQg%3D%3D"); 

			System.out.println(sb.toString());
			jsonStr = sb.toString();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*Service Key*/

		return jsonStr;
	}
}
