package com.tradetracker.model;

import java.util.List;

public class UserResponse {

	private Integer id;
	private String username;
	private int hospitalId;
	private int vendorId;
	private int serviceId;
	private Role role;

	public UserResponse(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.hospitalId = user.getHospitalId();
		this.vendorId = user.getVendorId();
		this.serviceId = user.getServiceId();
		this.role = user.getRole();
		// Exclude password from the response
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
