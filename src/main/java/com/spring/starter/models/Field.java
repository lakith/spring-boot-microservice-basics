package com.spring.starter.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Field {
	
	@JsonIgnore
	public String field;
	public String field2;
	public String field3;
	
	public Field() {
		super();
	}
	
	public Field(String field, String field2, String field3) {
		super();
		this.field = field;
		this.field2 = field2;
		this.field3 = field3;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}
		
}
