package com.securiface.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.securiface.api.model.User;
import com.securiface.api.service.UserService;

@CrossOrigin
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
	  public String yes() {
		  return "yes";
	  }
	/*
	 * @PostMapping("/request")
public ResponseEntity postController(
  @RequestBody LoginForm loginForm) {
 
    exampleService.fakeAuthenticate(loginForm);
    return ResponseEntity.ok(HttpStatus.OK);
}
	 */
	
}
