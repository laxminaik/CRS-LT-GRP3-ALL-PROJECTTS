package com.crs.lt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.crs.lt.model.Course;
import com.crs.lt.model.Student;



public interface StudentRepository extends CrudRepository<Student, String> {

	Student findByStudentId(String userId);

//	 List<Student> findAll();
	
}
