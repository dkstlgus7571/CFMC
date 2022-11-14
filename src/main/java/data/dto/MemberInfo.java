package data.dto;

public class MemberInfo {
	public int m_number;
	public String m_name;
	public  int m_birth;
	public String m_phoneNum;
	public String m_email;
	public String m_pw;
	@Override
	public String toString() {
		return "MemberInfo [m_number=" + m_number + ", m_name=" + m_name + ", m_birth=" + m_birth + ", m_phoneNum="
				+ m_phoneNum + ", m_email=" + m_email + ", m_pw=" + m_pw + "]";
	}
	
}
