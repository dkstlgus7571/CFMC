package data.dto;

import java.time.LocalDate;

public class EpiInfo {
	public String ep_epi;
	public LocalDate ep_useStart;
	public LocalDate ep_useEnd;

@Override
	public String toString() {
		return "EpiInfo [ep_epi=" + ep_epi + ", ep_useStart=" + ep_useStart + ", ep_useEnd=" + ep_useEnd + "]";
	}
}