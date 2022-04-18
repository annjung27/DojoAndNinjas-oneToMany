package com.annie.dojoandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.annie.dojoandninjas.models.Dojo;
import com.annie.dojoandninjas.models.Ninja;
import com.annie.dojoandninjas.services.DojoService;
import com.annie.dojoandninjas.services.NinjaService;

@Controller
public class NinjaController {
	
//---------Dependency Injection to talk to Serevice------
	@Autowired
	private NinjaService ninjaService;
	@Autowired
	private DojoService dojoService;
	
//--------Disply : new ninja page-----------------------
	@GetMapping("/ninjas/new")
	public String newNinjaPage(@ModelAttribute("ninja") Ninja ninja,
								Model model) {
		List<Dojo> allDaDojos = dojoService.allDojos();
		model.addAttribute("allDaDojos", allDaDojos);
		return "newNinja.jsp";
	}

//-------Action: Create new ninja--------------------
	@PostMapping("/ninjas/new")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja,
								BindingResult result) {
		if(result.hasErrors()) {			
			return "newNinja.jsp";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}
	
}
