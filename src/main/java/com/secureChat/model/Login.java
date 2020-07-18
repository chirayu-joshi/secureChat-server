package com.secureChat.model;

public class Login {

	private boolean userExist;
	private String firstname;
	private String lastname;
	private long uid;

	public Login(boolean userExist, String firstname, String lastname, long uid) {
		super();
		this.userExist = userExist;
		this.firstname = firstname;
		this.lastname = lastname;
		this.uid = uid;
	}

	public boolean isUserExist() {
		return userExist;
	}

	public void setUserExist(boolean userExist) {
		this.userExist = userExist;
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

	public long getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	
}
