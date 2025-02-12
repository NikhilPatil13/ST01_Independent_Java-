package com.restBloggingApp.main.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDTO {

	private Integer userIdentifier;

	@NotEmpty(message = "Name is mandatory!!!")
	private String name;
	
	@Email(message = "Email is not valid!!!")
	@NotEmpty(message = "Email is manadatory!!!")
	private String emailId;

	@NotEmpty(message = "Password is mandatory!!!")
	@Size(min = 8 , message = "Password should be greater that 8 characters!!!")
	@Pattern(regexp = "^[a-zA-Z0-9]{8}" ,  message = "Password must be greater than 8 characters and in proper format!!!")
	private String password;
	
	@NotEmpty(message = "About is mandatory!!!")
	private String about;
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserDTO(Integer userIdendtifier,String name, String emailId, String password, String about) {
		super();
		this.userIdentifier = userIdendtifier;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.about = about;
	}
	
	public Integer getUserIdentifier() {
		return userIdentifier;
	}
	
	public void setUserIdentifier(Integer userIdentifier) {
		this.userIdentifier = userIdentifier;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}


	@Override
	public String toString() {
		return "UserDTO [userIdentifier=" + userIdentifier + ", name=" + name + ", emailId=" + emailId + ", password="
				+ password + ", about=" + about + "]";
	}
	
}
