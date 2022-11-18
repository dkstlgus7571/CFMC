package data.dto;

import java.time.LocalDateTime;

public class CenterRent {
	
	public int ctr_mCode;	
	public String ctr_ctCode;	
	public LocalDateTime ctr_revDate;	
	public String ctr_EPI;
	public LocalDateTime ctr_appliDate;
	
	@Override
	public String toString() {
		return "CenterRent [ctr_mCode=" + ctr_mCode + ", ctr_ctCode=" + ctr_ctCode + ", ctr_revDate=" + ctr_revDate
				+ ", ctr_EPI=" + ctr_EPI + ", ctr_appliDate=" + ctr_appliDate + "]";
	}
		
	
	
}