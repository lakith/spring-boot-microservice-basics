package com.spring.starter.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;

import com.spring.starter.errors.UserNotFoundExeption;
import com.spring.starter.models.Url;
import com.spring.starter.models.User;
import com.spring.starter.service.UserService;



@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userservice;

	@GetMapping
	public List<User> getAllUsers() {
		
		return userservice.getAllUsers();
	}

	@PostMapping
	public Url saveUser(@Valid @RequestBody User user) {
		user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		userservice.saveUser(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();
		Url url = new Url("user-url", location);
		System.out.println(location);
		return url;
	}

	@GetMapping(value = "/{id}")
	public Resource<Optional<User>> getSpecificUser(@PathVariable("id") String id) {
		Optional<User> user = 	userservice.getUser(id);
		if(user.get().getName() == null) {
			throw new UserNotFoundExeption("user "+id+" cannot found");
		}else {
		
		ControllerLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).getAllUsers());	
		Resource<Optional<User>> resource = new Resource<Optional<User>>(user,linkBuilder.withRel("all-users"));
		return resource;
		}
	}

	@PutMapping(value = "/{id}")
	public User updateUser(@RequestBody User user, @PathVariable("id") String id) {
		userservice.updateUser(user);
		return user;
	}

	@DeleteMapping(value = "/{id}")
	public Optional<User> deleteUser(@PathVariable String id) {
		return userservice.deleteUser(id);
	}
}