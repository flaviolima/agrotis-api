package com.agrotis.agrotisapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agrotis.agrotisapi.builders.ResponseBuilder;
import com.agrotis.agrotisapi.entity.User;
import com.agrotis.agrotisapi.exceptions.ResourceNotFound;
import com.agrotis.agrotisapi.requests.UserRequest;
import com.agrotis.agrotisapi.responses.UserResponse;
import com.agrotis.agrotisapi.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/users")
	public UserResponse create(@RequestBody UserRequest request) throws ResourceNotFound {
		User user = userService.create(request);
		return ResponseBuilder.build(user);
	}

	@GetMapping("/users")
	public List<UserResponse> findAll() throws Exception {
		List<User> users = userService.findAll();
		return ResponseBuilder.build(users);
	}
	
	@GetMapping("/users/{id}")
	public UserResponse findById(@PathVariable Long id) throws Exception {
		User user = userService.findById(id);
		return ResponseBuilder.build(user);
	}

	@PutMapping("/users/{id}")
	public UserResponse updateUser(@PathVariable Long id, @RequestBody UserRequest request) throws ResourceNotFound {
		User user = userService.update(id, request);
		return ResponseBuilder.build(user);

	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id) throws ResourceNotFound {
		userService.delete(id);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}

}
