package com.crs.lt.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.crs.lt.dto.RegisterCourseModelClass;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author user206
 *
 */
@RestController
@CrossOrigin
public class StudentController {

	/**
	 * @param studentId
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 */
	@RequestMapping(value = "/student/courses", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> viewCourses(@RequestParam("studentId") String studentId)
			throws RestClientException, IOException {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("studentId", studentId);
		System.out.println(uriVariables);

		RestTemplate restTemplate = new RestTemplate();
		String baseUrl = "http://JavaFulStack-79.alchemycloud.co.in:8092/student/courses?studentId={studentId}";
		ResponseEntity<String> response = null;

		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class, studentId);

		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		return response;
	}
	
	
	@RequestMapping(value = "/student/viewRegisteredCourses", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> viewRegisteredCourses(@RequestParam("studentId") String studentId)
			throws RestClientException, IOException {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("studentId", studentId);
		System.out.println(uriVariables);

		RestTemplate restTemplate = new RestTemplate();
		String baseUrl = "http://JavaFulStack-79.alchemycloud.co.in:8092/student/viewRegisteredCourses?studentId={studentId}";
		ResponseEntity<String> response = null;

		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class, studentId);

		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		return response;
	}

	/**
	 * @param courseCodeList
	 * @param studentId
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 */
	@RequestMapping(value = "/student/registerCourse", method = RequestMethod.POST, produces = {
			"application/json" }, consumes = { "application/json" })
	@ResponseBody
	public ResponseEntity<?> registerCourses(@RequestBody RegisterCourseModelClass courseCodeList,
			@RequestParam("studentId") String studentId) throws RestClientException, IOException {

		RestTemplate restTemplate = new RestTemplate();

		String baseUrl = "http://JavaFulStack-79.alchemycloud.co.in:8092/student/registerCourse?studentId={studentId}";
		ResponseEntity<Boolean> response = null;

		HttpHeaders headers = new HttpHeaders();// set `content-type` header
		headers.setContentType(MediaType.APPLICATION_JSON);// set `accept` header
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		ObjectMapper mapObject = new ObjectMapper();
		Map<String, Object> mapObj = mapObject.convertValue(courseCodeList, Map.class);
		System.out.println(String.valueOf(mapObj));
		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(mapObj, headers);
// send POST request ResponseEntity response = restTemplate.postForEntity(url,
// request, String.class);
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.POST, entity, Boolean.class, studentId);

		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		return response;
	}
	
	@RequestMapping(value = "/makePayment", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> makePayment(@RequestParam(value = "studentId") String studentId)
			throws RestClientException, IOException {

		RestTemplate restTemplate = new RestTemplate();
		String baseUrl = "http://JavaFulStack-79.alchemycloud.co.in:8092/makePayment?studentId={studentId}";
		ResponseEntity<String> response = null;

		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.POST, getHeaders(), String.class, studentId);

		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		return response;
	}

	/**
	 * @param studentId
	 * @param courseCode
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 */
	@RequestMapping(value = "/student/dropCourse", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> deleteCourse(@RequestParam(value = "studentId") String studentId,
			@RequestParam(value = "courseCode") String courseCode) throws RestClientException, IOException {

		RestTemplate restTemplate = new RestTemplate();
		String baseUrl = "http://JavaFulStack-79.alchemycloud.co.in:8092/student/dropCourse?studentId={studentId}&courseCode={courseCode}";
		ResponseEntity<String> response = null;

		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.DELETE, getHeaders(), String.class, studentId,
					courseCode);

		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		return response;
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}

}
