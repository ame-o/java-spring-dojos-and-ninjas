package com.americao.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.americao.dojosandninjas.models.Dojo;
import com.americao.dojosandninjas.models.Ninja;
import com.americao.dojosandninjas.services.DojoService;
import com.americao.dojosandninjas.services.NinjaService;

@Controller
public class NinjaController {
	@Autowired
	private NinjaService ninjaService;
	@Autowired
	private DojoService dojoService;
	
	@GetMapping("/")
	public String index() {
		return "index.html";
	}
	
//	--CREATE NINJA RENDER
	@GetMapping("/ninja/new")
	public String newN(@ModelAttribute("ninja") Ninja ninja, Model model) {
//	--RENDER ALL
			List<Dojo> allDojos = dojoService.allDojos();
			model.addAttribute("allDojos",allDojos);
//	
		return "/ninja/new.jsp";
	}
	
// 	--CREATE POST METHOD
	@PostMapping("/ninja/new/process")
	public String createN(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
	if(result.hasErrors()) {
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("allDojos",allDojos);
		return "/ninja/new.jsp";
	} else {
		ninjaService.createNinja(ninja);
		return String.format("redirect:/dojo/%s", ninja.getDojo().getId());
	}
	

}
}