package data.dto;

import java.time.LocalDateTime;

public class TutorInfo { 
	public LocalDateTime t_code; 
	public String t_name; 
	
	@Override
	public String toString() {
		return "TutorInfo [t_code=" + t_code + ", t_name=" + t_name + "]";
	}

}
