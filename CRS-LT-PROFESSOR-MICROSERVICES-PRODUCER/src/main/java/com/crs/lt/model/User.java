package com.crs.lt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.crs.lt.constant.GenderConstant;
import com.crs.lt.constant.RoleConstant;

@Entity
@Table(name = "User")
public class User {
	 
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "userId")
	private String userId= "user1";

	@Column(name = "name")
	private String name;

	@Column(name = "role")
	private String role;

	@Column(name = "password")
	private String password;

	@Column(name = "gender")
	private String gender;

	@Column(name = "address")
	private String address;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String roleConstant) {
		this.role = roleConstant;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String genderConstant) {
		this.gender = genderConstant;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User(String userId, String name, String role, String password, String gender, String address) {
		this.userId = userId;
		this.name = name;
		this.role = role;
		this.password = password;
		this.gender = gender;
		this.address = address;
	}

	public User() {

		// TODO Auto-generated constructor stub
	}

}
