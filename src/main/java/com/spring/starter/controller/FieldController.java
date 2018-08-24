package com.spring.starter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.starter.models.Field;
import com.spring.starter.service.FieldService;

@RestController
@RequestMapping(value="/field")
public class FieldController {

	@Autowired
    FieldService fieldService;
	
	@GetMapping("/get-one-field")
	public Field getField() {
		return fieldService.getField();
	}
	
	@GetMapping("/get-all-field")
	public List<Field> getallField() {
		return fieldService.getAllFields();
	}
	
}
