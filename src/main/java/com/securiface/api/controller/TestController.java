package com.securiface.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/welcome")
	public String welcomepage() {
		return "Bienvenue";
	}

}