package com.crs.lt.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * @author user206
 *
 */
@RestController
@CrossOrigin
public class ProfessorController {
	
	/**
	 * @param profId
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 */
	@RequestMapping(value = "/getProfessorById", method = RequestMethod.GET, produces = { "application/json" }, consumes = {
	"application/json" })
	@ResponseBody
	public ResponseEntity<String> verifyCredentials(@RequestParam("profId") String profId)
			throws RestClientException, IOException {

		RestTemplate restTemplate = new RestTemplate();
		String baseUrl = "http://JavaFulStack-79.alchemycloud.co.in:8094/getProfessorById?profId={profId}";
		ResponseEntity<String> response = null;

		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class, profId);

		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		return response;
	}
	
	/**
	 * @param profId
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 */
	@RequestMapping(value = "/viewEnrolledStudents/{profId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getName(@PathVariable("profId") String profId)
			throws RestClientException, IOException {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("profId", profId);
		System.out.println(uriVariables);

		RestTemplate restTemplate = new RestTemplate();
		String baseUrl = "http://JavaFulStack-79.alchemycloud.co.in:8094/viewEnrolledStudents/{profId}";
		ResponseEntity<String> response = null;

		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class, uriVariables);

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

	/**
	 * @param studentID
	 * @param courseID
	 * @param grade
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 */
	@RequestMapping(value = "/addGrade", method = RequestMethod.POST, produces = { "application/json" }, consumes = {
	"application/json" })
	@ResponseBody
	public ResponseEntity<String> addGrade(@RequestParam(value = "studentID") String studentID,
			@RequestParam(value = "courseID") String courseID, @RequestParam(value = "grade") String grade)
			throws RestClientException, IOException {

		RestTemplate restTemplate = new RestTemplate();
		String baseUrl = "http://JavaFulStack-79.alchemycloud.co.in:8094/addGrade?studentID={studentID}&courseID={courseID}&grade={grade}";
		ResponseEntity<String> response = null;

		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.POST, getHeaders(), String.class, studentID,courseID,grade);

		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		return response;
	}
}
