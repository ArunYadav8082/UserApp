package com.arun.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arun.bussinesException.UserNotFoundException;
import com.arun.dto.UserRequest;
import com.arun.entity.UserRegistration;

import com.arun.service.UserServiceImp;

@RestController
@RequestMapping("/users")
public class UserRegistrationController {
	
	@Autowired
	private UserServiceImp service;
	
	@PostMapping("/add")
	public ResponseEntity<UserRegistration> saveUser(@RequestBody @Valid UserRequest userRequest)
	{
		return new ResponseEntity<>(service.saveUser(userRequest),HttpStatus.CREATED);
		
	}
	@GetMapping("/fetchAll")
	public ResponseEntity<List<UserRegistration>> getAllUser()
	{
		return ResponseEntity.ok(service.getAllUser());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity< UserRegistration> getUser(@PathVariable int id) throws UserNotFoundException
	{
		return ResponseEntity.ok(service.getUser(id));
		
	}
}
