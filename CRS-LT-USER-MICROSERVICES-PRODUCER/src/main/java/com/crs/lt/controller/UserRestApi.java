package com.crs.lt.controller;


import com.crs.lt.service.AdminService;
import com.crs.lt.service.ProfessorService;
import com.crs.lt.service.UserService;
import com.crs.lt.service.StudentService;
import com.crs.lt.model.Student;
import com.crs.lt.model.Student1;
import com.crs.lt.constant.RoleConstant;
import com.crs.lt.exceptions.StudentException;
import com.crs.lt.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * @author user206
 *
 */

@RestController
@CrossOrigin
public class UserRestApi {

    @Autowired
    UserService userService;

    @Autowired
    StudentService studentService;

    @Autowired
    ProfessorService professorService;

    @Autowired
    AdminService adminService;

    /**
     * @param userId
     * @param password
     * @return
     * @throws UserNotFoundException
     * @throws SQLException
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> login(@RequestParam(value = "userId") String userId,
                                   @RequestParam(value = "password") String password) throws UserNotFoundException, SQLException {
        System.out.println(userId);
        System.out.println(password);
        boolean isValidated = userService.verifyCredentials(userId, password);
        System.out.println(isValidated);
        if (isValidated) {
            if (("STUDENT").equals(userService.getRole(userId))) {
                RoleConstant role = RoleConstant.STUDENT;
                try {
					if (studentService.isApproved(userId).equals("0")) {
					    return ResponseEntity.status(HttpStatus.OK)
					            .body("Your admission request is still pending..., login later");
					} else
					    return ResponseEntity.status(HttpStatus.OK).body("Role Type: " + role + " Logged In Successfully");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

            }
            if (("PROFESSOR").equals(userService.getRole(userId))) {
                professorService.getProfessorById(userId);
                RoleConstant role = RoleConstant.PROFESSOR;
                return ResponseEntity.status(HttpStatus.OK).body("Role Type: " + role + " Logged In Successfully");
            }
            if (("ADMIN").equals(userService.getRole(userId))) {
                RoleConstant role = RoleConstant.ADMIN;
                return ResponseEntity.status(HttpStatus.OK).body("Role Type: " + role + " Logged In Successfully");
            }

        }
        return ResponseEntity.status(HttpStatus.OK).body("Invalid userId or Password");
    }

    /**
     * @param userId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/user/getName/{userId}")
    @ResponseBody
    public ResponseEntity<?> getName(@PathVariable("userId") String userId) {
        String result;
        try {
            result = userService.getName(userId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    /**
     * @param userId
     * @param password
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/user/verifyCredentials")
    @ResponseBody
    public ResponseEntity<?> verifyCredentials(@RequestParam(value = "userId") String userId,
                                               @RequestParam(value = "password") String password) {
        boolean result;
        try {

            System.out.println("check **********************");
            result = userService.verifyCredentials(userId, password);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    /**
     * @param userId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/user/getRole/{userId}")
    @ResponseBody
    public ResponseEntity<?> getRole(@PathVariable("userId") String userId) {
        String result;
        try {
            result = userService.getRole(userId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    /**
     * @param userId
     * @param newPassword
     * @param existingPassword
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/user/updatePassword")
    @ResponseBody
    public ResponseEntity<?> updatePassword(@RequestParam(value = "userId") String userId,
                                            @RequestParam(value = "newPassword") String newPassword,
                                            @RequestParam(value = "existingPassword") String existingPassword) {
        boolean result;
        try {
            result = userService.updatePassword(userId, newPassword, existingPassword);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    /**
     * @param student
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST, value = "/register", produces = {"application/json"}, consumes = {"application/json"})
    @ResponseBody
    public ResponseEntity<?> register(@RequestBody Student1 student) throws Exception {
        try {

            String st = studentService.register(student);
            if (st == null) {
                return ResponseEntity.status(HttpStatus.OK).body("Something Went wrong try again later");
            }
            return ResponseEntity.status(201)
                    .body("you are successfully registered");
        } catch (Exception e) {
            throw e;
        }

    }

}