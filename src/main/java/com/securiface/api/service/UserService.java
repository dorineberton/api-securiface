package com.securiface.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.securiface.api.model.User;
import com.securiface.api.repository.UserRepository;

import lombok.var;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	  @Autowired
	  private UserRepository userRepository;
	  /*
	  @Autowired
	  PasswordEncoder passwordEncoder;
	  */

	  public User create(User user) {
		  	userRepository.findByEmail(user.getEmail()).ifPresent(userSelected -> {
			    throw new IllegalArgumentException("Un utilisateur existe déjà !");
			  });
			  // Password encryptedPassword = Password.encrypted(encoder.encode(password));
			  return userRepository.save(user);
	    }
	  
	  public User findById(Long id) {
	        var val = userRepository.findById(id);
	        if (!val.isPresent()) {
	        	System.out.printf("Utilisateur inconnu avec id %d%n", id); 
	        }    
	        return val.get();
	  }
	  
	  public User update(User user) {
		  	boolean exists = userRepository.existsById(user.getId());
		  	if(!exists) {
		  		System.out.printf("Utilisateur inconnu avec id %d%n", user.getId()); 
		  	}
		  	return userRepository.save(user);
	  }

	  public List<User> findAll() {
	        var it = userRepository.findAll();
	        var users = new ArrayList<User>();
	        it.forEach(e -> users.add(e));
	        return users;
	    }
}
