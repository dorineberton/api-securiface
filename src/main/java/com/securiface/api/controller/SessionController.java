package com.securiface.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.securiface.api.model.User;

@Controller
public class SessionController {
	
	@GetMapping("/")
	public String process(Model model, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) session.getAttribute("mySession");

		if (messages == null) {
			messages = new ArrayList<>();
		}
		model.addAttribute("sessionMessages", messages);
		System.out.print(session.getAttribute("mySession"));
		return "index";
	}
	/*
	@PostMapping("/users/login")
	@ResponseBody
	public HttpSession persistMessage(@RequestBody User user, HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) request.getSession().getAttribute("mySession");
		if (messages == null) {
			messages = new ArrayList<>();
			request.getSession().setAttribute("mySession", messages);
		}
		String email = user.getEmail();
		System.out.println(email);
		messages.add(email);
		request.getSession().setAttribute("mySession", messages);
		return request.getSession();
	}
	 */
	@PostMapping("/logout")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
}