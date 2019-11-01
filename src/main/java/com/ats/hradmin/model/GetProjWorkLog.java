package com.ats.hradmin.model;

public class GetProjWorkLog {
	private int workLogId;
	
	//private String  workDate;
	
	private String  projectTitle;
	
	private String  workHrs;
	
	private int projectId;

	public int getWorkLogId() {
		return workLogId;
	}

	public void setWorkLogId(int workLogId) {
		this.workLogId = workLogId;
	}

	/*public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}*/

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getWorkHrs() {
		return workHrs;
	}

	public void setWorkHrs(String workHrs) {
		this.workHrs = workHrs;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "GetProjWorkLog [workLogId=" + workLogId + ", projectTitle=" + projectTitle
				+ ", workHrs=" + workHrs + ", projectId=" + projectId + "]";
	}
	
}
