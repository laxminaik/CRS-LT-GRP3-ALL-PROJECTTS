package com.crs.lt.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "registeredcourse")
public class RegisterCourseModelClass {

	public List<String> courseList;

	public RegisterCourseModelClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegisterCourseModelClass(List<String> courseList) {
		super();
		this.courseList = courseList;
	}

	public List<String> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<String> courseList) {
		this.courseList = courseList;
	}

}
