package data.dto;

import java.time.LocalDateTime;

public class MemberInfo {
	public int m_code;
	public String m_name;
	public  int m_birth;
	public String m_phoneNum;
	public String m_email;
	public String m_pw;
	public LocalDateTime m_date;
	
	@Override
	public String toString() {
		return "MemberInfo [m_code=" + m_code + ", m_name=" + m_name + ", m_birth=" + m_birth + ", m_phoneNum="
				+ m_phoneNum + ", m_email=" + m_email + ", m_pw=" + m_pw + ", m_date=" + m_date + "]";
	}
	
	
}
