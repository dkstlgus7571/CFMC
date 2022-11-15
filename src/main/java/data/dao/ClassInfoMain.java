package data.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import data.dto.ClassInfo;

public class ClassInfoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassInfoDao classInfoDao = new ClassInfoDao();		
		String jsonClass = classInfoDao.getClassInfo();
		ArrayList<String> classInfoList = null;
		
		ClassInfo classInfo =  new ClassInfo();
		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject)jsonParser.parse(jsonClass);
			JSONArray jsonArr = (JSONArray) jsonObject.get("data");
			classInfoList = new ArrayList<String>();			
			for(int i =0; i<jsonArr.size(); i++) {
				JSONObject dataObj = (JSONObject) jsonArr.get(i);	
//				classInfo.c_name = (String) dataObj.get("강좌명");
				classInfoList.add((String) dataObj.get("강좌명"));
				
//				.c_name = (String) dataObj.get("강좌명");
				
			}
			classInfoDao.insertClassInfo(classInfoList);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}