package data.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class CenterRent {
	
	private int ctr_mCode;	
	private String ctr_ctCode;	
	private Date ctr_revDate;	
	private String ctr_EPI;
	private Date ctr_appliDate;
	private String ctr_ctName;
	private String ctr_ctFacName;
	private String ctr_ctFacKind;
	private String ctr_epiUseStart;
	private String ctr_epiUseEnd;
	
	public int getCtr_mCode() {
		return ctr_mCode;
	}


	public void setCtr_mCode(int ctr_mCode) {
		this.ctr_mCode = ctr_mCode;
	}


	public String getCtr_ctCode() {
		return ctr_ctCode;
	}


	public void setCtr_ctCode(String ctr_ctCode) {
		this.ctr_ctCode = ctr_ctCode;
	}


	public Date getCtr_revDate() {
		return ctr_revDate;
	}


	public void setCtr_revDate(Date ctr_revDate) {
		this.ctr_revDate = ctr_revDate;
	}


	public String getCtr_EPI() {
		return ctr_EPI;
	}


	public void setCtr_EPI(String ctr_EPI) {
		this.ctr_EPI = ctr_EPI;
	}


	public Date getCtr_appliDate() {
		return ctr_appliDate;
	}


	public void setCtr_appliDate(Date ctr_appliDate) {
		this.ctr_appliDate = ctr_appliDate;
	}


	public String getCtr_ctName() {
		return ctr_ctName;
	}


	public void setCtr_ctName(String ctr_ctName) {
		this.ctr_ctName = ctr_ctName;
	}


	public String getCtr_ctFacName() {
		return ctr_ctFacName;
	}


	public void setCtr_ctFacName(String ctr_ctFacName) {
		this.ctr_ctFacName = ctr_ctFacName;
	}


	public String getCtr_ctFacKind() {
		return ctr_ctFacKind;
	}


	public void setCtr_ctFacKind(String ctr_ctFacKind) {
		this.ctr_ctFacKind = ctr_ctFacKind;
	}


	public String getCtr_epiUseStart() {
		return ctr_epiUseStart;
	}


	public void setCtr_epiUseStart(String ctr_epiUseStart) {
		this.ctr_epiUseStart = ctr_epiUseStart;
	}


	public String getCtr_epiUseEnd() {
		return ctr_epiUseEnd;
	}


	public void setCtr_epiUseEnd(String ctr_epiUseEnd) {
		this.ctr_epiUseEnd = ctr_epiUseEnd;
	}



	
	@Override
	public String toString() {
		return "CenterRent [ctr_mCode=" + ctr_mCode + ", ctr_ctCode=" + ctr_ctCode + ", ctr_EPI=" + ctr_EPI + "]";
	}
	

		
	
	
}