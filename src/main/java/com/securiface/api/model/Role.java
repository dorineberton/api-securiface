package com.securiface.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ID", updatable = false, nullable = false)
  	private long id;

  @Enumerated(EnumType.STRING)
  private UserRole roleName; 
  
  public Role(){
		super();
	}
	public Role(UserRole roleName){
		super();
		this.roleName = roleName;
	}
	

public enum UserRole {
	    ADMIN, USER 
	}
  
}