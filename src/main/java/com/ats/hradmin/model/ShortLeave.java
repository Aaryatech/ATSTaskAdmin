package com.ats.hradmin.model;

import java.util.Date;
import java.util.List;

public class ShortLeave {

	private int shLeaveId;
	
	private String shLeaveDesc;
	private String shLeaveDate;
	
	private int shLeaveEmpId;
	
	private String slDuration;
	private int shLeaveYear;
	private int shLeaveMonth;
	
	private int isApproved;
	private int approverId;
	
	private String addDttime; 
	private String apprDttime; 
	private String updateDttime; 
	
	private int makerUserId;
	
	private int delStatus;
	
	
	List<String> mailNotifEmpList;
	
	public List<String> getMailNotifEmpList() {
		return mailNotifEmpList;
	}

	public void setMailNotifEmpList(List<String> mailNotifEmpList) {
		this.mailNotifEmpList = mailNotifEmpList;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getShLeaveId() {
		return shLeaveId;
	}

	public void setShLeaveId(int shLeaveId) {
		this.shLeaveId = shLeaveId;
	}

	public String getShLeaveDesc() {
		return shLeaveDesc;
	}

	public void setShLeaveDesc(String shLeaveDesc) {
		this.shLeaveDesc = shLeaveDesc;
	}

	public String getShLeaveDate() {
		return shLeaveDate;
	}

	public void setShLeaveDate(String shLeaveDate) {
		this.shLeaveDate = shLeaveDate;
	}

	public int getShLeaveEmpId() {
		return shLeaveEmpId;
	}

	public void setShLeaveEmpId(int shLeaveEmpId) {
		this.shLeaveEmpId = shLeaveEmpId;
	}

	public String getSlDuration() {
		return slDuration;
	}

	public void setSlDuration(String slDuration) {
		this.slDuration = slDuration;
	}

	public int getShLeaveYear() {
		return shLeaveYear;
	}

	public void setShLeaveYear(int shLeaveYear) {
		this.shLeaveYear = shLeaveYear;
	}

	public int getShLeaveMonth() {
		return shLeaveMonth;
	}

	public void setShLeaveMonth(int shLeaveMonth) {
		this.shLeaveMonth = shLeaveMonth;
	}

	public int getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(int isApproved) {
		this.isApproved = isApproved;
	}

	public int getApproverId() {
		return approverId;
	}

	public void setApproverId(int approverId) {
		this.approverId = approverId;
	}

	public String getAddDttime() {
		return addDttime;
	}

	public void setAddDttime(String addDttime) {
		this.addDttime = addDttime;
	}

	public String getApprDttime() {
		return apprDttime;
	}

	public void setApprDttime(String apprDttime) {
		this.apprDttime = apprDttime;
	}

	public String getUpdateDttime() {
		return updateDttime;
	}

	public void setUpdateDttime(String updateDttime) {
		this.updateDttime = updateDttime;
	}

	public int getMakerUserId() {
		return makerUserId;
	}

	public void setMakerUserId(int makerUserId) {
		this.makerUserId = makerUserId;
	}

	@Override
	public String toString() {
		return "ShortLeave [shLeaveId=" + shLeaveId + ", shLeaveDesc=" + shLeaveDesc + ", shLeaveDate=" + shLeaveDate
				+ ", shLeaveEmpId=" + shLeaveEmpId + ", slDuration=" + slDuration + ", shLeaveYear=" + shLeaveYear
				+ ", shLeaveMonth=" + shLeaveMonth + ", isApproved=" + isApproved + ", approverId=" + approverId
				+ ", addDttime=" + addDttime + ", apprDttime=" + apprDttime + ", updateDttime=" + updateDttime
				+ ", makerUserId=" + makerUserId + ", delStatus=" + delStatus + ", mailNotifEmpList=" + mailNotifEmpList
				+ "]";
	}
	
}
