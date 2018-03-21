package com.home.tutorial.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping(value="/greeting")
	public String sayHello(Model model) {
		model.addAttribute("greeting","Welcome To Spring MVC World");
		return "viewPage";
	}
}
