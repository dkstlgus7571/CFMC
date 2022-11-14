package data.dto;
//�삁�빟媛��뒫�떆�꽕 �뀒�씠釉�
public class OpenCenter {
	public  String oct_code;		//�떆�꽕肄붾뱶
	public String oct_avaPeri ;	//�씠�슜媛��뒫湲곌컙
	public String oct_revPeri ;	//�삁�빟�떊泥�湲곌컙
	public String oct_revDate;		//�삁�빟�씪�옄
	public String oct_epi;			//�쉶李�
	public String oct_revAva;		//�삁�빟媛��뒫�뿬遺�
	@Override
	public String toString() {
		return "OpenCenter [oct_code=" + oct_code + ", oct_avaPeri=" + oct_avaPeri + ", oct_revPeri=" + oct_revPeri
				+ ", oct_revDate=" + oct_revDate + ", oct_epi=" + oct_epi + ", oct_revAva=" + oct_revAva + "]";
	}
	
}
