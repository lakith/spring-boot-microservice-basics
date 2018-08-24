package com.spring.starter.models;

import java.util.Date;

public class GenaricExeptionModel {
	
	private Date date;
	private String message;
	private String details;
	public GenaricExeptionModel(Date date, String message, String details) {
		super();
		this.date = date;
		this.message = message;
		this.details = details;
	}
	
	public GenaricExeptionModel() {
		super();
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	

}
