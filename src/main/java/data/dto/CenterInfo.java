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

	
}
