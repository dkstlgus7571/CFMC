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

import data.dto.CenterInfo;
import data.dto.ClassInfo;
import data.dto.OpenClass;

public class openClassMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OpenClassDao openClassDao = new OpenClassDao();

		ArrayList<OpenClass> ctNameOpenClassList = openClassDao.selectCtNameOpenclassList();
		
		ArrayList<OpenClass> groupOpenClassList = openClassDao.selectGruopOpenclassList();
	}

}
