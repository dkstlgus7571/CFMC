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
	
	public String getC_code() {
		return c_code;
	}

	public void setC_code(String c_code) {
		this.c_code = c_code;
	}

	public String getC_group() {
		return c_group;
	}

	public void setC_group(String c_group) {
		this.c_group = c_group;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public int getC_personnel() {
		return c_personnel;
	}

	public void setC_personnel(int c_personnel) {
		this.c_personnel = c_personnel;
	}

	public String getC_intro() {
		return c_intro;
	}

	public void setC_intro(String c_intro) {
		this.c_intro = c_intro;
	}

	public String getC_material() {
		return c_material;
	}

	public void setC_material(String c_material) {
		this.c_material = c_material;
	}
	
	
	
}

