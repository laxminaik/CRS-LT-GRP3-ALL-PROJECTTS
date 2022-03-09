package com.crs.lt.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.crs.lt.dto.Course1;
import com.crs.lt.dto.Professor1;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author user206
 *
 */


/**
 * @author user206
 *
 */
@RestController
@CrossOrigin
public class AdminController {

	/**
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 */
	@RequestMapping(value = "/admin/courses", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> courses() throws RestClientException, IOException {

		String baseUrl = "http://JavaFulStack-79.alchemycloud.co.in:8091/admin/courses";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		return response;
	}

	/**
	 * @param courseCode
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 */
	@RequestMapping(value = "/admin/deleteCourse", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> deleteCourse(@RequestParam(value = "courseCode") String courseCode)
			throws RestClientException, IOException {

		RestTemplate restTemplate = new RestTemplate();
		String baseUrl = "http://JavaFulStack-79.alchemycloud.co.in:8091/admin/deleteCourse?courseCode={courseCode}";
		ResponseEntity<String> response = null;

		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.DELETE, getHeaders(), String.class, courseCode);

		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		return response;
	}

	/**
	 * @param studentId
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 */
	@RequestMapping(value = "/admin/approve", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> approveAdmissionRequest(@RequestParam(value = "studentId") String studentId)
			throws RestClientException, IOException {

		RestTemplate restTemplate = new RestTemplate();
		String baseUrl = "http://JavaFulStack-79.alchemycloud.co.in:8091/admin/approve?studentId={studentId}";
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
	 * @param professor1
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 */
	@RequestMapping(value = "/admin/addProfessor", method = RequestMethod.POST, produces = {
			"application/json" }, consumes = { "application/json" })
	@ResponseBody
	public ResponseEntity<?> addProfessor(@RequestBody Professor1 professor1) throws RestClientException, IOException {

		RestTemplate restTemplate = new RestTemplate();

		String baseUrl = "http://JavaFulStack-79.alchemycloud.co.in:8091/admin/addProfessor";
		ResponseEntity<String> response = null;

		System.out.println(String.valueOf(professor1));

		HttpHeaders headers = new HttpHeaders();// set `content-type` header
		headers.setContentType(MediaType.APPLICATION_JSON);// set `accept` header
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		ObjectMapper mapObject = new ObjectMapper();
		Map<String, Object> mapObj = mapObject.convertValue(professor1, Map.class);
		System.out.println(String.valueOf(mapObj));
		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(mapObj, headers);
// send POST request ResponseEntity response = restTemplate.postForEntity(url,
// request, String.class);
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.POST, entity, String.class);

		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		return response;
	}

	/**
	 * @param course1
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 */
	@RequestMapping(value = "/admin/addCourse", method = RequestMethod.POST, produces = {
			"application/json" }, consumes = { "application/json" })
	@ResponseBody
	public ResponseEntity<?> addCourse(@RequestBody Course1 course1) throws RestClientException, IOException {

		RestTemplate restTemplate = new RestTemplate();

		String baseUrl = "http://JavaFulStack-79.alchemycloud.co.in:8091/admin/addCourse";
		ResponseEntity<String> response = null;

		System.out.println(String.valueOf(course1));

		HttpHeaders headers = new HttpHeaders();// set `content-type` header
		headers.setContentType(MediaType.APPLICATION_JSON);// set `accept` header
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		ObjectMapper mapObject = new ObjectMapper();
		Map<String, Object> mapObj = mapObject.convertValue(course1, Map.class);
		System.out.println(String.valueOf(mapObj));
		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(mapObj, headers);

		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.POST, entity, String.class);

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
