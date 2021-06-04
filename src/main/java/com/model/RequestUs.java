package com.model;

import java.sql.Timestamp;

public class RequestUs {
	private String name;
	private String email;
	private String message;
	private Timestamp dateTime;
	private boolean isActive;
	
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getMessage() {
		return message;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
