package com.securiface.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.securiface.api.model.User;
import com.securiface.api.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	  
	  @GetMapping("/")
	  @ResponseBody
	  public ResponseEntity<?> getAllUsers() {
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
	  public ResponseEntity<?> findOne(@PathVariable Long id) {
	      System.out.println(id);
	      return userService.findById(id);
	  }
	  
	  @PostMapping("/login")
	  @ResponseBody
	  public ResponseEntity<?> login(@RequestBody User user, HttpServletRequest request) {
		  @SuppressWarnings("unchecked")
			List<String> messages = (List<String>) request.getSession().getAttribute("MY_SESSION_MESSAGES");
			if (messages == null) {
				messages = new ArrayList<>();
				request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
			}
			String email = user.getEmail();
			messages.add(email);
			request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
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
		      return "Erreur mise à jour du profil: " + ex.toString();
		    }
		    return "Utilisateur mis à jour";
	  }
	  
	  @DeleteMapping("/delete/{id}")
	  @ResponseBody
	  public String deleteUser(@PathVariable Long id) {
		    try {
		      userService.delete(id);
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
		      userService.deleteAll();
		    }
		    catch (Exception ex) {
		      return "Erreur suppression des utilisateurs";
		    }
		    return "Utilisateurs supprimés";
	  }
	  
}
