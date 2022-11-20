package data.dto;

import java.time.LocalDate;
public class ClassReg {
	public int cr_mCode;
	public String cr_cCode;		
	public String cr_tCode;		
	public String cr_ctCode;	
	public LocalDate cr_appliDate;
	
	@Override
	public String toString() {
		return "ClassReg [cr_mCode=" + cr_mCode + ", cr_cCode=" + cr_cCode + ", cr_tCode=" + cr_tCode + ", cr_ctCode="
				+ cr_ctCode + ", cr_appliDate=" + cr_appliDate + "]";
	}	
	
	
	
}
