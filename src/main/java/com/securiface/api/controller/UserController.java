package com.securiface.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.securiface.api.model.Role;
import com.securiface.api.model.User;
import com.securiface.api.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
public class UserController {
	private static final org.slf4j.Logger log = 
		    org.slf4j.LoggerFactory.getLogger(User.class);
	
	@Autowired
	private UserService userService;
	
	  @GetMapping("/")
	  @ResponseBody
	  public List<User> getAllUsers() {
		return userService.findAll();
	  }

	  @PostMapping("/create")
	  @ResponseBody
	  public String createUser(@RequestBody User user) {
		    try {
		      userService.create(user);
		    }
		    catch (Exception ex) {
		      return "Erreur création de l'utilisateur: " + ex.toString();
		    }
		    return "Utilisateur créé";
	  }
	  
	  @GetMapping("/{id}")
	  @ResponseBody
	  public Optional<User> findOne(@PathVariable Long id) {
	      System.out.println(id);
	      return userService.findById(id);
	  }
	  
	  @PostMapping("/login")
	  @ResponseBody
	  public Optional<User> login(@RequestBody User user) {
	      return userService.findByEmailAndPassword(user);
	  }
	  
	  /*
	  @PostMapping("/login")
	  @ResponseBody
	  public Optional<User> login(@RequestBody User user) {
		  Optional<User> userSelected = null;
		  try {
			  // ObjectMapper mapper = new ObjectMapper();
			  // Map<String, Object> response = mapper.readValue(json, new TypeReference<Map<String, Object>>() {
	            // });
		        if (!user.isEmpty()) {
		        	// System.out.println("user " + response.get("email"));
		  	      userSelected = userService.findByEmailAndPassword(user);
		        }
		    } catch (Exception ex) {
		    	log.info("Cannot parse JSON for spring.application.json: ", ex);
		    }
		  return userSelected;
	  }
	  */
	  @PutMapping("/update")
	  @ResponseBody
	  public String updateUser(@RequestBody User user) {
		    try {
		      userService.update(user);
		    }
		    catch (Exception ex) {
		      return "Erreur création de l'utilisateur: " + ex.toString();
		    }
		    return "Utilisateur mis à jour";
	  }
	  
	  @DeleteMapping("/delete")
	  @ResponseBody
	  public String deleteUser(@RequestBody User user) {
		    try {
		      userService.delete(user);
		    }
		    catch (Exception ex) {
		      return "Erreur suppression de l'utilisateur: " + ex.toString();
		    }
		    return "Utilisateur supprimé";
	  }
	  
	  @DeleteMapping("/deleteAll")
	  @ResponseBody
	  public String deleteUsers() {
		    try {
		      userService.deleteAll(this.getAllUsers());
		    }
		    catch (Exception ex) {
		      return "Erreur suppression des utilisateurs";
		    }
		    return "Utilisateurs supprimés";
	  }

	
}
