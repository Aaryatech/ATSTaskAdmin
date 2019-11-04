package com.ats.hradmin.leave.model;


public class GetPendingLeaveCount {

	private int id;
	private int pendingLeaveCount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPendingLeaveCount() {
		return pendingLeaveCount;
	}
	public void setPendingLeaveCount(int pendingLeaveCount) {
		this.pendingLeaveCount = pendingLeaveCount;
	}
	@Override
	public String toString() {
		return "GetPendingLeaveCount [id=" + id + ", pendingLeaveCount=" + pendingLeaveCount + ", getId()=" + getId()
				+ ", getPendingLeaveCount()=" + getPendingLeaveCount() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
