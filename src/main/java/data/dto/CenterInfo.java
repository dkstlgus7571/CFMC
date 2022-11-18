package data.dto;

public class CenterInfo { 
	public String ct_code; 
	public String ct_name; 
	public String ct_facName; 
	public String ct_facKind; 
	public String ct_address; 
	public String ct_tel;  
	public String ct_Ava;
	@Override
	public String toString() {
		return "CenterInfo [ct_code=" + ct_code + ", ct_name=" + ct_name + ", ct_facName=" + ct_facName
				+ ", ct_facKind=" + ct_facKind + ", ct_address=" + ct_address + ", ct_tel=" + ct_tel + ", ct_Ava="
				+ ct_Ava + "]";
	}
	public String getCt_code() {
		return ct_code;
	}
	public void setCt_code(String ct_code) {
		this.ct_code = ct_code;
	}
	public String getCt_name() {
		return ct_name;
	}
	public void setCt_name(String ct_name) {
		this.ct_name = ct_name;
	}
	public String getCt_facName() {
		return ct_facName;
	}
	public void setCt_facName(String ct_facName) {
		this.ct_facName = ct_facName;
	}
	public String getCt_facKind() {
		return ct_facKind;
	}
	public void setCt_facKind(String ct_facKind) {
		this.ct_facKind = ct_facKind;
	}
	public String getCt_address() {
		return ct_address;
	}
	public void setCt_address(String ct_address) {
		this.ct_address = ct_address;
	}
	public String getCt_tel() {
		return ct_tel;
	}
	public void setCt_tel(String ct_tel) {
		this.ct_tel = ct_tel;
	}
	public String getCt_Ava() {
		return ct_Ava;
	}
	public void setCt_Ava(String ct_Ava) {
		this.ct_Ava = ct_Ava;
	}
	

	
}
