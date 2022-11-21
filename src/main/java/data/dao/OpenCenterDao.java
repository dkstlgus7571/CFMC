package data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.dto.CenterInfo;
import data.dto.OpenCenter;

public class OpenCenterDao {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;


	public void connect() throws Exception{
		String db_url = "jdbc:oracle:thin:@localhost:1521:orcl"; 
		String db_id = "scott";
		String db_pw = "tiger";

		Class.forName("oracle.jdbc.driver.OracleDriver");

		if(conn != null) { 
			conn.close();
		}
		conn = DriverManager.getConnection(db_url, db_id, db_pw);
	}

	public void disConnect() {
		try {
			if(rs != null) {
				rs.close(); }

			if(psmt != null) {
				psmt.close(); }

			if(conn != null) {
				conn.close();}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<OpenCenter> selectOpenCenterList(){
		String ctInfoListSql =  "select ct.시설명칭, ct.주요시설, ct.세부시설, oc.예약마감일자, oc.이용가능일자, oc.예약가능여부"
				+ " ,ct.주소, ct.시설전화번호, oc.회차 "
				+ " from p_centerinfo ct, p_opencenter oc "
				+ " where ct.시설코드 = oc.시설코드";
		ArrayList<OpenCenter> openCenterAllList = null;

		try {
			connect();

			psmt = conn.prepareStatement(ctInfoListSql);
			rs = psmt.executeQuery();
			
			openCenterAllList = new ArrayList<OpenCenter>();	
			while(rs.next()) {
				OpenCenter opencenter = new OpenCenter();				
				opencenter.setCt_name(rs.getString("시설명칭"));
				opencenter.setCt_facName(rs.getString("주요시설"));
				opencenter.setCt_facKind(rs.getString("세부시설"));
				opencenter.setOct_revPeri(rs.getDate("예약마감일자").toLocalDate());
				opencenter.setOct_avaPeri(rs.getDate("이용가능일자").toLocalDate());
				opencenter.setOct_revAva(rs.getString("예약가능여부"));
				opencenter.setCt_address(rs.getString("주소"));
				opencenter.setCt_tel(rs.getString("시설전화번호"));
				opencenter.setOct_epi(rs.getString("회차"));
				openCenterAllList.add(opencenter);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return openCenterAllList;
	}

	
	//select revPeri, avaPeri
	public ArrayList<OpenCenter> selectOpenCenterRevAva(){
		String Sql =  "select distinct 이용가능일자, 예약마감일자 from p_opencenter order by 이용가능일자";
		
		ArrayList<OpenCenter> ocRevAvaList = null;

		try {
			connect();

			psmt = conn.prepareStatement(Sql);
			rs = psmt.executeQuery();

			ocRevAvaList = new ArrayList<OpenCenter>();

			while(rs.next()) {
				OpenCenter opencenter = new OpenCenter();

				opencenter.setOct_revPeri(rs.getDate("예약마감일자").toLocalDate());
				opencenter.setOct_avaPeri(rs.getDate("이용가능일자").toLocalDate());
				
				ocRevAvaList.add(opencenter);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return ocRevAvaList;
	}


	//select oc info
	public ArrayList<OpenCenter> printSelectCenterInfo(OpenCenter oct){
		String Sql =  "select c.시설코드 , c.시설명칭, c.주요시설, c.세부시설, oc.이용가능일자, oc.예약가능여부, ei.회차, ei.이용시작시간, ei.이용종료시간 "
				+ " from p_openCenter oc, p_centerInfo c, p_epiInfo ei "
				+ " where oc.시설코드 = c.시설코드 "
				+ " AND oc.회차 = ei.회차 "
				+ " AND c.시설명칭 = ? "
				+ " AND c.주요시설 = ? "
				+ " AND c.세부시설 = ? "
				+ " AND oc.이용가능일자 = TO_DATE(?, 'YY-MM-DD')  "
				+ " AND oc.예약가능여부 = 'Y'"
				+ " ORDER BY oc.이용가능일자, oc.회차"
				;

		OpenCenter openCenter = null;
		ArrayList<OpenCenter> openCenterList = null;
		
		
		try {
			connect();
			
			openCenterList = new ArrayList<OpenCenter>();

			psmt = conn.prepareStatement(Sql);
			
			psmt.setString(1, oct.ct_name); //시설명칭
			psmt.setString(2, oct.ct_facName); //주요시설
			psmt.setString(3, oct.ct_facKind); //세부시설
			psmt.setString(4, oct.oct_avaPeri.toString()); //이용가능일자
			
			rs = psmt.executeQuery();

			while(rs.next()) {
				openCenter = new OpenCenter();
				
				openCenter.setCt_name(rs.getString("시설명칭"));
				openCenter.setCt_facName(rs.getString("주요시설"));
				openCenter.setCt_facKind(rs.getString("세부시설"));
				openCenter.setOct_avaPeri(rs.getDate("이용가능일자").toLocalDate());
				openCenter.setCt_Ava(rs.getString("예약가능여부"));
				openCenter.setOct_epi(rs.getString("회차"));
				openCenter.setEp_useStart(rs.getString("이용시작시간"));
				openCenter.setEp_useEnd(rs.getString("이용종료시간"));
				
				openCenterList.add(openCenter);
			}
			
			System.out.println("openCenter 조회 완료");
			System.out.println("회차 종료");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return openCenterList;
		
	}


//	//select date, epi
//	public OpenCenter SelectCenterEpi(OpenCenter oct){
//		String Sql =  "select c.시설코드 , c.시설명칭, c.주요시설, c.세부시설, oc.이용가능일자, oc.예약가능여부, ei.회차, ei.이용시작시간, ei.이용종료시간 "
//				+ " from p_openCenter oc, p_centerInfo c, p_epiInfo ei "
//				+ " where oc.시설코드 = c.시설코드 "
//				+ " AND oc.회차 = ei.회차 "
//				+ " AND c.시설명칭 = ? "
//				+ " AND c.주요시설 = ? "
//				+ " AND c.세부시설 = ? "
//				+ " AND oc.이용가능일자 = TO_DATE(?, 'YY-MM-DD')  "
//				+ " AND oc.예약가능여부 = 'Y'"
//				+ " ORDER BY oc.이용가능일자, oc.회차"
//				;
//
//		OpenCenter openCenter = null;
//		ArrayList<OpenCenter> openCenterList = null;
//		
//		
//		try {
//			connect();
//			
//			openCenterList = new ArrayList<OpenCenter>();
//
//			psmt = conn.prepareStatement(Sql);
//			
//			psmt.setString(1, oct.ct_name); //시설명칭
//			psmt.setString(2, oct.ct_facName); //주요시설
//			psmt.setString(3, oct.ct_facKind); //세부시설
//			psmt.setString(4, oct.oct_avaPeri.toString()); //이용가능일자
//			
//			rs = psmt.executeQuery();
//
//			while(rs.next()) {
//				openCenter = new OpenCenter();
//				
//				openCenter.setCt_name(rs.getString("시설명칭"));
//				openCenter.setCt_facName(rs.getString("주요시설"));
//				openCenter.setCt_facKind(rs.getString("세부시설"));
//				openCenter.setOct_avaPeri(rs.getDate("이용가능일자").toLocalDate());
//				openCenter.setCt_Ava(rs.getString("예약가능여부"));
//				openCenter.setOct_epi(rs.getString("회차"));
//				openCenter.setEp_useStart(rs.getString("이용시작시간"));
//				openCenter.setEp_useEnd(rs.getString("이용종료시간"));
//				
//				openCenterList.add(openCenter);
//			}
//			
//			System.out.println("openCenter 조회 완료");
//			System.out.println("회차 종료");
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			disConnect();
//		}
//		
//		return openCenterList;
//		
//	}


}
