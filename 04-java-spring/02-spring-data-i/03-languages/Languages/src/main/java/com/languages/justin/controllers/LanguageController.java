package com.languages.justin.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.languages.justin.models.Language;
import com.languages.justin.services.LanguageServices;

@Controller
public class LanguageController {
	
	private LanguageServices langService;
	
	@RequestMapping("/")
	public String Index(Model model) {
		model.addAttribute("languages", langService.allLanguage());
		return "index.jsp";
	}
	@RequestMapping("/{id}")
	public String Show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("language", langService.findLanguage(id));
		return "show.jsp";
	}
	@RequestMapping("/new")
	public String New(@ModelAttribute("language") Language language) {
		return "new.jsp";
	}
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String Create(@Valid @ModelAttribute("language") Language lang, BindingResult result, @RequestParam Map<String,String> body) {
		if(result.hasErrors())
			return "new.jsp";
		langService.createLanguage(lang);
		return "redirect:/";
	}
	@RequestMapping("/{id}/edit")
	public String Edit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("language", langService.findLanguage(id));
		return "edit.jsp";
	}
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String Update(@Valid @ModelAttribute("language") Language lang, BindingResult result) {
		if(result.hasErrors())
			return "edit.jsp";
		langService.updateLanguage(lang);
		return "redirect:/";
	}
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String Delete(@PathVariable("id") Long id) {
		langService.deleteById(id);
		return "redirect:/";
	}
}
