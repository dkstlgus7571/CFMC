package data.dto;

import java.time.LocalDate;

public class OpenClass {
	public int ocCode;
	public String oc_cCode; 
	public String oc_tCode; 
	public String oc_ctCode;	
	public LocalDate oc_acceptStart; 
	public LocalDate oc_acceptEnd; 
	public LocalDate oc_classStart;
	public LocalDate oc_classEnd;	
	public int oc_appliNum;
	public String oc_day;
	public String oc_epi;
	@Override
	public String toString() {
		return "OpenClass [ocCode=" + ocCode + ", oc_cCode=" + oc_cCode + ", oc_tCode=" + oc_tCode + ", oc_ctCode="
				+ oc_ctCode + ", oc_acceptStart=" + oc_acceptStart + ", oc_acceptEnd=" + oc_acceptEnd
				+ ", oc_classStart=" + oc_classStart + ", oc_classEnd=" + oc_classEnd + ", oc_appliNum=" + oc_appliNum
				+ ", oc_day=" + oc_day + ", oc_epi=" + oc_epi + "]";
	}
	
}
