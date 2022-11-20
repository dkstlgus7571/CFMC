package data.dao;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.ArrayList;
import java.util.List;

import data.dto.CenterInfo;

public class CenterInfoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				

		CenterInfoDao centerInfoDao =new CenterInfoDao();
//		
// 		ArrayList<CenterInfo> CenternameList = centerInfoDao.selectCenternameList();
// 		System.out.println(CenternameList);
 		
 		ArrayList<CenterInfo> CenterInfoAllList = centerInfoDao.selectCenterInfoList();
 		ArrayList<CenterInfo> CenterfacNameList = centerInfoDao.selectCenterfcNameList();
 		System.out.println(CenterInfoAllList);
 		System.out.println(CenterfacNameList);
	}

}
