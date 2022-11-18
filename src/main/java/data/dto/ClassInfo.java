package data.dto;

public class ClassInfo {
	public String c_code;
	public String c_group;
	public String c_name;
	public int c_personnel; 
	public String c_intro;
	public String c_material;
	@Override
	public String toString() {
		return "ClassInfo [c_code=" + c_code + ", c_group=" + c_group + ", c_name=" + c_name + ", c_personnel="
				+ c_personnel + ", c_intro=" + c_intro + ", c_material=" + c_material + "]";
	}
	
}

