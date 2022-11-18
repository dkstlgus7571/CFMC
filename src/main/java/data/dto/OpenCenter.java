package data.dto;

import java.time.LocalDateTime;

public class OpenCenter {
	public String oct_ctCode;		
	public LocalDateTime oct_revClosed ;	
	public LocalDateTime oct_avaDate;	
	public String oct_epi;		
	public String oct_revAva;
	
	@Override
	public String toString() {
		return "OpenCenter [oct_ctCode=" + oct_ctCode + ", oct_revClosed=" + oct_revClosed + ", oct_avaDate="
				+ oct_avaDate + ", oct_epi=" + oct_epi + ", oct_revAva=" + oct_revAva + "]";
	}
	

	
}