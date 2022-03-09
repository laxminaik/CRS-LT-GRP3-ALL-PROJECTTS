package com.crs.lt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crs.lt.constant.GenderConstant;
import com.crs.lt.exceptions.CourseNotFoundException;
import com.crs.lt.exceptions.StudentException;
import com.crs.lt.model.Course;
import com.crs.lt.model.PaymentInfo;
import com.crs.lt.model.RegisterCourseModelClass;
import com.crs.lt.model.RegisteredCourse;
import com.crs.lt.model.Student;
import com.crs.lt.model.Student1;
import com.crs.lt.model.User;
import com.crs.lt.repository.CourseRepository;
import com.crs.lt.repository.PaymentRepository;
import com.crs.lt.repository.RegisteredCourseRepository;
import com.crs.lt.repository.StudentRepository;
import com.crs.lt.repository.UserRepository;

@Service
public class StudentService {

	@Autowired
	RegisteredCourseRepository registeredCourseRepository;
	
	@Autowired
	PaymentRepository paymentRepository;
	
//	@Autowired
//	CourseRepository courseRepository;
	
	@Autowired
	RegisteredCourseService registeredCourseService;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Transactional
	public String isApproved(String userId) {
	Student student=	studentRepository.findByStudentId(userId);
	
		if(student!= null)
		{
			 return  student.getIsApproved();
		}
		return "0";
	}

	@Transactional
	public String register(Student1 student) {
		User user = new User();
		Student stud= new Student ();
		
		user.setName(student.getName()  );
		user.setRole("Student");
		user.setPassword(student.getPassword());
		user.setGender(student.getGender());
		
		user.setAddress(student.getAddress());
		user.setUserId(student.getUserId());
		userRepository.save(user);
		
		stud.setBatch(11);
		stud.setBranchName("CS");
		stud.setStudentId(student.getUserId());
		
		stud.setIsApproved("0");
		stud.setIsRegisterd("0");
		 studentRepository.save(stud);
		return stud.getStudentId();

	}

	@Transactional
	public List<Course> viewCourses(String studentId) {
		List<Course> availableCourseList = registeredCourseService.getAllCourses();
		return availableCourseList;
	}
	
	@Transactional
	public List<RegisteredCourse> viewRegisteredCourses(String studentId) {
		return registeredCourseRepository.findAll();
	}
	
	@Transactional
	public boolean regiseterCourses(RegisterCourseModelClass courseCodeList, String studentId) throws StudentException, CourseNotFoundException {
		List<Course> availableCourseList = registeredCourseService.getAllCourses();
	//	Set<String> hash_set = new HashSet<String>();
		System.out.println(String.valueOf(availableCourseList));
		List<String> existingCourses = new ArrayList<String>();
	//	for (String course : courseCodeList.getCourseList())
		
		
		for (Course courseCode : availableCourseList) {
			existingCourses.add(courseCode.getCourseCode());
		
		}
		
		System.out.println(String.valueOf(existingCourses));
		
		for (String courseCode : courseCodeList.getCourseList())
		{
			System.out.println(courseCode);
			
			if(!(existingCourses.contains(courseCode)))
			{
				StudentException e = new StudentException();
				e.setMessage("Course does not exist  :" + courseCode);
				throw e;
		}
		}
//			this.isCourseValid(courseCode, availableCourseList);
//
//			if (!hash_set.add(courseCode)) {
//				StudentException e = new StudentException();
//				e.setMessage("Duplicate value  :" + courseCode);
//				throw  e;
//			}

		

	//	List<Course> registeredCourseList = this.viewRegisteredCourses(studentId);

		for (String courseCode : courseCodeList.getCourseList()) {
			System.out.println(courseCodeList);
			RegisteredCourse registeredCourse=new RegisteredCourse();
			
			if(registeredCourseService.addCourse(courseCode, studentId,registeredCourse)) {
				System.out.println("if****************");
		     registeredCourseService.setRegistrationStatus(studentId);
		     }
		    }
		return true;
	}
	

	@Transactional
	public int deleteCourse(String courseCode, String studentId) {

		return registeredCourseRepository.deleteByCourseCodeAndStudentId(courseCode, studentId);
	}
	
	@Transactional
	public PaymentInfo makePayment(String studentId)throws StudentException  {
		PaymentInfo paymentInfo =  new PaymentInfo();
		double fee = 200;
		boolean isRegistered = false;
		boolean isPaid = false;
		isRegistered = registeredCourseService.getRegistrationStatus(studentId);
		isPaid = this.getPaymentStatus(studentId);

		if (!isRegistered) {
			StudentException e = new StudentException();
			e.setMessage("You havent registered for the course");
			System.out.println("You have not registered yet");
			throw  e;
		}

		if (isRegistered && isPaid) {

			fee = this.calculateFee(studentId);
			paymentInfo.setStudentId(studentId);
			paymentInfo.setTotalfee(fee);
			paymentInfo.setModeOfPayment("debit  card");
			System.out.println("Your total fee  = " + fee);
			System.out.println("Payment Successful by StudentId :" + studentId);
		//	boolean paymentStatus = this.setPaymentStatus(studentId);
			paymentRepository.save(paymentInfo);
			return paymentInfo;

		}

		return paymentInfo;
	}

//	private boolean setPaymentStatus(String studentId) {
//		Optional<Student> studentOptional = studentRepository.findById(studentId);
//		if(studentOptional.isPresent()) {
//			Student student =	studentOptional.get();
//	//		student.setIsPaid("1");
//			studentRepository.save(student);
//			return true;
//		}
//		return false;
//	}

	private double calculateFee(String studentId) {
		return  registeredCourseRepository.calulateFee(studentId);
	}

	private boolean getPaymentStatus(String studentId) {

		boolean paymentStatus = false;
		Student student = studentRepository.findByStudentId(studentId);

		if(student != null) {
			
			List<PaymentInfo> paymentList = paymentRepository.findByStudentId(studentId);
			if(paymentList.size()>0)
			{
				paymentStatus= true;
			}
			}

		

		return paymentStatus;
	}
	

	
	

}
