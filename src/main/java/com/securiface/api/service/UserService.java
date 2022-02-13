package com.securiface.api.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.securiface.api.model.Role;
import com.securiface.api.model.User;
import com.securiface.api.repository.UserRepository;

import lombok.var;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	  @Autowired
	  private UserRepository userRepository;

	  public User create(User user) {
		  	userRepository.findByEmail(user.getEmail()).ifPresent(userSelected -> {
			    throw new IllegalArgumentException("Un utilisateur existe déjà !");
			  });
		  	  PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		  	  user.setPassword(encoder.encode(user.getPassword()));
			  return userRepository.save(user);
	    }
	  
	  public Optional<User> findById(Long id) {
	        var val = userRepository.findById(id);
	        if (!val.isPresent()) {
	        	System.out.println("Utilisateur inconnu"); 
	        }    
	        return Optional.ofNullable(val.get());
	  }
	  
	  public Optional<User> findByEmailAndPassword(User user) {
	       	var userSelected = userRepository.findByEmail(user.getEmail());
	        if (userSelected.isPresent()) {
	        	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	        	String passwordEncoded = encoder.encode(user.getPassword());
	        	if (passwordEncoded == userSelected.get().getPassword()) {
	        		return Optional.of(userSelected.get());
	        	}
	        } else {
	        	System.out.println("Utilisateur inconnu");
	        }
			return Optional.ofNullable(userSelected.get());
	  }
	  
	  public User update(User user) {
		  	boolean exists = userRepository.existsById(user.getId());
		  	if(!exists) {
		  		System.out.printf("Utilisateur inconnu avec id %d%n", user.getId()); 
		  	}
		  	return userRepository.save(user);
	  }

	  public String delete(User user) {
			boolean exists = userRepository.existsById(user.getId());
			if(!exists) {
				System.out.printf("Utilisateur inconnu avec id %d%n", user.getId()); 
			}
			userRepository.delete(user);
			return "utilisateur supprimé";
	  }
	  
	  public String deleteAll(List<User> allUsers) {
			for (User element : allUsers) {
				delete(element);
			}
			return "Tous les utilisateurs ont été supprimés.";
		}
	  
	  public List<User> findAll() {
	        var it = userRepository.findAll();
	        var users = new ArrayList<User>();
	        it.forEach(e -> users.add(e));
	        return users;
	    }

}
