package com.securiface.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ID", updatable = false, nullable = false)
  private long id;

@Column(name="FIRSTNAME", length= 30, nullable = false)
  private String firstname = "";
  
  @Column(name="LASTNAME", length= 30, nullable = false)
  private String lastname = "";

  @Column(name="USERNAME", length= 30, nullable = false)
  private String username = "";
  
  @Column(name="EMAIL", length= 30, nullable = false)
  private String email;
  
  @Column(name="PASSWORD", length= 30, nullable = false)
  private String password;
  

  public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
}
