package data.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OpenCenter {
	public String oct_ctCode;		
	public LocalDate oct_avaPeri ;	
	public LocalDate oct_revPeri ;		
	public String oct_epi;			
	public String oct_revAva;

	public String ct_code; 
	public String ct_name; 
	public String ct_facName; 
	public String ct_facKind; 
	public String ct_address; 
	public String ct_tel;  
	public String ct_Ava;
	
	public String ep_useStart;
	public String ep_useEnd;
	

	//생성자
	public OpenCenter() {

	}
	
	public String getEp_useStart() {
		return ep_useStart;
	}

	public void setEp_useStart(String ep_useStart) {
		this.ep_useStart = ep_useStart;
	}

	public String getEp_useEnd() {
		return ep_useEnd;
	}

	public void setEp_useEnd(String ep_useEnd) {
		this.ep_useEnd = ep_useEnd;
	}

	public OpenCenter(String ct_name, String ct_facName, String ct_facKind, LocalDate oct_avaPeri) {//printSelectCenterInfo 메소드를 위한 생성자 작성(지우지마세요! ! !)
		super();
		this.oct_avaPeri = oct_avaPeri;
		this.ct_name = ct_name;
		this.ct_facName = ct_facName;
		this.ct_facKind = ct_facKind;
	}

	public OpenCenter(String oct_ctCode, LocalDate oct_avaPeri, LocalDate oct_revPeri, String oct_epi,
			String oct_revAva) {
		super();
		this.oct_ctCode = oct_ctCode;
		this.oct_avaPeri = oct_avaPeri;
		this.oct_revPeri = oct_revPeri;
		this.oct_epi = oct_epi;
		this.oct_revAva = oct_revAva;
	}

	public OpenCenter(String oct_ctCode, LocalDate oct_avaPeri, LocalDate oct_revPeri, String oct_epi,
			String oct_revAva, String ct_code, String ct_name, String ct_facName, String ct_facKind, String ct_address,
			String ct_tel, String ct_Ava) {
		super();
		this.oct_ctCode = oct_ctCode;
		this.oct_avaPeri = oct_avaPeri;
		this.oct_revPeri = oct_revPeri;
		this.oct_epi = oct_epi;
		this.oct_revAva = oct_revAva;
		this.ct_code = ct_code;
		this.ct_name = ct_name;
		this.ct_facName = ct_facName;
		this.ct_facKind = ct_facKind;
		this.ct_address = ct_address;
		this.ct_tel = ct_tel;
		this.ct_Ava = ct_Ava;
	}

	@Override
	public String toString() {
		return "OpenCenter [oct_ctCode=" + oct_ctCode + ", oct_avaPeri=" + oct_avaPeri + ", oct_revPeri=" + oct_revPeri
				+ ", oct_epi=" + oct_epi + ", oct_revAva=" + oct_revAva + ", ct_code=" + ct_code + ", ct_name="
				+ ct_name + ", ct_facName=" + ct_facName + ", ct_facKind=" + ct_facKind + ", ct_address=" + ct_address
				+ ", ct_tel=" + ct_tel + ", ct_Ava=" + ct_Ava + "]";
	}

	public String getOct_ctCode() {
		return oct_ctCode;
	}

	public void setOct_ctCode(String oct_ctCode) {
		this.oct_ctCode = oct_ctCode;
	}

	public LocalDate getOct_avaPeri() {
		return oct_avaPeri;
	}

	public void setOct_avaPeri(LocalDate localDate) {
		this.oct_avaPeri = localDate;
	}

	public LocalDate getOct_revPeri() {
		return oct_revPeri;
	}

	public void setOct_revPeri(LocalDate oct_revPeri) {
		this.oct_revPeri = oct_revPeri;
	}

	public String getOct_epi() {
		return oct_epi;
	}

	public void setOct_epi(String oct_epi) {
		this.oct_epi = oct_epi;
	}

	public String getOct_revAva() {
		return oct_revAva;
	}

	public void setOct_revAva(String oct_revAva) {
		this.oct_revAva = oct_revAva;
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

	//	public allCenter(String name) {
	//		this.sname.add(name);
	//	}


}
