package com.americao.dojosandninjas.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.americao.dojosandninjas.models.Dojo;
//import com.americao.dojosandninjas.models.Ninja;
import com.americao.dojosandninjas.services.DojoService;
//import com.americao.dojosandninjas.services.NinjaService;

@Controller
public class DojoController {
	@Autowired
	private DojoService dojoService;
//	@Autowired
//	private NinjaService ninjaService;
	
//	--CREATE NINJA RENDER
	@GetMapping("/dojo/new")
	public String newD(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojo/newdojo.jsp";
	}
	
// 	--CREATE POST METHOD
	@PostMapping("/dojo/new/process")
	public String createN(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("error");
			return "/dojo/new.jsp";
		} else {
			System.out.println("success");
			dojoService.createDojo(dojo);
			return String.format("redirect:/dojo/%s",dojo.getId());
		}
	}
	
//	--SHOW ONE
	@GetMapping("/dojo/{id}")
	public String showOneDojo(@ModelAttribute("dojo") Dojo dojo,
			@PathVariable("id") Long id, Model model) {
			Dojo oneDojo = dojoService.findDojo(id);
			model.addAttribute("oneDojo", oneDojo);
		return "/dojo/onedojo.jsp";
	}
}