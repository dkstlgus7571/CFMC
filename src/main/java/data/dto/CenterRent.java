package data.dto;
//��愿��떊泥��젙蹂�
public class CenterRent {
	public int ctr_memberNo;	//�쉶�썝肄붾뱶
	public int ctr_centerNo;	//�떆�꽕肄붾뱶
	public int ctr_reservDate;	//��愿��궇吏�
	public int ctr_appliDate;	//�떊泥��궇吏�
	@Override
	public String toString() {
		return "CenterRent [ctr_memberNo=" + ctr_memberNo + ", ctr_centerNo=" + ctr_centerNo + ", ctr_reservDate="
				+ ctr_reservDate + ", ctr_appliDate=" + ctr_appliDate + "]";
	}
	
}
