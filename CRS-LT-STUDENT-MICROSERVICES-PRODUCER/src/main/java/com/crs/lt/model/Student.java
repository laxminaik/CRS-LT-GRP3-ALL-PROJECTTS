package com.crs.lt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.crs.lt.constant.GenderConstant;
import com.crs.lt.constant.RoleConstant;

@Entity
@Table(name = "Student")
public class Student {

	@Id
	public String studentId;

	@Column(name = "branch")
	public String branchName;

	@Column(name = "batch")
	int batch;

	@Column(name = "isApproved")
	String isApproved;

	@Column(name = "isRegistered")
	public String isRegistered;

	public String getIsRegisterd() {
		return isRegistered;
	}

	public void setIsRegisterd(String isRegistered) {
		this.isRegistered = isRegistered;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public int getBatch() {
		return batch;
	}

	public void setBatch(int batch) {
		this.batch = batch;
	}

	public String getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}

	public Student() {

		// TODO Auto-generated constructor stub
	}

	public Student(String userId, String name, RoleConstant role, String password, GenderConstant gender,
			String address, String branchName, String studentId, int batch, String isApproved, String isRegistered,
			boolean isPaid, boolean isReportGenerated) {

		this.branchName = branchName;
		this.studentId = studentId;
		this.batch = batch;
		this.isApproved = isApproved;
		this.isRegistered = isRegistered;

	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", branchName=" + branchName + ", batch=" + batch + ", isApproved="
				+ isApproved + ", isRegisterd=" + isRegistered + "]";
	}

}
