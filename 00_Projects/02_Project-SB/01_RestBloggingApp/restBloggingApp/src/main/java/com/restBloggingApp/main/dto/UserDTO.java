package com.restBloggingApp.main.dto;

public class UserDTO {

	private String name;
	private String emailId;
	private String password;
	private String about;
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserDTO(String name, String emailId, String password, String about) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.about = about;
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
		return "UserDTO [name=" + name + ", emailId=" + emailId + ", password=" + password + ", about=" + about + "]";
	}
	
}
