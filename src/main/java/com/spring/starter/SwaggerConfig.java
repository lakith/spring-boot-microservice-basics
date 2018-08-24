package com.spring.starter;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT = new Contact("lakith muthugala", "https://www.udemy.com", "lakith1995@gmail.com");
	
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Api Docunatation For Learn Rest", "Api Details", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
	
	private static final Set<String> DEFAULT_PROCEDURES_AND_CONSUMES = new HashSet<String>(Arrays.asList("application/json","application/xml"));  

	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_PROCEDURES_AND_CONSUMES)
				.consumes(DEFAULT_PROCEDURES_AND_CONSUMES);
	}
}
