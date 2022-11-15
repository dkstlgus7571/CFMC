package data.dao;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.ArrayList;
import data.dto.CenterInfo;

public class CenterInfoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CenterInfoDao centerInfoDao = new CenterInfoDao();
		
		ArrayList<CenterInfo> centerinfoList = null;
		centerinfoList = centerInfoDao.parsingList();
		
		for(int i=0; i<centerinfoList.size(); i++) {
			centerInfoDao.insertCenterInfo(centerinfoList.get(i));
		}
		
		

		
	}

}
