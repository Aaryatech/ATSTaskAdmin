package com.ats.hradmin.model;

public class ProjectWiseHrsCount {

	private int projectId;

	private String projectTitle;

	private String workHrs;

	private String projectEstMhrs;

	public String getProjectEstMhrs() {
		return projectEstMhrs;
	}

	public void setProjectEstMhrs(String projectEstMhrs) {
		this.projectEstMhrs = projectEstMhrs;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

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

	@Override
	public String toString() {
		return "ProjectWiseHrsCount [projectId=" + projectId + ", projectTitle=" + projectTitle + ", workHrs=" + workHrs
				+ ", projectEstMhrs=" + projectEstMhrs + "]";
	}

}
