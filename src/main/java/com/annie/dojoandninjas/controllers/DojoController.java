package com.annie.dojoandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.annie.dojoandninjas.models.Dojo;
import com.annie.dojoandninjas.services.DojoService;

@Controller
public class DojoController {
//-------------Dependency Injection to talk to Service------------------
	@Autowired
	private DojoService dojoService;
	
//------------Redirect to create page----------------------------------
	@RequestMapping("/")
	public String redirect() {
		return "redirect:/dojos/new";
	}
	
// --------------Display: New Dojo page--------------------------
	@GetMapping("/dojos/new")
	public String newDojoPage(@ModelAttribute("dojo") Dojo dojo){
		return "newDojo.jsp";
	}

// -------------Action: Create New Dojo-------------------------
	@PostMapping("/dojos/new")
	public String createNewDojo(@Valid @ModelAttribute("dojo") Dojo dojo, 
								BindingResult result) {
	
		if(result.hasErrors()) {
			return "newDojo.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos/new";
		}
	}

// -------------Show Dojo with Ninjas----------------------------
	@GetMapping("/dojos/{dojo_id}")
	public String showDojowithNinja(@PathVariable("dojo_id") Long dojo_id,
									Model model) {
		Dojo oneDojo = dojoService.findDojo(dojo_id);
		model.addAttribute("oneDojo", oneDojo);
		return "dojoWithNinjas.jsp";
	}
	
}









