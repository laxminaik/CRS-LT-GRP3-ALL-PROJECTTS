package com.crs.lt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.crs.lt.constant.GenderConstant;
import com.crs.lt.constant.RoleConstant;


@Entity
@Table(name = "admin")
public class Admin  {

	@Id
	@Column(name="adminId")
	private String adminID;

	public Admin(String userId, String name, RoleConstant role, String password, GenderConstant gender, String address,
			String adminID) {
		
	}

	public Admin() {
	
		// TODO Auto-generated constructor stub
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

}
