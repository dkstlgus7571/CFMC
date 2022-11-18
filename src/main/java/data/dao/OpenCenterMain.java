package data.dao;

import java.util.ArrayList;
import java.util.List;

import data.dto.CenterInfo;
import data.dto.OpenCenter;

public class OpenCenterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OpenCenterDao opencenterDao = new OpenCenterDao();
	
		ArrayList<OpenCenter> opencenterList= new ArrayList<OpenCenter>();
		
		opencenterList= opencenterDao.selectOpenCenter();
		for(int i = 0; i<opencenterList.size(); i++) {
			System.out.println(opencenterList.get(i));
		}
	}

}
