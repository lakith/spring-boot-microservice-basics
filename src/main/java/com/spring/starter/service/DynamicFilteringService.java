package com.spring.starter.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.starter.models.DynamicField;

@Service
public class DynamicFilteringService {

	public List<DynamicField> getAllFields(){
		return Arrays.asList(new DynamicField("dyfield 1-1","dyfield 1-2","dyfield 1-3"),
							 new DynamicField("dyfield 2-1","dyfield 2-2","dyfield 2-3"),
							 new DynamicField("dyfield 3-1","dyfield 3-2","dyfield 3-3"));
	}
	
	public DynamicField getOneField() {
		return new DynamicField("dyfield 4-1","dyfield 4-2","dyfield 4-3");
	}
}
