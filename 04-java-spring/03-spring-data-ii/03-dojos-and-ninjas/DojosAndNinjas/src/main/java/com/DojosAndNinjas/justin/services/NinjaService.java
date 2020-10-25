package com.DojosAndNinjas.justin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DojosAndNinjas.justin.models.Ninja;
import com.DojosAndNinjas.justin.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository nRepo;
	
	
	public List<Ninja> getAllNinjas() {
		return this.nRepo.findAll();
	}
	
	
	public Ninja createNinja(Ninja newNinja) {
		return this.nRepo.save(newNinja);
	}
	
	
	
}