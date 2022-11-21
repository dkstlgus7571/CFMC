package data.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class ClassReg {
	public int cr_mCode;
	public String cr_cCode;		
	public String cr_tCode;		
	public String cr_ctCode;	
	public Date cr_appliDate;
	public String cr_cName;
	public String cr_ctName;
	public String cr_tName;
	
	
	public String getCr_cName() {
		return cr_cName;
	}

	public void setCr_cName(String cr_cName) {
		this.cr_cName = cr_cName;
	}

	public String getCr_ctName() {
		return cr_ctName;
	}

	public void setCr_ctName(String cr_ctName) {
		this.cr_ctName = cr_ctName;
	}

	public String getCr_tName() {
		return cr_tName;
	}

	public void setCr_tName(String cr_tName) {
		this.cr_tName = cr_tName;
	}

	public int getCr_mCode() {
		return cr_mCode;
	}

	public void setCr_mCode(int cr_mCode) {
		this.cr_mCode = cr_mCode;
	}

	public String getCr_cCode() {
		return cr_cCode;
	}

	public void setCr_cCode(String cr_cCode) {
		this.cr_cCode = cr_cCode;
	}

	public String getCr_tCode() {
		return cr_tCode;
	}

	public void setCr_tCode(String cr_tCode) {
		this.cr_tCode = cr_tCode;
	}

	public String getCr_ctCode() {
		return cr_ctCode;
	}

	public void setCr_ctCode(String cr_ctCode) {
		this.cr_ctCode = cr_ctCode;
	}

	public Date getCr_appliDate() {
		return cr_appliDate;
	}

	public void setCr_appliDate(Date cr_appliDate) {
		this.cr_appliDate = cr_appliDate;
	}
	

	@Override
	public String toString() {
		return "ClassReg [cr_mCode=" + cr_mCode + ", cr_cCode=" + cr_cCode + ", cr_tCode=" + cr_tCode + ", cr_ctCode="
				+ cr_ctCode + ", cr_appliDate=" + cr_appliDate + "]";
	}	
	
	
	
}