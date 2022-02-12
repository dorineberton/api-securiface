package com.securiface.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.securiface.api.model.User;
import com.securiface.api.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
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
	  public User findOne(@PathVariable Long id) {
	      System.out.println(id);
	      return userService.findById(id);
	  }
	  
	  @PostMapping("/update")
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
	  
	  @PostMapping("/delete")
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
	  
	  @PostMapping("/deleteAll")
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
