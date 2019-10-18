package com.ats.hradmin.model;

public class EmpWorkHrsRep {
	private int empId;

	private String empBudHr;

	private String empSname;

	private String empFname;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpBudHr() {
		return empBudHr;
	}

	public void setEmpBudHr(String empBudHr) {
		this.empBudHr = empBudHr;
	}

	public String getEmpSname() {
		return empSname;
	}

	public void setEmpSname(String empSname) {
		this.empSname = empSname;
	}

	public String getEmpFname() {
		return empFname;
	}

	public void setEmpFname(String empFname) {
		this.empFname = empFname;
	}

	@Override
	public String toString() {
		return "EmpWorkHrsRep [empId=" + empId + ", empBudHr=" + empBudHr + ", empSname=" + empSname + ", empFname="
				+ empFname + "]";
	}

}
