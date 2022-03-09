package com.crs.lt.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crs.lt.exceptions.CourseExistsAlreadyException;
import com.crs.lt.exceptions.CourseNotDeletedException;
import com.crs.lt.exceptions.CourseNotFoundException;
import com.crs.lt.exceptions.StudentException;
//import com.crs.lt.model.Catalog;
import com.crs.lt.model.Course;
import com.crs.lt.model.Course1;
//import com.crs.lt.model.Grade;
import com.crs.lt.model.Professor;
import com.crs.lt.model.Professor1;
import com.crs.lt.model.Student;
import com.crs.lt.service.AdminService;

/**
 * @author user206
 *
 */
@RestController
@CrossOrigin
public class AdminRestApi {

	@Autowired
	AdminService adminService;

//	@Autowired
//	UserService userService;

//	@Autowired
//	RegistrationService registrationService;
	private static Logger logger = Logger.getLogger(AdminRestApi.class);

	/**
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/admin/courses")
	@ResponseBody
	private ResponseEntity<?> viewCourses() throws SQLException {
		System.out.println("In view courses");
		List<Course> courseList = new ArrayList<>();
		try {
			courseList = adminService.viewCourses();
			if (courseList.size() == 0) {
				logger.error("Nothing present in the catalogue!");
				return ResponseEntity.status(HttpStatus.OK).body(courseList);
			}
			logger.info("Courses present in the course catalogue!!");
			return ResponseEntity.status(HttpStatus.OK).body(courseList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
		}

	}

	@RequestMapping(consumes = { "application/json" }, produces = {
			"application/json" }, method = RequestMethod.POST, value = "/admin/addCourse")
	@ResponseBody
	public ResponseEntity<?> addCourse(@RequestBody Course1 course1) throws SQLException, CourseExistsAlreadyException {
		Course c1 = new Course();
		c1.setCourseCode(course1.getCourseCode());
		c1.setCourseName(course1.getCourseName());
		c1.setInstructorId(course1.getInstructorId());
		c1.setAvailableSeats(course1.getAvailableSeats());

		// List<Course> courseList = adminService.viewCourses();
		adminService.addCourse(c1);

		// List<Course> courseListView = adminService.viewCourses();
		return ResponseEntity.status(HttpStatus.OK).body(c1);
		// return ResponseEntity.status(HttpStatus.OK).body("Course Added sucessfully");

	}

	/**
	 * @param professor1
	 * @return
	 * @throws SQLException
	 * @throws CourseExistsAlreadyException
	 */
	@RequestMapping(consumes = { "application/json" }, produces = {
			"application/json" }, method = RequestMethod.POST, value = "/admin/addProfessor")
	@ResponseBody
	public ResponseEntity<?> addProfessor(@RequestBody Professor1 professor1)
			throws SQLException, CourseExistsAlreadyException {
		Professor p1 = new Professor();
		p1.setProfessorID(professor1.getProfessorID());
		p1.setDepartment(professor1.getDepartment());
		p1.setDesignation(professor1.getDesignation());

		// List<Course> courseList = adminService.viewCourses();
		adminService.addProfessor(p1);

		// List<Course> courseListView = adminService.viewCourses();
		return ResponseEntity.status(HttpStatus.OK).body(p1);
		// return ResponseEntity.status(HttpStatus.OK).body("Course Added sucessfully");

	}

	/**
	 * /admin/deleteCourse REST-services for dropping a course from catalog
	 * 
	 * @param courseCode
	 * @return
	 * @throws SQLException
	 */

	@RequestMapping(method = RequestMethod.DELETE, value = "/admin/deleteCourse")
	@ResponseBody
	public ResponseEntity<?> deleteCourse(@RequestParam(value = "courseCode") String courseCode) throws SQLException {
		List<Course> courseList = adminService.viewCourses();

		adminService.deleteCourse(courseCode, courseList);
		return ResponseEntity.status(HttpStatus.OK)
				.body("Course with courseCode: " + courseCode + " deleted from catalog");
	}

	/**
	 * @param studentId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/admin/approve")
	@ResponseBody
	public ResponseEntity<?> approveAdmissionRequest(@RequestParam(value = "studentId") String studentId) {
		try {
			boolean isApproved = adminService.approveStudentRequest(studentId);
			System.out.println(isApproved);
			if (isApproved) {
				return ResponseEntity.status(HttpStatus.OK).body(
						"Admission Request for student with student ID: " + studentId + " approved successfully.");

			}
		} catch (StudentException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(400)
				.body("Admission Request for student with student ID: " + studentId + " cannot be approved.");

	}

	@RequestMapping(method = RequestMethod.GET, value = "/admin/viewPendingAdmissions")
	@ResponseBody
	public ResponseEntity<?> viewPendingAdmissions() {

		List<Student> pendingStudentsList = adminService.viewPendingAdmissions();
		if (pendingStudentsList.size() == 0) {
			System.out.println("No students pending approvals");
			return ResponseEntity.status(HttpStatus.OK).body(pendingStudentsList);
			// return pendingStudentsList;
		}
		// System.out.println(String.format("%20s | %20s | %20s", "StudentId", "Name",
		// "GenderConstant"));

		return ResponseEntity.status(HttpStatus.OK).body(pendingStudentsList);
	}

}
