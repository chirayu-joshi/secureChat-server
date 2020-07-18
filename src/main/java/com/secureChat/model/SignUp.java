package com.secureChat.model;

public class SignUp {
	
	private boolean userCreated;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	
	public SignUp(boolean userCreated, String firstname, String lastname, String email, String password) {
		super();
		this.userCreated = userCreated;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}
	
	public boolean isUserCreated() {
		return userCreated;
	}
	public void setUserCreated(boolean userCreated) {
		this.userCreated = userCreated;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
