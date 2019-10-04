package com.ats.hradmin.model;
  
public class WorkType {
 
	private int workTypeId;
	
	private String workTypeName;
	
	private String workTypeDesc ;
	
	private int makerUserId;
	
	private int delStatus ;
	
	private String shortName ;
 	
 	private int isActive;
 	
 	private String updateDatetime ;
 	
 	private String exVar1 ;
 	
 	private int exInt1;

	public int getWorkTypeId() {
		return workTypeId;
	}

	public void setWorkTypeId(int workTypeId) {
		this.workTypeId = workTypeId;
	}

	public String getWorkTypeName() {
		return workTypeName;
	}

	public void setWorkTypeName(String workTypeName) {
		this.workTypeName = workTypeName;
	}

	public String getWorkTypeDesc() {
		return workTypeDesc;
	}

	public void setWorkTypeDesc(String workTypeDesc) {
		this.workTypeDesc = workTypeDesc;
	}

	public int getMakerUserId() {
		return makerUserId;
	}

	public void setMakerUserId(int makerUserId) {
		this.makerUserId = makerUserId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(String updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	public String getExVar1() {
		return exVar1;
	}

	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}

	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}
	
 
	@Override
	public String toString() {
		return "WorkType [workTypeId=" + workTypeId + "  , workTypeName=" + workTypeName
				+ ", workTypeDesc=" + workTypeDesc + ", makerUserId=" + makerUserId + ", delStatus=" + delStatus
				+ ", shortName=" + shortName + ", isActive=" + isActive + ", updateDatetime=" + updateDatetime
				+ ", exVar1=" + exVar1 + ", exInt1=" + exInt1 + "]";
	}

	 

}
