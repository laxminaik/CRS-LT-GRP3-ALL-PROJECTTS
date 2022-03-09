package com.crs.lt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.crs.lt.model.Catalog;
import com.crs.lt.model.Course;



public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAll();
    Course findByCourseCode(String courseCode);
     public abstract int deleteByCourseCode(String courseCode);
//   List<Course> findOne(String studentId);
//   Optional<Course> findById(String studentId);
    //save()
    //findOne
    //exists
    //delete
    //deleteAll
	
}

