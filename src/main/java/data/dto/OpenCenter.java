package data.dto;

public class OpenCenter {
	public String oct_ctCode;		
	public String oct_avaPeri ;	
	public String oct_revPeri ;	
	public String oct_revDate;		
	public String oct_epi;			
	public String oct_revAva;	
	
	@Override
	public String toString() {
		return "OpenCenter [oct_code=" + oct_ctCode + ", oct_avaPeri=" + oct_avaPeri + ", oct_revPeri=" + oct_revPeri
				+ ", oct_revDate=" + oct_revDate + ", oct_epi=" + oct_epi + ", oct_revAva=" + oct_revAva + "]";
	}
	
}
