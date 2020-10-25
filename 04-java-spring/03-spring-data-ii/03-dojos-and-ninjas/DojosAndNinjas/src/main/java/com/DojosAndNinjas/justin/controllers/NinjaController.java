package com.DojosAndNinjas.justin.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DojosAndNinjas.justin.models.Ninja;
import com.DojosAndNinjas.justin.services.DojoService;
import com.DojosAndNinjas.justin.services.NinjaService;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
	@Autowired
	private NinjaService nService;
	@Autowired
	private DojoService dService;
	
	@GetMapping("/new")
	public String newView(@ModelAttribute("ninja") Ninja ninja, Model dModel) {
		dModel.addAttribute("dojo", this.dService.getAllDojos());
		return "newNinja.jsp";
	}
	
	@PostMapping("/new")
	public String newNinja(@Valid @ModelAttribute("ninja") Ninja newNinja, BindingResult result, Model dModel) {
		if (result.hasErrors()) {
			dModel.addAttribute("dojo", this.dService.getAllDojos());
			return "new.jsp";
		} else {
			this.nService.createNinja(newNinja);
			return "redirect:/ninjas/new";
		}
	}
	
	
}


