package data.dto;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.*;
public class MemberInfo {
	private int mCode;
	private String mName;
	private int mBirth;
	private String mPhoneNum;
	private String mEmail;
	private String mPw;
	private Date mDate;

	public int getmCode() {
		return mCode;
	}
	public void setmCode(int mCode) {
		this.mCode = mCode;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public int getmBirth() {
		return mBirth;
	}
	public void setmBirth(int mBirth) {
		this.mBirth = mBirth;
	}
	public String getmPhoneNum() {
		return mPhoneNum;
	}
	public void setmPhoneNum(String mPhoneNum) {
		this.mPhoneNum = mPhoneNum;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public String getmPw() {
		return mPw;
	}
	public void setmPw(String mPw) {
		this.mPw = mPw;
	}
	public Date getmDate() {
		return mDate;
	}
	public void setmDate(Date mDate) {
		this.mDate = mDate;
	}
	
	@Override
	public String toString() {
		return "MemberInfo [mCode=" + mCode + ", mName=" + mName + ", m_birth=" + mBirth + ", mPhoneNum=" + mPhoneNum
				+ ", mEmail=" + mEmail + ", mPw=" + mPw + ", mDate=" + mDate + "]";
	}
	
	
	
}
