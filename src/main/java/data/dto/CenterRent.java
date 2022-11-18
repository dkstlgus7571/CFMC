package data.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CenterRent {
	
	public int ctr_mCode;	
	public String ctr_ctCode;	
	public LocalDateTime ctr_revDate;	
	public String ctr_epi;
	public LocalDateTime ctr_appliDate;
	
	@Override
	public String toString() {
		return "CenterRent [ctr_mCode=" + ctr_mCode + ", ctr_ctCode=" + ctr_ctCode + ", ctr_revDate=" + ctr_revDate
				+ ", ctr_epi=" + ctr_epi + ", ctr_appliDate=" + ctr_appliDate + "]";}
		
}
