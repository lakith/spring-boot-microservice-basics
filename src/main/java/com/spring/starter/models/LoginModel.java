package com.spring.starter.models;

public class LoginModel {

	private String username;
	private String password;
	
	public LoginModel() {
		super();
	}

	public LoginModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
