package data.dto;


public class EpiInfo {
	public String ep_epi;
	public String ep_useStart;
	public String ep_useEnd;

	@Override
	public String toString() {
		return "EpiInfo [ep_epi=" + ep_epi + ", ep_useStart=" + ep_useStart + ", ep_useEnd=" + ep_useEnd + "]";
	}
}