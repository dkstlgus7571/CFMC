package data.dao;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ClassInfoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassInfoDao classInfoDao = new ClassInfoDao();		
		String jsonClass = classInfoDao.getClassInfo();

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

}
