package data.dto;

public class ClassInfo {
	public int c_number;
	public String c_name;
	public int c_personnel;
	public int c_numOfappli;
	public String c_time;
	public String c_intro;
	public String c_material;
	@Override
	public String toString() {
		return "ClassInfo [c_number=" + c_number + ", c_name=" + c_name + ", c_personnel=" + c_personnel
				+ ", c_numOfappli=" + c_numOfappli + ", c_time=" + c_time + ", c_intro=" + c_intro + ", c_material="
				+ c_material + "]";
	}
	
}
