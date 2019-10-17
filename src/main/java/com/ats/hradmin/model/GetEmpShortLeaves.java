package com.ats.hradmin.model;

public class GetEmpShortLeaves {

	private String id;
	
	private int empId;
	
	private String empFname;
	private String empSname;
	
	private int shLeaveCount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
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

	public int getShLeaveCount() {
		return shLeaveCount;
	}

	public void setShLeaveCount(int shLeaveCount) {
		this.shLeaveCount = shLeaveCount;
	}

	@Override
	public String toString() {
		return "GetEmpShortLeaves [id=" + id + ", empId=" + empId + ", empFname=" + empFname + ", empSname=" + empSname
				+ ", shLeaveCount=" + shLeaveCount + "]";
	}

}
