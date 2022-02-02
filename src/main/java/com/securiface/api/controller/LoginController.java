package com.securiface.api.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.securiface.api.model.User;
import com.securiface.api.service.UserService;

@RestController
public class LoginController
{
	
	@RequestMapping("/login")
	   public String getLogin()
	   {
	      return "Bienvenue User";
	   }
	/*
    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }
    */
	@RequestMapping("/users")
	   public String getUsers()
	   {
	      return "Bienvenue User";
	   }

	
	   @RequestMapping("/admin")
	   public String getAdmin()
	   {
	      return "Welcome Admin";
	   }
}
