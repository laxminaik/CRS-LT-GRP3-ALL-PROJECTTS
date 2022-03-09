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

import com.crs.lt.dto.Student1;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author user206
 *
 */
@RestController
@CrossOrigin
public class UserController {

	/**
	 * @param userId
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 */
	@RequestMapping(value = "/getName/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getName(@PathVariable("userId") String userId)
			throws RestClientException, IOException {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("userId", userId);
		System.out.println(uriVariables);

		RestTemplate restTemplate = new RestTemplate();
		String baseUrl = "http://JavaFulStack-79.alchemycloud.co.in:8093/user/getName/{userId}";
		ResponseEntity<String> response = null;

		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class, uriVariables);

		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		return response;
	}

	/**
	 * @param student
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	public ResponseEntity<?> register(@RequestBody Student1 student) throws RestClientException, IOException {

		RestTemplate restTemplate = new RestTemplate();

		String baseUrl = "http://JavaFulStack-79.alchemycloud.co.in:8093/register";
		ResponseEntity<String> response = null;

		System.out.println(String.valueOf(student));

		

		HttpHeaders headers = new HttpHeaders();// set `content-type` header
		headers.setContentType(MediaType.APPLICATION_JSON);// set `accept` header
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		ObjectMapper mapObject = new ObjectMapper();
		Map<String, Object> mapObj = mapObject.convertValue(student, Map.class);
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
	 * @param userId
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 */
	@RequestMapping(value = "/getRole/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getRole(@PathVariable("userId") String userId)
			throws RestClientException, IOException {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("userId", userId);
		System.out.println(uriVariables);

		RestTemplate restTemplate = new RestTemplate();
		String baseUrl = "http://JavaFulStack-79.alchemycloud.co.in:8093/user/getRole/{userId}";
		ResponseEntity<String> response = null;

		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class, uriVariables);

		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		return response;
	}
	
	
	/**
	 * @param userId
	 * @param password
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 */
	@RequestMapping(value = "/verifyCredentials", method = RequestMethod.GET, produces = { "application/json" }, consumes = {
	"application/json" })
	@ResponseBody
	public ResponseEntity<String> verifyCredentials(@RequestParam(value = "userId") String userId,
            @RequestParam(value = "password") String password)
			throws RestClientException, IOException {

		RestTemplate restTemplate = new RestTemplate();
		String baseUrl = "http://JavaFulStack-79.alchemycloud.co.in:8093/user/verifyCredentials?userId={userId}&password={password}";
		ResponseEntity<String> response = null;

		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class, userId,password);

		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		return response;
	}
	

	/**
	 * @param userId
	 * @param password
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> login(@RequestParam(value = "userId") String userId,
            @RequestParam(value = "password") String password)
			throws RestClientException, IOException {

		RestTemplate restTemplate = new RestTemplate();
		String baseUrl = "http://JavaFulStack-79.alchemycloud.co.in:8093/login?userId={userId}&password={password}";
		ResponseEntity<String> response = null;

		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.POST, getHeaders(), String.class, userId,password);

		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		return response;
	}
	
	/**
	 * @param userId
	 * @param newPassword
	 * @param existingPassword
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 */
	@RequestMapping(value = "/updatePassword", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<String> updatePassword(@RequestParam(value = "userId") String userId,
            @RequestParam(value = "newPassword") String newPassword,
            @RequestParam(value = "existingPassword") String existingPassword)
			throws RestClientException, IOException {

		RestTemplate restTemplate = new RestTemplate();
		String baseUrl = "http://JavaFulStack-79.alchemycloud.co.in:8093/user/updatePassword?userId={userId}&newPassword={newPassword}&existingPassword={existingPassword}";
		ResponseEntity<String> response = null;

		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.PUT, getHeaders(), String.class, userId,newPassword,existingPassword);

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
