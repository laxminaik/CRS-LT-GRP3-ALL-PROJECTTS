package com.crs.lt.model;

import javax.persistence.Column;

public class Student1 {

	private String userId;
	private String name;

	private String role;

	private String password;

	private String gender;

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

	public void setRole(String role) {
		this.role = role;
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

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student1 [name=" + name + ", role=" + role + ", password=" + password + ", gender=" + gender
				+ ", address=" + address + "]";
	}

}
