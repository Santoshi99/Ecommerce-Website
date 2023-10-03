package com.ecommapp.backendproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.ecommapp.backendproject.dto.UserDTO;
import com.ecommapp.backendproject.service.UserService;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	public UserService userservice;
	
	
	@PostMapping("/create")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userdto){
		
		Date date = new Date();
		userdto.setDate(date);
		UserDTO user = this.userservice.createUser(userdto);
		return new ResponseEntity<UserDTO>(user,HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{userId}")
	public ResponseEntity<UserDTO> getById(@PathVariable int userId){
		
		UserDTO user = this.userservice.getUserById(userId);
		return new ResponseEntity<UserDTO>(user,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable int userId){
	    this.userservice.deleteUser(userId);
	    return new ResponseEntity<String>("Delete Successful",HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<UserDTO>> getAll(){
		List<UserDTO> listofusers = this.userservice.findAllUser();
		return new ResponseEntity<List<UserDTO>>(listofusers, HttpStatus.OK);
	}
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDTO>  updateUserById(@PathVariable int userId, @RequestBody UserDTO userobj){
		
		UserDTO updatedUser = this.userservice.updateUser(userId,userobj);
		return new ResponseEntity<UserDTO>(updatedUser,HttpStatus.ACCEPTED);
	}
}
