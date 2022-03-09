
package com.crs.lt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.crs.lt.model.Course;
import com.crs.lt.model.RegisteredCourse;



/**
 * @author user206
 *
 */
public interface RegisteredCourseRepository extends CrudRepository<RegisteredCourse, String> {

	 List<RegisteredCourse> findAll();

	public abstract int deleteByCourseCodeAndStudentId(String courseCode, String studentId);
	 
	
	
//	@Query(value = "select * from course inner join registeredcourse on course.courseCode = registeredcourse.courseCode where registeredcourse.studentId =:studentId " ,nativeQuery = true)
//	List<RegisteredCourse> viewRegisteredCourses(@Param(value = "studentId")String studentId);
//
//	int deleteByCourseCodeAndStudentId(String courseCode, String studentId);
	

}
