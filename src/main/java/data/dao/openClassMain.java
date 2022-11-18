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

import data.dto.ClassInfo;

public class OpenClassMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		ClassInfo classInfo = new ClassInfo();
//
//		String locationName = findLocName("�뱸�Ʒ�&����");
////
//		OpenClassDao openClassDao = new OpenClassDao();
////				
//		int fcCode = openClassDao.selectCtCode(locationName);
////		
//		System.out.println(fcCode);
		
		
		
	}
		
	//1)���¸��� �Է¹޾� �����Ϳ��� ��ġ�� ��ȯ�ϴ� �޼ҵ�
//	public static String findLocName(String className) {
//		String locName = "";
//
//		ClassInfoDao classInfoDao = new ClassInfoDao();
//		
//		try {
//			String jsonStr = classInfoDao.getClassInfo();
//			
//			JSONParser jsonParser = new JSONParser(); 
//			JSONObject jsonObj = (JSONObject)jsonParser.parse(jsonStr);
//
//			JSONArray userArr = (JSONArray)jsonObj.get("data"); 
//
//			for(int i=0; i<userArr.size(); i++) {
//				JSONObject userObj = (JSONObject)userArr.get(i); 
//				String classN = userObj.get("���¸�").toString();
//				
//				if(className.equals(classN)) {
//					locName = (String)userObj.get("��ġ");
//					break;
//				}
//			}
//
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//
//		if(locName=="") {
//			System.out.println("��ġ�ϴ� ���¸��� �����ϴ�.");
//		}
//		return locName;
//	}

	

	
}
