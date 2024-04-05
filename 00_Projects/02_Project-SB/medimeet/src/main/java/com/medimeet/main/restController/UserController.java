package com.medimeet.main.restController;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.medimeet.main.dto.BaseResponse;
import com.medimeet.main.entities.User;
import com.medimeet.main.serviceI.UserServiceI;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceI userServiceI;

	Logger logger = LogManager.getLogger(UserController.class);
	
	
	// handler to handle saveUser request
	@PostMapping(value="/saveUser",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = "application/json")
	public ResponseEntity<BaseResponse<User>> saveUser(@RequestParam("request") String request , @RequestParam("userProfileImage") MultipartFile profileImage) throws IOException{
		 

		User savedUser = this.userServiceI.saveUser(request, profileImage);
		
		if(savedUser==null) {
			BaseResponse<User> baseResponse = new BaseResponse<User>(400,"EmailID already present...",savedUser);
			logger.info("UserController - saveUser - user NOT saved.");	
			return new ResponseEntity<>(baseResponse,HttpStatus.BAD_REQUEST);
		}
		else {
			BaseResponse<User> baseResponse = new BaseResponse<User>(201,"User is saved.",savedUser);
			logger.info("UserController - saveUser - user saved.");
			return new ResponseEntity<>(baseResponse,HttpStatus.CREATED);
		}
		
	}
	
}
