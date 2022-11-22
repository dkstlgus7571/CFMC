package data.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.dto.CenterRent;
import data.dto.ClassReg;
import data.dto.MemberInfo;



public class MemberInfoDao {
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

	//로그인 기능
	public int login(String m_email, String m_pw) {
		String SQL = "SELECT 비밀번호 from p_memberinfo where 이메일 = ?";
		try {
			connect();
			psmt = conn.prepareStatement(SQL);
			psmt.setString(1, m_email);
			rs = psmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("비밀번호").equals(m_pw)) {
					return 1; // 로그인 성공
				}else
					return 0; //비밀번호 불일치
			}
			return -1;
		}catch (Exception e) {
			e.printStackTrace();
		}

		return -2;
	}

	//회원가입 기능
	public int join(MemberInfo user) {
		String SQL = "INSERT INTO p_memberInfo VALUES (CONCAT(?, memberInfoSEQ.NEXTVAL), ?, ?, ?, ?, ?,sysdate)";
		try {
			connect();
			psmt = conn.prepareStatement(SQL);
			psmt.setInt(1, user.getmBirth());
			psmt.setString(2, user.getmName());
			psmt.setInt(3, user.getmBirth());
			psmt.setString(4, user.getmPhoneNum());
			psmt.setString(5, user.getmEmail());
			psmt.setString(6, user.getmPw());

			return psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}

	
	public MemberInfo myInfo(MemberInfo user) {
		MemberInfo userInfo  = null;

		String sql = "SELECT 회원코드, 이름, 생년월일, 전화번호, 가입날짜 FROM P_MEMBERINFO WHERE 이메일 = ? and 비밀번호 = ? ";

		try {
			connect();
			userInfo = new MemberInfo();

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getmEmail());
			psmt.setString(2, user.getmPw());


			rs = psmt.executeQuery();
			while(rs.next()) {
				userInfo.setmName(rs.getString("이름"));
				userInfo.setmBirth(rs.getInt ("생년월일"));
				userInfo.setmPhoneNum(rs.getString("전화번호"));
				userInfo.setmDate(rs.getDate("가입날짜"));
				userInfo.setmCode(rs.getInt("회원코드"));
			}

		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return userInfo;
	}


	public ArrayList<ClassReg> regInfo(MemberInfo user) {
		String sql = "SELECT C.강좌명, CT.시설명칭, T.이름, CR.신청날짜 "
				+ " FROM P_CLASSREG CR, P_MEMBERINFO M, P_CENTERINFO CT, P_TUTORINFO T, P_CLASSINFO C "
				+ " WHERE CR.회원코드 = M.회원코드 "
				+ " AND CR.시설코드 = CT.시설코드 "
				+ " AND CR.강사코드 = T.강사코드 "
				+ " AND CR.강좌코드 = C.강좌코드 "
				+ " AND CR.회원코드 = ?";
		
		ArrayList<ClassReg> reglist = null;
		
		try {

			connect();
			reglist = new ArrayList<ClassReg>();
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, user.getmCode());
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ClassReg classreg = new ClassReg();
				classreg.setCr_cName(rs.getString("강좌명"));
				classreg.setCr_ctName(rs.getString("시설명칭"));
				classreg.setCr_tName(rs.getString ("이름"));
				classreg.setCr_appliDate(rs.getDate("신청날짜"));
				reglist.add(classreg);
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return reglist;

	}

	
	public ArrayList<CenterRent> rentInfo(MemberInfo user) {
		String sql = "select cti.시설명칭, cti.주요시설, cti.세부시설, ctr.대관날짜, ctepi.이용시작시간, ctepi.이용종료시간, ctr.신청날짜 "
				+ " from p_centerrent ctr, p_centerInfo cti, p_epiinfo ctepi "
				+ " where ctr.시설코드 = cti.시설코드 and ctr.회차 = ctepi.회차 "
				+ " and ctr.회원코드 = ?";
		ArrayList<CenterRent> rentlist = null;
		try {

			connect();
			rentlist = new ArrayList<CenterRent>();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, user.getmCode());
			rs = psmt.executeQuery();
			while(rs.next()) {
				CenterRent centerrent = new CenterRent();
				centerrent.setCtr_ctName(rs.getString("시설명칭"));
				centerrent.setCtr_ctFacName(rs.getString("주요시설"));
				centerrent.setCtr_ctFacKind(rs.getString("세부시설"));
				centerrent.setCtr_appliDate(rs.getDate("대관날짜"));
				centerrent.setCtr_epiUseStart(rs.getString("이용시작시간"));
				centerrent.setCtr_epiUseEnd(rs.getString("이용종료시간"));
				centerrent.setCtr_revDate(rs.getDate("신청날짜"));
				rentlist.add(centerrent);
			}


		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return rentlist;		
	}



}
