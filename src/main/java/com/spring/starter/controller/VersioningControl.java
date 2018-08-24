package com.spring.starter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.starter.models.Name;
import com.spring.starter.models.PersonV1;
import com.spring.starter.models.PersonV2;

@RestController
@RequestMapping(value="/person")
public class VersioningControl {
	
/*	@GetMapping
	public String testingApi() {
		return "test pass";
	}*/

	@GetMapping(value="/produces", produces="application/vnd.company.app-v1+json")
	public PersonV1 getPersonHeader() {
		return new PersonV1("lakith Muthugala");
	}
	
	@GetMapping(value="/produces", produces="application/vnd.company.app-v2+json")
	public PersonV2 getPerson2Header() {
		
		Name name = new Name();
		name.setFirst_name("lakith");
		name.setLast_name("muthugala");
		return new PersonV2(name);
	}
}
