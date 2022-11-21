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

		OpenClass oc = new OpenClass();
		OpenClassDao ocDao = new OpenClassDao();
		System.out.println(ocDao.selectSearchByText("천안","수영","수영"));
		String[] array = {"월","화","수","목","금"};
		System.out.println(ocDao.selectSearchByAll("천안","수영",array,"수영"));
	}

}
