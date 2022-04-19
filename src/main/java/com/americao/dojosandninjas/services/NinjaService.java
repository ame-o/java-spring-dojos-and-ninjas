package com.americao.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.americao.dojosandninjas.models.Ninja;
import com.americao.dojosandninjas.repositories.NinjaRepo;

@Service
public class NinjaService {
	
	//CRUD
	@Autowired
	private NinjaRepo ninjaRepo;
	
//	--READ ALL--
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
//	--CREATE--
	public Ninja createNinja(Ninja n) {
		return ninjaRepo.save(n);
	}

//	--READ ONE--
	public Ninja findNina(Long id) {
		Optional <Ninja> optionalNinja = ninjaRepo.findById(id);
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	
//	--UPDATE--
	public Ninja updateNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	
//	--DELETE--
	public void destroyNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
}
