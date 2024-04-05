package com.medimeet.main.serviceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medimeet.main.entities.User;
import com.medimeet.main.enums.UserRoles;
import com.medimeet.main.helper.GenerateUsernameHelper;
import com.medimeet.main.repository.UserRepository;
import com.medimeet.main.serviceI.UserServiceI;

@Service
public class UserServiceImpl implements UserServiceI {

	@Autowired
	private UserRepository userRepository;

	
	Logger logger = LogManager.getLogger(UserServiceImpl.class);
	
	// blogic for saveUser request
	@Override
	public User saveUser(String request, MultipartFile profileImage) throws IOException {
		// mapping data coming in request as String format with User 
		ObjectMapper objectMapper = new ObjectMapper();
		User user = objectMapper.readValue(request, User.class);
		

		// Need to check is user already existed or not... if yes --> don't do duplicate registration  (on the basic of emailId)
		
		//Optional<User> byUsername = userRepository.findByUsername(user.getUsername());
		
		Optional<User> userByEmailId =  userRepository.getByUserEmailId(user.getUserEmailId());
		
		
		if(userByEmailId.isPresent()) {
			return null;
		}
		else {
			// check profileImage is null or not
			if(profileImage != null && !profileImage.isEmpty()) {			
				
				InputStream inputStream = profileImage.getInputStream();
				byte[] imageData = new byte[inputStream.available()];
				inputStream.read(imageData);
				
				String base64Image = Base64.getEncoder().encodeToString(imageData);
				
				user.setUserProfileImage(base64Image);
				
				logger.info("UserServiceImpl - saveUser - profileImage set.");
				
			}
			
			GenerateUsernameHelper generateUsernameHelper = new GenerateUsernameHelper();
			
			user.setUsername(generateUsernameHelper.generateUsername());
			
			user.setIsPatient(false);
			
			user.setUserRole(UserRoles.PATIENT);
			
			
			User savedUser = userRepository.save(user);
			logger.info("UserServiceImpl - saveUser - user saved."+savedUser);
			
			return savedUser;
		}

	}
	
	public List<User> getListOfRegistedUsers(){
		List<User> allRegisteredUsers = this.userRepository.findAll();
		
		return allRegisteredUsers;
	}

}
