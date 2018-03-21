package com.home.tutorial.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.home.tutorial.springmvc.model.Excercise;

@Controller
public class MinutesController {

	@RequestMapping(value = "/addMinutes")
	public String addMinutes(@ModelAttribute("excercise") Excercise excercise) {

		System.out.println("Excercise Time in Minute : "
				+ excercise.getMinutes());
		return "forward:addMoreExcerciseMinutes.html";
		//return "redirect:addMoreExcerciseMinutes.html";
	}
	
	@RequestMapping(value = "/addMoreExcerciseMinutes")
	public String addMoreMinutes(@ModelAttribute("excercise") Excercise excercise) {

		System.out.println("Additional Excercise Time in Minute : "
				+ excercise.getMinutes());
		return "addMinutes";
	}
}
