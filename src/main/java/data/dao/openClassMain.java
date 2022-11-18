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

public class openClassMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassInfo classInfo = new ClassInfo();
		//		System.out.println(findctCode(findFacName(classInfo.c_name)));

		String locationName = findLocName("노구훈련&전술");

		OpenClassDao openClassDao = new OpenClassDao();

		int fcCode = openClassDao.selectCtCode(locationName);

		System.out.println(fcCode);
	}

	//1)강좌명을 입력받아 데이터에서 위치명 반환하는 메소드
	public static String findLocName(String className) {
		String locName = "";

		ClassInfoDao classInfoDao = new ClassInfoDao();

		try {
			String jsonStr = classInfoDao.getClassInfo();

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObj = (JSONObject)jsonParser.parse(jsonStr);

			JSONArray userArr = (JSONArray)jsonObj.get("data");

			for(int i=0; i<userArr.size(); i++) {
				JSONObject userObj = (JSONObject)userArr.get(i);
				String classN = userObj.get("강좌명").toString();

				if(className.equals(classN)) {
					locName = (String)userObj.get("위치");
					break;
				}
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(locName=="") {
			System.out.println("일치하는 강좌명이 없습니다.");
		}
		return locName;
	}

	//2)위의 메소드에서 위치명을 입력받아 시설 명칭과 일치하는 시설 코드를 반환하는 메소드<-select문
	public int findctCode(String locName) {
		int ctCode=0;

		return ctCode;
	}

	//3)이 모든 데이터를 테이블에 insert할 메소드
	public void insertOpenClass() {

	}
}












