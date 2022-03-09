package com.crs.lt.exceptions;

public class CourseNotFoundException extends Exception{

private String courseCode;
	
	public CourseNotFoundException()
	{	
		this.courseCode = courseCode;
	}

	public String getCourseCode()
	{
		return courseCode;
	}

	@Override
	public String getMessage() 
	{
		return "Course with courseCode: " + courseCode + " not found.";
	}

	public void setMessage(String courseCode) {
		// TODO Auto-generated method stub
		
		
	}
}
