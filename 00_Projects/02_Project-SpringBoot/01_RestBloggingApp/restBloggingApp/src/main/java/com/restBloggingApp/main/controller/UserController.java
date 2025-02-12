package com.restBloggingApp.main.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restBloggingApp.main.dto.BaseResponse;
import com.restBloggingApp.main.dto.UserDTO;
import com.restBloggingApp.main.serviceI.UserServiceI;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	UserServiceI userServiceI;
	
	// handler to handle add new user in database
	@PostMapping(value="/add-user", consumes = "application/json")
	public ResponseEntity<BaseResponse<UserDTO>> addUser(@Valid @RequestBody UserDTO userDTO){
		
		BaseResponse<UserDTO> baseResponse = new BaseResponse<>(201,"New User is added.",this.userServiceI.addUser(userDTO));
		
		return new ResponseEntity<>(baseResponse,HttpStatus.CREATED);	
	}
	
	// handler to get all users available in database
	@GetMapping(value="/get-allUsers", produces = "application/json")
	public ResponseEntity<BaseResponse<List<UserDTO>>>	getAllUsers(){
		this.userServiceI.getAllUsers();
		
		BaseResponse<List<UserDTO>> baseResponse = new BaseResponse<>(200,"Users Found.",this.userServiceI.getAllUsers());
	
		return new ResponseEntity<>(baseResponse,HttpStatus.FOUND);
	}
	
	// handler to get specific user by using id
	@GetMapping(value="/get-userById/{userId}", produces = "application/json")
	public ResponseEntity<BaseResponse<UserDTO>> getUserById(@PathVariable("userId") Integer userId){
		
		BaseResponse<UserDTO> baseResponse = new BaseResponse<>(200,"User Found.",this.userServiceI.getUserByUserId(userId));
		
		return new ResponseEntity<>(baseResponse,HttpStatus.FOUND);
	}
	
	// handler to get specific user by using emailId
	@GetMapping(value="get-userByEmailId", produces = "application/json")
	public ResponseEntity<BaseResponse<UserDTO>> getUserByEmailId(@RequestParam("emailId") String emailId){
		
		BaseResponse<UserDTO> baseResponse = new BaseResponse<>(200,"User Found.",this.userServiceI.getUserByEmailId(emailId));
	
		return new ResponseEntity<>(baseResponse,HttpStatus.FOUND);
	}

	
	// handler to handle edit user using ID in database
	@PutMapping(value="/update-userById/{userId}" , consumes="application/json")
	public ResponseEntity<BaseResponse<UserDTO>> updateUserById(@Valid @RequestBody UserDTO userDto,@PathVariable("userId") Integer userId){
		
		BaseResponse<UserDTO> baseResponse = new BaseResponse<>(200,"User is updated.",this.userServiceI.updateUserById(userDto, userId));
		
		return new ResponseEntity<>(baseResponse,HttpStatus.OK);
	}
	
	// handler to handle delete user by provided id
	@DeleteMapping(value="/delete-userById/{userId}" , produces = "application/json")
	public ResponseEntity<BaseResponse<UserDTO>> deleteUserByUserId(@PathVariable("userId") Integer userId){
		
		BaseResponse<UserDTO> baseResponse = new BaseResponse<>(200,"User Deleted.",this.userServiceI.deleteUserByUserId(userId));

		return new ResponseEntity<>(baseResponse,HttpStatus.OK);
	}
	
	// handler to handler delete user by provided emailId
	@DeleteMapping(value="/delete-userByEmailId" , produces = "application/json")
	ResponseEntity<BaseResponse<UserDTO>> deleteUserByEmailId(@RequestParam("emailId") String emailId){
		
		BaseResponse<UserDTO> baseResponse = new BaseResponse<>(200,"User Deleted.",this.userServiceI.deleteUserByEmailId(emailId));
		
		return new ResponseEntity<>(baseResponse,HttpStatus.OK);
	}
	
	
}
