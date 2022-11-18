package data.dao;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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

public class CenterInfoDao {
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

	public void disConnect() {	//DB ���� ����
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

	//제이슨파싱
	public static String getCenterInfo() { //json ��ȯ �޼ҵ�

		String jsonStr = "";

		try {
			StringBuilder urlBuilder = new StringBuilder("https://api.odcloud.kr/api/15063299/v1/uddi:48b1c29e-76a6-47bd-a998-fedccaf1d092");
			urlBuilder.append("?" + URLEncoder.encode("page","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("perPage","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8"));

			urlBuilder.append("&" + URLEncoder.encode("serviceKey","UTF-8") + "=����Ű"); //����Ű�� ���ʿ� ��������

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


//	//시설코드하나로 나머지 칼럼 불러오기
//	public CenterInfo selectCenterInfoByCt_code(String ct_code){
//		String centerInfoSql = "SELECT * FROM p_centerinfo WHERE 시설코드 = ?";
//		CenterInfo centerInfo = null;		
//
//		try {
//			connect();
//
//			psmt = conn.prepareStatement(centerInfoSql);
//			psmt.setString(1,ct_code);
//
//			rs = psmt.executeQuery();
//
//			centerInfo = new CenterInfo();
//
//			//하나만 나오게 할때는 while이 아닌 if
//			if(rs.next()) {
//				centerInfo.setCt_code(rs.getString("시설코드"));
//				centerInfo.setCt_name(rs.getString("시설명칭"));
//				centerInfo.setCt_facName(rs.getString("주요시설"));
//				centerInfo.setCt_facKind(rs.getString("세부시설"));
//				centerInfo.setCt_address(rs.getString("주소"));
//				centerInfo.setCt_tel(rs.getString("시설전화번호"));
//				centerInfo.setCt_Ava(rs.getString("대관가능여부"));
//			}
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			disConnect();
//		}
//		return centerInfo;
//	}
//

	public ArrayList<CenterInfo> selectCenterNameList(){
	      String ctInfoListSql =  "select distinct 시설명칭 from p_centerinfo where 대관가능여부 = '가능'";
	      
	      ArrayList<CenterInfo> selectCenterInfoList = null;

	      try {
	         connect();

	         psmt = conn.prepareStatement(ctInfoListSql);
	         rs = psmt.executeQuery();

	         selectCenterInfoList = new ArrayList<CenterInfo>();
	         
	         while(rs.next()) {
	            CenterInfo centerInfo = new CenterInfo();;
	            centerInfo.setCt_name(rs.getString("시설명칭"));
	            selectCenterInfoList.add(centerInfo);
	         }

	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         disConnect();
	      }
	      return selectCenterInfoList;
	   }   
	
	public ArrayList<CenterInfo> selectCenterInfoList(){
	      String ctInfoListSql =  "select distinct 시설명칭, 주요시설,세부시설 from p_centerinfo where 대관가능여부 = '가능'";
	      ArrayList<CenterInfo> selecCenterInfoList = null;

	      try {
	         connect();

	         psmt = conn.prepareStatement(ctInfoListSql);
	         rs = psmt.executeQuery();


	         selecCenterInfoList = new ArrayList<CenterInfo>();
	         while(rs.next()) {
	            CenterInfo centerInfo = new CenterInfo();;
	            centerInfo.setCt_name(rs.getString("시설명칭"));
	            centerInfo.setCt_facName(rs.getString("주요시설"));
	            centerInfo.setCt_facKind(rs.getString("세부시설"));
	            selecCenterInfoList.add(centerInfo);
	         }

	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         disConnect();
	      }
	      return selecCenterInfoList;
	   }   


}