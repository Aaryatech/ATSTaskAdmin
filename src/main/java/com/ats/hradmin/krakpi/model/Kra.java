package com.ats.hradmin.krakpi.model;

 

 
public class Kra {
	 
	private int kraId;
	
  	private int empId;
	
  	private int yearId;
	
 	private String kraTitle ;
	
	private String remark; 
	
	private int acceptedFlag ;

	private int approvedFlag ;

	private int approvedBy;
	
	private String acceptedDate ;
	
	private String approvedDate  ;
	
 	private int delStatus;

	private int isActive;
	
	private int makerUserId;

	private String makerEnterDatetime;

	private int exInt1;

	private int exInt2;

	private int exInt3;

	private String exVar1;

	private String exVar2;

	private String exVar3;

	private boolean isError;

	public int getKraId() {
		return kraId;
	}

	public void setKraId(int kraId) {
		this.kraId = kraId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getYearId() {
		return yearId;
	}

	public void setYearId(int yearId) {
		this.yearId = yearId;
	}

	public String getKraTitle() {
		return kraTitle;
	}

	public void setKraTitle(String kraTitle) {
		this.kraTitle = kraTitle;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getAcceptedFlag() {
		return acceptedFlag;
	}

	public void setAcceptedFlag(int acceptedFlag) {
		this.acceptedFlag = acceptedFlag;
	}

	public int getApprovedFlag() {
		return approvedFlag;
	}

	public void setApprovedFlag(int approvedFlag) {
		this.approvedFlag = approvedFlag;
	}

	public int getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(int approvedBy) {
		this.approvedBy = approvedBy;
	}

  	public String getAcceptedDate() {
		return acceptedDate;
	}

	public void setAcceptedDate(String acceptedDate) {
		this.acceptedDate = acceptedDate;
	}
	
  	public String getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(String approvedDate) {
		this.approvedDate = approvedDate;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getMakerUserId() {
		return makerUserId;
	}

	public void setMakerUserId(int makerUserId) {
		this.makerUserId = makerUserId;
	}

	public String getMakerEnterDatetime() {
		return makerEnterDatetime;
	}

	public void setMakerEnterDatetime(String makerEnterDatetime) {
		this.makerEnterDatetime = makerEnterDatetime;
	}

	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}

	public int getExInt2() {
		return exInt2;
	}

	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}

	public int getExInt3() {
		return exInt3;
	}

	public void setExInt3(int exInt3) {
		this.exInt3 = exInt3;
	}

	public String getExVar1() {
		return exVar1;
	}

	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}

	public String getExVar2() {
		return exVar2;
	}

	public void setExVar2(String exVar2) {
		this.exVar2 = exVar2;
	}

	public String getExVar3() {
		return exVar3;
	}

	public void setExVar3(String exVar3) {
		this.exVar3 = exVar3;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	@Override
	public String toString() {
		return "Kra [kraId=" + kraId + ", empId=" + empId + ", yearId=" + yearId + ", kraTitle=" + kraTitle
				+ ", remark=" + remark + ", acceptedFlag=" + acceptedFlag + ", approvedFlag=" + approvedFlag
				+ ", approvedBy=" + approvedBy + ", acceptedDate=" + acceptedDate + ", approvedDate=" + approvedDate
				+ ", delStatus=" + delStatus + ", isActive=" + isActive + ", makerUserId=" + makerUserId
				+ ", makerEnterDatetime=" + makerEnterDatetime + ", exInt1=" + exInt1 + ", exInt2=" + exInt2
				+ ", exInt3=" + exInt3 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exVar3=" + exVar3
				+ ", isError=" + isError + ", getKraId()=" + getKraId() + ", getEmpId()=" + getEmpId()
				+ ", getYearId()=" + getYearId() + ", getKraTitle()=" + getKraTitle() + ", getRemark()=" + getRemark()
				+ ", getAcceptedFlag()=" + getAcceptedFlag() + ", getApprovedFlag()=" + getApprovedFlag()
				+ ", getApprovedBy()=" + getApprovedBy() + ", getAcceptedDate()=" + getAcceptedDate()
				+ ", getApprovedDate()=" + getApprovedDate() + ", getDelStatus()=" + getDelStatus() + ", getIsActive()="
				+ getIsActive() + ", getMakerUserId()=" + getMakerUserId() + ", getMakerEnterDatetime()="
				+ getMakerEnterDatetime() + ", getExInt1()=" + getExInt1() + ", getExInt2()=" + getExInt2()
				+ ", getExInt3()=" + getExInt3() + ", getExVar1()=" + getExVar1() + ", getExVar2()=" + getExVar2()
				+ ", getExVar3()=" + getExVar3() + ", isError()=" + isError() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	


}
