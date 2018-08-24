package com.spring.starter.models;

import java.net.URI;

public class Url {
	
	private String name;
	private URI uri;
	
	
	public Url(String name, URI uri) {
		super();
		this.name = name;
		this.uri = uri;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public URI getUri() {
		return uri;
	}
	public void setUri(URI uri) {
		this.uri = uri;
	}
	
	

}
