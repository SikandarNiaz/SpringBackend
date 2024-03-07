package com.tradetracker.model;

import java.util.List;

public class AuthenticationResponse {
	private String token;
	private String message;
	private UserResponse user;
	private List<Menu> menus;
	private List<Hospital> hospitals;

	public AuthenticationResponse(String token, String message, User user, List<Menu> menus, List<Hospital> hospitals) {
		this.token = token;
		this.message = message;
		this.user = new UserResponse(user);
		this.menus = menus;
		this.hospitals = hospitals;
	}

	public String getToken() {
		return token;
	}

	public String getMessage() {
		return message;
	}

	public UserResponse getUser() {
		return user;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public List<Hospital> getHospitals() {
		return hospitals;
	}

}