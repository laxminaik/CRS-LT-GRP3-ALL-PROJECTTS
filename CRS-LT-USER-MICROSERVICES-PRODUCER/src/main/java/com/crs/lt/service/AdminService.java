package com.crs.lt.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crs.lt.exceptions.CourseExistsAlreadyException;
import com.crs.lt.exceptions.CourseNotDeletedException;
import com.crs.lt.exceptions.CourseNotFoundException;
import com.crs.lt.exceptions.StudentException;
import com.crs.lt.model.Catalog;
import com.crs.lt.model.Course;
import com.crs.lt.model.Professor;
import com.crs.lt.model.RegisteredCourse;
import com.crs.lt.model.Student;

import com.crs.lt.repository.CourseRepository;
import com.crs.lt.repository.ProfessorRepository;
import com.crs.lt.repository.StudentRepository;
import com.crs.lt.validators.AdminValidator;

@Service
public class AdminService {

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	ProfessorRepository professorRepository;

	@Transactional
	public List<Course> viewCourses() {
		return courseRepository.findAll();

	}

	@Transactional
	public void addCourse(Course course) {
		courseRepository.save(course);

	}

	@Transactional
	public void addProfessor(Professor professor) throws SQLException {
		professorRepository.save(professor);
	}

	@Transactional
	public int deleteCourse(String courseCode, List<Course> courseList) {

		return courseRepository.deleteByCourseCode(courseCode);

	}
	
//	@Transactional
//	public List<Student> viewPendingAdmissions() throws SQLException {
//		// TODO Auto-generated method stub
//		return studentRepository.findAll();
//	}

	@Transactional
	public boolean approveStudentRequest(String studentId) throws StudentException {
		boolean isApprove =  false ;
		Optional<Student> student =  studentRepository.findById(studentId);
		if(student.isPresent()) {
			if("1".equalsIgnoreCase(student.get().getIsApproved())) {
				StudentException e =  new StudentException();
				e.setMessage("Student allready approved!");
				throw e;
				
			}
			student.get().setIsApproved("1");
			studentRepository.save(student.get());
			isApprove = true;
		}
		/// admin repo nedd calll here 

		return isApprove;
	}

}
