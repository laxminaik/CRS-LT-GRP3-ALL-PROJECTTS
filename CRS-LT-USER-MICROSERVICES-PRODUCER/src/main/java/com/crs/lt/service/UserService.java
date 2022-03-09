package com.crs.lt.service;

import java.sql.SQLException;

import com.crs.lt.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crs.lt.model.User;
import com.crs.lt.exceptions.UserNotFoundException;

@Service
public class UserService  {
	private static Logger logger = Logger.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	public static User user = null;


    @Transactional
	public User getUserFromUserId(String userId){
		return userRepository.findByUserId(userId);
	}

    @Transactional
	public boolean verifyCredentials(String userId, String password) throws UserNotFoundException, SQLException {
		User user = getUserFromUserId(userId);
		if (user != null){
			// Verify the credentials
			if (user.getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}
    @Transactional
	public String getRole(String userId) throws SQLException {
		User user = getUserFromUserId(userId);
		if (user!= null){
			return user.getRole().toString();
		}
		return String.valueOf(null);
	}

    @Transactional
	public boolean updatePassword(String userID, String newPassword, String existingPassword) throws SQLException {
		User user = getUserFromUserId(userID);
		if (user!= null){
			//Check existing password
			if (!(user.getPassword().equalsIgnoreCase(existingPassword))){
				return false;
			}
			user.setPassword(newPassword);
			userRepository.save(user);
			return true;
		}
		return false;
	}

    @Transactional
	public String getName(String userId) throws SQLException {
		User user = getUserFromUserId(userId);
		if (user != null){
			return user.getName();
		}
		return String.valueOf(null);
	}






}