package com.crs.lt.dto;



public class Course1 {

	
	private String courseCode;
	
	
	private String courseName;
	
	
	private String instructorId;
	
	
	private int availableSeats = 10;


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


	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
}
