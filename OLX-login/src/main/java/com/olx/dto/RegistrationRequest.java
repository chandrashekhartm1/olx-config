package com.olx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Registration request model")
public class RegistrationRequest {

	@ApiModelProperty("Unique Id Auto generated")
	private int id;
	@ApiModelProperty("User name")
	private String username;
	@ApiModelProperty("Password of user")
	private String password;
	@ApiModelProperty("Roles like admin,user,gues")
	private String roles;
	@ApiModelProperty("First name of user")
	private String firstName;
	@ApiModelProperty("Last name of user")
	private String lastName;
	@ApiModelProperty("Email of user")
	private String email;
	@ApiModelProperty("Phone number of user")
	private int phone;
	
	
	
	public RegistrationRequest() {
		super();
	}
	public RegistrationRequest(String username, String password, String roles, String firstName, String lastName,
			String email, int phone) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}
	public RegistrationRequest(int id, String username, String password, String roles, String firstName,
			String lastName, String email, int phone) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "RegistrationRequest [id=" + id + ", username=" + username + ", password=" + password + ", roles="
				+ roles + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone="
				+ phone + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
}
