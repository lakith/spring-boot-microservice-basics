package com.spring.starter.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.i18n.LocaleContextHolder;

@RestController
@RequestMapping(value="/hello")
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping
	public String internationalizedHello(/*@RequestHeader(name="Accept-language", required=false) Locale locale*/) {
		return messageSource.getMessage("good.morning.message", null,LocaleContextHolder.getLocale());
	}	
}
