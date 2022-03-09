package com.crs.lt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.crs.lt.constant.GenderConstant;
import com.crs.lt.constant.RoleConstant;

@Entity
@Table(name = "professor")
public class Professor {

	@Id
	@Column(name = "instructorId")
	private String professorID;
	@Column(name = "department")
	private String department;
	@Column(name = "designation")
	private String designation;

	public String getProfessorID() {
		return professorID;
	}

	public void setProfessorID(String professorID) {
		this.professorID = professorID;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Professor(String userId, String name, RoleConstant role, String password, GenderConstant gender,
			String address, String professorID, String department, String designation) {

		this.professorID = professorID;
		this.department = department;
		this.designation = designation;
	}

	public Professor() {

		// TODO Auto-generated constructor stub
	}

	public Professor(String userId, String name, RoleConstant role, String password, GenderConstant gender,
			String address) {

		// TODO Auto-generated constructor stub
	}

}
