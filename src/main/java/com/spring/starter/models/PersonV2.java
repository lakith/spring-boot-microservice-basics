package com.spring.starter.models;

public class PersonV2 {

	public Name name;

	public PersonV2(Name name) {
		super();
		this.name = name;
	}

	public PersonV2() {
		super();
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

}
