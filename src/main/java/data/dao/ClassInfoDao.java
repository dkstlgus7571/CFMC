package data.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ClassInfoDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jsonClass = getClassInfo();

		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject)jsonParser.parse(jsonClass);
			JSONArray jsonArr = (JSONArray) jsonObject.get("data");
			for(int i =0; i<jsonArr.size(); i++) {
				JSONObject dataObj = (JSONObject) jsonArr.get(i);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String getClassInfo() {
		String jsonStr = "";
		try {
			StringBuilder urlBuilder = new StringBuilder("https://api.odcloud.kr/api/15063301/v1/uddi:074c8870-e68b-4174-8ebf-900c95e802b1"); 
			urlBuilder.append("?" + URLEncoder.encode("page","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); 
			urlBuilder.append("&" + URLEncoder.encode("perPage","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); 

			urlBuilder.append("&" + URLEncoder.encode("serviceKey","UTF-8") + "=서비스키"); //서비스키를 이쪽에 넣으세요

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
}