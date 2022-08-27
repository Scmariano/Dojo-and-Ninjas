package com.stephen.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.stephen.dojosninjas.models.Dojo;
import com.stephen.dojosninjas.models.Ninja;
import com.stephen.dojosninjas.services.DojoServ;
import com.stephen.dojosninjas.services.NinjaServ;

@Controller
public class DojoNinjaController {
	
	@Autowired
	private NinjaServ ninjaServ;
	
	@Autowired
	private DojoServ dojoServ;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/dojos/new";
	}
	
	// Dojo Get and Post
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo, Model model) {
		List<Dojo> allDojos = dojoServ.allDojos();
		model.addAttribute("dojos", allDojos);
		return "createDojo.jsp";
	}
	
	// Create Dojo
	@PostMapping("/dojos/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojo> dojos = dojoServ.allDojos();
			model.addAttribute("dojos", dojos);
			return "createDojo.jsp";
		}else {
			dojoServ.createDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	
	// Show a Dojo
	@GetMapping("/dojos/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoServ.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "showDojo.jsp";
	}
	
	
	// Ninja Get and Post
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoServ.allDojos();
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp";
	}
	
	@PostMapping("/ninjas/create")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "newNinja.jsp";
		}else {
			ninjaServ.createNinja(ninja);
			return "redirect:/dojos/new";
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
