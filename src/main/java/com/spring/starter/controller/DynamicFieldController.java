package com.spring.starter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.spring.starter.models.DynamicField;
import com.spring.starter.service.DynamicFilteringService;

@RestController
@RequestMapping("/dynamicFiltering")
public class DynamicFieldController {
	
	@Autowired 
	DynamicFilteringService dynamicFilteringService;
	
	//field1,field2
	@GetMapping(value="getAll")
	public MappingJacksonValue getAllDynamicFields(){
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("dyField","dyField2");
		
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("dynamicFilter", filter);
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(dynamicFilteringService.getAllFields());
		mappingJacksonValue.setFilters(filterProvider);
		return mappingJacksonValue;
	}
	
	//field2,field3
	@GetMapping(value="getOne")
	public MappingJacksonValue getAoneDynamicField() {
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("dyField3");
		
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("dynamicFilter", filter);
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(dynamicFilteringService.getOneField());
		mappingJacksonValue.setFilters(filterProvider);
		
		return mappingJacksonValue;
	}
	
	
}
