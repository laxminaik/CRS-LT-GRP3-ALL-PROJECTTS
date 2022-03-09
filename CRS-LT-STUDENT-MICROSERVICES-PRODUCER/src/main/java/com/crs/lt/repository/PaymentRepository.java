package com.crs.lt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.crs.lt.model.Catalog;
import com.crs.lt.model.Course;
import com.crs.lt.model.PaymentInfo;



public interface PaymentRepository extends JpaRepository<PaymentInfo, Integer> {
    List<PaymentInfo> findByStudentId(String StudentId);
}

