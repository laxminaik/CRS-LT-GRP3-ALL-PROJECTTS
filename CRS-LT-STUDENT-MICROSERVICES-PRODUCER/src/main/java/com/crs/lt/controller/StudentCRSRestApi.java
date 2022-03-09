package com.crs.lt.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

import com.crs.lt.exceptions.CourseNotFoundException;
import com.crs.lt.exceptions.SeatNotAvailableException;
import com.crs.lt.exceptions.StudentException;
import com.crs.lt.model.Course;
import com.crs.lt.model.PaymentInfo;
import com.crs.lt.model.RegisterCourseModelClass;
import com.crs.lt.model.RegisteredCourse;
import com.crs.lt.service.StudentService;

/**
 * @author user206
 *
 */
@RestController
@CrossOrigin
public class StudentCRSRestApi {

	@Autowired
	private StudentService studentService;

//
//	@Autowired
//	private RegisteredCourseService registeredCourseService;
//
//
	/**
	 * @param studentId
	 * @return
	 */
	/**
	 * @param studentId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/student/courses")
	@ResponseBody
	public ResponseEntity<?> viewCourses(@RequestParam(value = "studentId") String studentId) {
		List<Course> courseList = new ArrayList<Course>();
		try {
			courseList = studentService.viewCourses(studentId);

		} catch (Exception e) {
			e.getMessage();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error in viewing courses");
		}

		return ResponseEntity.status(HttpStatus.OK).body(courseList);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/student/viewRegisteredCourses")
	@ResponseBody
	public ResponseEntity<?> viewRegisteredCourses(@RequestParam(value = "studentId") String studentId) {
		List<RegisteredCourse> courseList = new ArrayList<RegisteredCourse>();
		try {
			courseList = studentService.viewRegisteredCourses(studentId);

		} catch (Exception e) {
			e.getMessage();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error in viewing courses");
		}

		return ResponseEntity.status(HttpStatus.OK).body(courseList);
	}
	
	/**
	 * @param courseCodeList
	 * @param studentId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/student/registerCourse")
	@ResponseBody
	public ResponseEntity<?> registerCourses(@RequestBody RegisterCourseModelClass courseCodeList,
			@RequestParam("studentId") String studentId) {
		boolean result = false;
		try {
			result = studentService.regiseterCourses(courseCodeList, studentId);
		} catch (StudentException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		} catch (CourseNotFoundException e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	/**
	 * @param studentId
	 * @param courseCode
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/student/dropCourse")
	@ResponseBody
	public ResponseEntity<?> deleteCourse(@RequestParam(value = "studentId") String studentId,
			@RequestParam(value = "courseCode") String courseCode) throws SQLException {
//		List<RegisteredCourse> courseList = studentService.viewCourses(studentId);
		studentService.deleteCourse(studentId, courseCode);
		return ResponseEntity.status(HttpStatus.OK).body("Course deleted  : " + studentId);

	}
	
	@RequestMapping(value = "/makePayment", method = RequestMethod.POST)
	public ResponseEntity<?> makePayment(@RequestParam(value = "studentId") String studentId) throws SQLException {
		PaymentInfo result =  new PaymentInfo();
		try {
			result =  studentService.makePayment(studentId);
		} catch (StudentException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}catch (Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

}
