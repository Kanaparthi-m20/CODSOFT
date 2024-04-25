package com.example.demo.request;

public class JwtToken {
	String JwtToken;
	String message;
	
	public JwtToken() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getJwtToken() {
		return JwtToken;
	}

	public void setJwtToken(String jwtToken) {
		JwtToken = jwtToken;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public JwtToken(String jwtToken, String message) {
		super();
		JwtToken = jwtToken;
		this.message = message;
	}
}
