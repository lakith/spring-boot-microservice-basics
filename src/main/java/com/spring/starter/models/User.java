package com.spring.starter.models;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.management.relation.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity(name="user")
@ApiModel("All details about the user.")
@JsonIgnoreProperties(value= {"password"})
public class User {
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "name", length = 200, nullable = false)
	@NotNull
	private String name;
	
	@Column(name = "email", length = 100, nullable = false)
	@NotNull
	@ApiModelProperty(notes="email cannot be null and it must be valied")
	private String email;
	
	@Column(name = "userName", length = 150, unique = true, nullable = false)
	@NotNull
	@Pattern(regexp = "^[a-z0-9]*$",message="username must be in this format '^[a-z0-9]*$' ")
	private String username;
	
	@Column(name = "password", length = 280 ,nullable = false)
	@NotNull
	@Size(min = 5, max = 50)
	private String password;
	
	@Column(name = "roles")
	private Set<Role> roles = new HashSet<>();  
	
	
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	public User(@NotNull String name, @NotNull String email,
			@NotNull @Pattern(regexp = "^[a-z0-9]*$", message = "username must be in this format '^[a-z0-9]*$' ") String username,
			@NotNull @Size(min = 5, max = 50) String password, Set<Role> roles) {
		super();
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public User(String id, @NotNull String name, @NotNull String email,
			@NotNull @Pattern(regexp = "^[a-z0-9]*$", message = "username must be in this format '^[a-z0-9]*$' ") String username,
			@NotNull @Size(min = 5, max = 50) String password, Set<Role> roles) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public User() {
		super();
	}
	
	public User(String id, @NotNull String name, @NotNull String email,
			@NotNull @Pattern(regexp = "^[a-z0-9]*$") String username,
			@NotNull @Size(min = 5, max = 50) String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	public User(@NotNull String name, @NotNull String email, @NotNull @Pattern(regexp = "^[a-z0-9]*$") String username,
			@NotNull @Size(min = 5, max = 50) String password) {
		super();
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
