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
	
	//select revPeri, avaPeri -> 이용가능시설 테이블의 이용가능일자와 예약마감일자를 출력하는 메소드(조회시 이용)
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


	//select oc info -> 시설명칭, 주요시설, 세부시설, 이용가능일자를 입력받아 시설의 정보를 출력함(조회시 이용)
	public ArrayList<OpenCenter> printSelectCenterInfo(String centerName, String facilityName, String facilityKind, String cenDate){
		String Sql =  "select c.시설코드 , c.시설명칭, c.주요시설, c.세부시설, oc.이용가능일자, oc.예약가능여부, ei.회차, ei.이용시작시간, ei.이용종료시간 "
				+ " from p_openCenter oc, p_centerInfo c, p_epiInfo ei "
				+ " where oc.시설코드 = c.시설코드 "
				+ " AND oc.회차 = ei.회차 "
				+ " AND c.시설명칭 = ? "
				+ " AND c.주요시설 = ? "
				+ " AND c.세부시설 = ? "
				+ " AND oc.이용가능일자 = TO_DATE(?, 'YY-MM-DD') "
				+ " AND oc.예약가능여부 = 'Y'"
				+ " ORDER BY oc.이용가능일자, oc.회차";

		OpenCenter openCenter = null;
		ArrayList<OpenCenter> openCenterList = null;
		
		try {
			connect();
			
			openCenterList = new ArrayList<OpenCenter>();

			psmt = conn.prepareStatement(Sql);
			
			psmt.setString(1, centerName); //시설명칭
			psmt.setString(2, facilityName); //주요시설
			psmt.setString(3, facilityKind); //세부시설
			psmt.setString(4, cenDate); //이용가능일자
			
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return openCenterList;
	}	

	
	//시설명칭, 주요시설, 세부시설, 이용가능일자, 회차를 입력받아 시설의 정보를 출력함(예약창에서 이용)
	public ArrayList<OpenCenter> ReserCenter(OpenCenter oct){
		String Sql =  "select c.시설코드 , c.시설명칭, c.주요시설, c.세부시설, oc.이용가능일자, oc.예약마감일자, "
				+ " c.주소, c.시설전화번호, ei.회차, ei.이용시작시간, ei.이용종료시간,oc.예약가능여부 "
				+ " from p_openCenter oc, p_centerInfo c, p_epiInfo ei "
				+ " where oc.시설코드 = c.시설코드 "
				+ " AND oc.회차 = ei.회차 "
				+ " AND c.시설명칭 = ? "
				+ " AND c.주요시설 = ? "
				+ " AND c.세부시설 = ? "
				+ " AND ei.회차 = ? "
				+ " AND oc.이용가능일자 = TO_DATE(?, 'YY-MM-DD')";

		OpenCenter openCenter = null;
		ArrayList<OpenCenter> reservationDetailList = null;
		
		try {
			connect();
			
			reservationDetailList = new ArrayList<OpenCenter>();

			psmt = conn.prepareStatement(Sql);
			
			psmt.setString(1, oct.ct_name); //시설명칭
			psmt.setString(2, oct.ct_facName); //주요시설
			psmt.setString(3, oct.ct_facKind); //세부시설
			psmt.setString(4, oct.oct_epi);//회차
			psmt.setString(5, oct.oct_avaPeri.toString()); //이용가능일자
			
			rs = psmt.executeQuery();

			while(rs.next()) {
				openCenter = new OpenCenter();		
				openCenter.setCt_code(rs.getString("시설코드"));
				openCenter.setCt_name(rs.getString("시설명칭"));
				openCenter.setCt_facName(rs.getString("주요시설"));
				openCenter.setCt_facKind(rs.getString("세부시설"));
				openCenter.setOct_avaPeri(rs.getDate("이용가능일자").toLocalDate());
				openCenter.setOct_revPeri(rs.getDate("예약마감일자").toLocalDate());
				openCenter.setCt_address(rs.getString("주소"));
				openCenter.setCt_tel(rs.getString("시설전화번호"));
				openCenter.setOct_epi(rs.getString("회차"));
				openCenter.setEp_useStart(rs.getString("이용시작시간"));
				openCenter.setEp_useEnd(rs.getString("이용종료시간"));
				openCenter.setCt_Ava(rs.getString("예약가능여부"));
				reservationDetailList.add(openCenter);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}		
		return reservationDetailList;		
	}


}
