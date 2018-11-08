package com.pragmaedge.training.FirstProject.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserData {
  @Id
  private String userId;
  private String password;
  private String role;
  private String firstName;
  private String lastName;
  private String middleName;
  private String email;
  private String phone;
  private String status;
  public UserData()
  {
	  
  }
public UserData(String userId, String password, String role, String firstName, String lastName, String middleName,
		String email, String phone, String status) {
	super();
	this.userId = userId;
	this.password = password;
	this.role = role;
	this.firstName = firstName;
	this.lastName = lastName;
	this.middleName = middleName;
	this.email = email;
	this.phone = phone;
	this.status = status;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
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
public String getMiddleName() {
	return middleName;
}
public void setMiddleName(String middleName) {
	this.middleName = middleName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
}

