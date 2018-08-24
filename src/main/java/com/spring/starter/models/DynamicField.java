package com.spring.starter.models;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("dynamicFilter")
public class DynamicField {

	private String dyField;
	private String dyField2;
	private String dyField3;
	
	public DynamicField() {
		super();
	}

	public DynamicField(String dyField, String dyField2, String dyField3) {
		super();
		this.dyField = dyField;
		this.dyField2 = dyField2;
		this.dyField3 = dyField3;
	}

	public String getDyField() {
		return dyField;
	}

	public void setDyField(String dyField) {
		this.dyField = dyField;
	}

	public String getDyField2() {
		return dyField2;
	}

	public void setDyField2(String dyField2) {
		this.dyField2 = dyField2;
	}

	public String getDyField3() {
		return dyField3;
	}

	public void setDyField3(String dyField3) {
		this.dyField3 = dyField3;
	}
	
}

