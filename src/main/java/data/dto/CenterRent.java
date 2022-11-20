package data.dto;

import java.time.LocalDate;

public class CenterRent {
	
	public int ctr_mCode;	
	public String ctr_ctCode;	
	public LocalDate ctr_revDate;	
	public String ctr_EPI;
	public LocalDate ctr_appliDate;
	
	@Override
	public String toString() {
		return "CenterRent [ctr_mCode=" + ctr_mCode + ", ctr_ctCode=" + ctr_ctCode + ", ctr_EPI=" + ctr_EPI + "]";
	}
	

		
	
	
}