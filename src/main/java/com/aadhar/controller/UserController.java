package com.aadhar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aadhar.DTO.UserDTO;
import com.aadhar.exception.AadharCardException;
import com.aadhar.service.UserServiceImpl;

@RestController
@RequestMapping(value="/AadharCard")
public class UserController {
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping(value="/users")
	public ResponseEntity<List<UserDTO>> getAllUsers() throws AadharCardException{
		List<UserDTO> userList = userService.getAllUsers();
		return new ResponseEntity<>(userList, HttpStatus.OK);
		
	}
	
	@GetMapping(value="user/{aadharNumber}")
	public ResponseEntity<UserDTO> getUser(@PathVariable Long aadharNumber) throws AadharCardException{
		UserDTO userDTO = userService.getUser(aadharNumber);
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
		
	}
	
	@PostMapping(value="/registerUser")
	public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO ) throws AadharCardException{
		Long aadharNumber = userService.registerUser(userDTO);
		String successMessage = environment.getProperty("UserController.SUCCESSFUL_REGISTRATION");
		
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
		
	}
	
	@PutMapping(value="/user/{aadharNumber}")
	public ResponseEntity<String> updateUser(@PathVariable Long aadharNumber , @RequestBody UserDTO userDTO) throws AadharCardException{
		userService.updateUser(aadharNumber, userDTO.getPhoneNo());
		String successMessage = environment.getProperty("UserController.SUCCESSFUL_REGISTRATION");
		
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
		
	}
	
	@DeleteMapping(value="/user/{aadharNumber}")
	public ResponseEntity<String> deleteUser(@PathVariable Long aadharNumber) throws AadharCardException{
		userService.deleteUser(aadharNumber);
		String successMessage = environment.getProperty("UserController.SUCCESSFUL_REGISTRATION");
		
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
		
		
	}
	

}
