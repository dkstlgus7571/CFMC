package data.dto;
//�닔媛뺤떊泥��젙蹂�
public class ClassReg {
	public int cr_memberNo;	//�쉶�썝肄붾뱶
	public int cr_classNo;		//媛뺤쥖肄붾뱶
	public int cr_tutorNo;		//媛뺤궗肄붾뱶
	public int cr_centerNo;	//�떆�꽕肄붾뱶
	public int cr_appliDate;	//�떊泥��궇吏�
	@Override
	public String toString() {
		return "ClassReg [cr_memberNo=" + cr_memberNo + ", cr_classNo=" + cr_classNo + ", cr_tutorNo=" + cr_tutorNo
				+ ", cr_centerNo=" + cr_centerNo + ", cr_appliDate=" + cr_appliDate + "]";
	}
	
}
