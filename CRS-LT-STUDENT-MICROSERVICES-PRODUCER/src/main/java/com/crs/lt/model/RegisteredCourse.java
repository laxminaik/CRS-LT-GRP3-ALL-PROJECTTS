package com.crs.lt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registeredcourse")
public class RegisteredCourse {

	@Id
	@Column(name = "studentId")
	public String studentId;

	@Column(name = "courseCode")
	public String courseCode;

	@Column(name = "grade")
	public String grade;

	public RegisteredCourse(String courseCode, String studentId, String grade) {
		super();
		this.courseCode = courseCode;
		this.studentId = studentId;
		this.grade = grade;
	}

	public RegisteredCourse() {
		// TODO Auto-generated constructor stub
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "RegisteredCourse [studentId=" + studentId + ", courseCode=" + courseCode + ", grade=" + grade + "]";
	}

}
