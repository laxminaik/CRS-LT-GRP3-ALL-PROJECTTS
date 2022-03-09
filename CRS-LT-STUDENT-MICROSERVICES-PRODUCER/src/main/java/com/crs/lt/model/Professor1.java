package com.crs.lt.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class Professor1 {

	
	
	private String professorID;
	
	private String department;
	
	private String designation;

	
	
	public Professor1() {
		
		// TODO Auto-generated constructor stub
	}

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

	public Professor1(String professorID, String department, String designation) {
		super();
		this.professorID = professorID;
		this.department = department;
		this.designation = designation;
	}
	
	
	
}
