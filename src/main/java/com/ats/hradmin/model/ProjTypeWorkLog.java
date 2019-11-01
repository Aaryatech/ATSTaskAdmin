package com.ats.hradmin.model;

public class ProjTypeWorkLog {
	
	private int workLogId;
	private int projectId;
	private int workTypeId;
	private String projectTitle;
	private String workTypeName;
	private String workHrs;
	public int getWorkLogId() {
		return workLogId;
	}
	public void setWorkLogId(int workLogId) {
		this.workLogId = workLogId;
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
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public String getWorkTypeName() {
		return workTypeName;
	}
	public void setWorkTypeName(String workTypeName) {
		this.workTypeName = workTypeName;
	}
	public String getWorkHrs() {
		return workHrs;
	}
	public void setWorkHrs(String workHrs) {
		this.workHrs = workHrs;
	}
	@Override
	public String toString() {
		return "ProjTypeWorkLog [workLogId=" + workLogId + ", projectId=" + projectId + ", workTypeId=" + workTypeId
				+ ", projectTitle=" + projectTitle + ", workTypeName=" + workTypeName + ", workHrs=" + workHrs + "]";
	}
	
	
}
