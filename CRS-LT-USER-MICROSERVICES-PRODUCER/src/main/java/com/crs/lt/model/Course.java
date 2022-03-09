package com.crs.lt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Course")
public class Course {
	
	
	@Id
//	@GeneratedValue(generator = "uuid")@GenericGenerator(name = "uuid", strategy = "uuid2")
//	@Column(name = "courseCode")
	private String courseCode= "";
	
	@Column(name = "courseName")
	private String courseName;
	
	@Column(name = "instructorId")
	private String instructorId;
	
	@Column(name = "availableSeats")
	private int availableSeats = 10;
	
	
	public Course() {
		// TODO Auto-generated constructor stub
	}
	

	public Course(String courseCode, String courseName, String instructorId,
			int available_seats) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.instructorId = instructorId;
		this.availableSeats = available_seats;
	}


	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int available_seats) {
		this.availableSeats = available_seats;
	}
	
}
