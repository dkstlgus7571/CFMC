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
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import data.dto.CenterInfo;

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

			urlBuilder.append("&" + URLEncoder.encode("serviceKey","UTF-8") + "=QzILSVlkcA7ltIv2%2B4YDPMKcSNxncfi9xa%2B7lfD6DJub%2B1H%2BuvCeEgDMoq8E4obYtACKt2cP%2BEFXelSm996NOQ%3D%3D"); //����Ű�� ���ʿ� ��������

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



	public ArrayList<CenterInfo> parsingList() {

		String jsonCenter = getCenterInfo();
		ArrayList<CenterInfo> centerInfoList = null;

		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject)jsonParser.parse(jsonCenter);
			JSONArray jsonArr = (JSONArray) jsonObject.get("data");
			centerInfoList = new ArrayList<CenterInfo>();

			for(int i =0; i<jsonArr.size(); i++) {
				JSONObject dataObj = (JSONObject) jsonArr.get(i);
				String facNameList = (String) dataObj.get("주요시설");
				String[] array = facNameList.split("\\+");
				for(int j = 0; j<array.length; j++) {
					CenterInfo centerInfo = new CenterInfo();
					centerInfo.ct_name = (String) dataObj.get("명칭");
					centerInfo.ct_tel = (String) dataObj.get("문의처");
					centerInfo.ct_address = (String) dataObj.get("주소");
					centerInfo.ct_facName = array[j];

					centerInfoList.add(centerInfo);
					System.out.println("list추가");
				}

			}



		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return centerInfoList;
	}

	

	public void insertCenterInfo(CenterInfo ci) {
		// 연결 부분


		String sqlQuery = "INSERT INTO p_centerinfo VALUES(CONCAT('CT', centerinfoSEQ.nextVal), ?, ?, ?, ?, ?)";
		try {
			connect();

			psmt = conn.prepareStatement(sqlQuery);
			psmt.setString(1, ci.ct_name);
			psmt.setString(2, ci.ct_facName);
			psmt.setString(3, ci.ct_facKind);
			psmt.setString(4, ci.ct_address);
			psmt.setString(5, ci.ct_tel);

			int resultCnt = psmt.executeUpdate(); // executeQuery -> Select -> ResultSet
			// executeUpdate -> insert, delete, update -> int
			System.out.println(resultCnt);
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

