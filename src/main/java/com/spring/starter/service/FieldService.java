package com.spring.starter.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.starter.models.Field;

@Service
public class FieldService {

	public List<Field> getAllFields(){
		return Arrays.asList(new Field("field= 1-1","field= 1-2","field= 1-3"),
				new Field("field= 2-1","field= 2-2","field= 2-3"),
				new Field("field= 3-1","field= 3-2","field= 3-3"));
		
	}
	
	public Field getField() {
		return new Field("field= 1-1","field= 1-2","field= 1-3");
	}
	
}
