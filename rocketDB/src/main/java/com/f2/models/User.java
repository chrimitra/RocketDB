package com.f2.models;

public class User {

	private String ip;
	
	private String username;

	public User() {
		super();
	}

	public User(String ip, String username) {
		super();
		this.ip = ip;
		this.username = username;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
		
}
