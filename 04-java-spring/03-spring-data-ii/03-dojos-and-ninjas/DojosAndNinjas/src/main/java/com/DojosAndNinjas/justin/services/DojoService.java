package com.DojosAndNinjas.justin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DojosAndNinjas.justin.models.Dojo;
import com.DojosAndNinjas.justin.models.Ninja;
import com.DojosAndNinjas.justin.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dRepo;
	

	public List<Dojo> getAllDojos() {
		return this.dRepo.findAll();
	}
	

	public List<Ninja> getAllNinjas(Dojo dojo) {
		return dojo.getNinjas();
	}

	public Dojo getOneDojo(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}

	public Dojo createDojo(Dojo newDojo) {
		return this.dRepo.save(newDojo);
	}
	
	
	
}
