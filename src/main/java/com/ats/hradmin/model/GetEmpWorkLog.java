package com.ats.hradmin.model;
 

import com.fasterxml.jackson.annotation.JsonFormat;

 
public class GetEmpWorkLog {
	
	 
	private int workLogId;
	
	private int logType;
	
	private int projectId;
	
	private int workTypeId;
	
	private int empId;
	
	private String  workDate;
	
	private String  workDesc;
	
	private String  projectTitle;
	
	private String  empFname;
	
	private String  empSname;
	
	private String  workHrs;

 
	public int getWorkLogId() {
		return workLogId;
	}

	public void setWorkLogId(int workLogId) {
		this.workLogId = workLogId;
	}

	public int getLogType() {
		return logType;
	}

	public void setLogType(int logType) {
		this.logType = logType;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getWorkTypeId() {
		return workTypeId;
	}

	public void setWorkTypeId(int workTypeId) {
		this.workTypeId = workTypeId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

 
	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

	public String getWorkDesc() {
		return workDesc;
	}

	public void setWorkDesc(String workDesc) {
		this.workDesc = workDesc;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getEmpFname() {
		return empFname;
	}

	public void setEmpFname(String empFname) {
		this.empFname = empFname;
	}

	public String getEmpSname() {
		return empSname;
	}

	public void setEmpSname(String empSname) {
		this.empSname = empSname;
	}

	public String getWorkHrs() {
		return workHrs;
	}

	public void setWorkHrs(String workHrs) {
		this.workHrs = workHrs;
	}

	@Override
	public String toString() {
		return "GetEmpWorkLog [workLogId=" + workLogId + ", logType=" + logType + ", projectId=" + projectId
				+ ", workTypeId=" + workTypeId + ", empId=" + empId + ", workDate=" + workDate + ", workDesc="
				+ workDesc + ", projectTitle=" + projectTitle + ", empFname=" + empFname + ", empSname=" + empSname
				+ ", workHrs=" + workHrs + "]";
	}

	 
	
	
	

}
