package data.dto;

public class OpenClass {
	public int oc_code; //媛쒖꽕肄붾뱶
	public int oc_c_code; //媛뺤쥖肄붾뱶
	public int oc_t_code; //媛뺤궗肄붾뱶
	public int oc_ct_code;	//�떆�꽕肄붾뱶
	public String oc_acceptPeri; //�젒�닔湲곌컙
	public String oc_classPeri; //媛뺤쥖湲곌컙
	public String oc_classDay;	//�닔媛뺤슂�씪
	@Override
	public String toString() {
		return "OpenClass [oc_code=" + oc_code + ", oc_c_code=" + oc_c_code + ", oc_t_code=" + oc_t_code
				+ ", oc_ct_code=" + oc_ct_code + ", oc_acceptPeri=" + oc_acceptPeri + ", oc_classPeri=" + oc_classPeri
				+ ", oc_classDay=" + oc_classDay + "]";
	}

}
