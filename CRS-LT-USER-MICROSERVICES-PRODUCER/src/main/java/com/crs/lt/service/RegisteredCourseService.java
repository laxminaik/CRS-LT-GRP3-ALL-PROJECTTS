package com.crs.lt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crs.lt.exceptions.CourseNotFoundException;
import com.crs.lt.exceptions.StudentException;
import com.crs.lt.model.Course;
import com.crs.lt.model.RegisteredCourse;
import com.crs.lt.model.Student;
import com.crs.lt.repository.CourseRepository;
import com.crs.lt.repository.RegisteredCourseRepository;
import com.crs.lt.repository.StudentRepository;


@Service
public class RegisteredCourseService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	RegisteredCourseRepository registrationRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	public boolean addCourse(String courseCode,String studentId , RegisteredCourse registeredCourse) throws StudentException, CourseNotFoundException {
		System.out.println(courseCode);
		
		boolean result =false;
		Optional<Student> student =	studentRepository.findById(studentId);
		if(student.isPresent()) {
			if("0".equalsIgnoreCase(student.get().getIsRegisterd())) {
				StudentException s = new StudentException();
				s.setMessage("Student course registration is pending");
				throw s;
			}

			List<Course> courseList =courseRepository.findAll();


			Course course =	courseRepository.findByCourseCode(courseCode);
			if(course!= null) {
				if(course.getAvailableSeats()<=0) {
					StudentException s = new StudentException();
					s.setMessage("Seats are not available in : " + courseCode);
					throw s;
				}
			}
			else if(!isCourseValid(courseCode, courseList))
			{
				CourseNotFoundException e = new CourseNotFoundException();
				e.setMessage("Course with courseCode: " + courseCode + " not found.");
				throw e;
			}

			String grade="-";
			
			registeredCourse.setCourseCode(courseCode);
			registeredCourse.setStudentId(studentId);
			registeredCourse.setGrade(grade);
			System.out.println(registeredCourse.toString());
			registrationRepository.save(registeredCourse);
			Course courseOptional = courseRepository.findByCourseCode(courseCode);
			if(courseOptional!= null) {
			
				if(courseOptional.getAvailableSeats()!=0) {
					courseOptional.setAvailableSeats(courseOptional.getAvailableSeats() - 1);
				}
				courseRepository.save(courseOptional);
			}

			System.out.println("Course added");
			result = true ;
		}

		return result;
	}

	private boolean isCourseValid(String courseCode, List<Course> courseList) {
		
		
		//	for (String course : courseCodeList.getCourseList())
		List<Course> availableCourseList = courseRepository.findAll();
			
			
				if(!(availableCourseList.contains(courseCode)))
				{
					StudentException e = new StudentException();
					e.setMessage("Duplicate value  :" + courseCode);
					return false;
			}
		return true;
	}

	public void setRegistrationStatus(String studentId) {
		// TODO Auto-generated method stub
		
	}
}
