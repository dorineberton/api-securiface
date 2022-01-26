package com.securiface.api.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "USERS")
public class User implements Serializable, UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", length = 30, nullable = false)
    private Integer userId;
    
    @Column(name = "FIRSTNAME", length = 30, nullable = false)
    private String firstname;
    
    @Column(name = "LASTNAME", length = 30, nullable = false)
    private String lastname;
    
    @Column(name = "USERNAME", length = 30, nullable = false)
    private String username;
    
    @Column(name = "EMAIL", length = 30, nullable = false)
    private String email;
    
    @Column(name = "PASSWORD", length = 30, nullable = false)
    private String password;
    /*
    @Value("${property: defaultValue}")
    private LocalDateTime CREATED_AT;
    */
    public Integer getUserId() {
        return userId;
    }
    /*
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    */
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
    
    public String getEmail() {
        return email;        
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }
    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    /*
    public LocalDateTime getCreatedAt() {
    	return createdAt;
    }
    */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
