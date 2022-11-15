package data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OpenClassDao {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;


	public void connect() throws Exception{ //����κ� ������
		String db_url = "jdbc:oracle:thin:@localhost:1521:orcl"; //@�ڿ� db����
		String db_id = "scott";
		String db_pw = "tiger";

		Class.forName("oracle.jdbc.driver.OracleDriver");

		if(conn != null) { //�̹� connection �Ǿ� �ִ� ��� �ѹ� ��������ֱ�
			conn.close();
		}
		conn = DriverManager.getConnection(db_url, db_id, db_pw);
	}

	public void disConnect() {	//�����ؼ� ����ߴ� db ����
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

	public int selectCtCode(String locationName) { //��ġ���� �޾� �ü� ��Ī�� ��ġ�� ���, �ü� �ڵ带 ��ȯ�ϴ� �޼ҵ�
		int ctCode = 0;
		
		String sqlQuery = "SELECT * "
				+ " FROM P_CENTERINFO "
				+ " WHERE �ü���Ī IN ( SUBSTR(?, 1, instr(?, ' ', 1, 1)-1) )"; 
//				+ " OR �ֿ�ü� IN ( SUBSTR(?, instr(?, ' ', 1, 1)+1, (? - instr(?, ' ', 1, 1) ) ) )";
//		String sqlQuery = "SELECT �ü��ڵ� FROM P_CENTERINFO WHERE �ü���Ī IN ( SUBSTR(?, 1, instr(?, ' ', 1, 1)-1) ) AND �ֿ�ü� IN ( SUBSTR(?, instr(?, ' ', 1, 1)+1, (? - instr(?, ' ', 1, 1) ) ) )";

		try {
			connect();

			psmt = conn.prepareStatement(sqlQuery); 
			
			//�����ϸ� �ڹٿ��� �߶� �ѱ⵵�� �غ���
			psmt.setString(1, locationName);
			psmt.setString(2, locationName);
//			psmt.setString(3, locationName);
//			psmt.setString(4, locationName);
//			psmt.setInt(5, locationName.length());
//			psmt.setString(6, locationName);
			
			rs = psmt.executeQuery();
			
			System.out.println(locationName);
			
			while (rs.next()) {
				ctCode = rs.getInt("�ü��ڵ�");
			}			

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally { //�����ؼ� ����ߴ� db ����
			disConnect();
		}

		return ctCode;		

	}
	
	
	public void insertOpenClass() { 
		//����ϴ� �κ�		
		String sqlQuery = "INSERT INTO P_CLASSINFO VALUES((concat('C', classInfoSEQ.nextval)), "
				+ "'��',"
				+ " '�󱸱���&��ȭ', "
				+ " 20,"
				+ " '�ܽð� ���ڷ� ������, ü�輺,ȿ����,����ü��,�ǰ����� �� ���� �� ����� ���� �',"
				+ " '�ǳ����� �ȭ, ���')";

		try {
			connect();
			psmt = conn.prepareStatement(sqlQuery); 
		
			int resultCnt = psmt.executeUpdate(); 
			System.out.println(resultCnt);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { //�����ؼ� ����ߴ� db ����
			disConnect();
		}
	}
	
}
