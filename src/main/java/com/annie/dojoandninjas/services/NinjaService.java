package com.annie.dojoandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annie.dojoandninjas.models.Ninja;
import com.annie.dojoandninjas.repositories.NinjaRepo;

@Service
public class NinjaService {
	
//--------Dependency Injection to talk to NinjaRepo-----------------
	@Autowired
	private NinjaRepo ninjaRepo;
	
//----------------------READ All------------------------------------
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}

//---------------------CREATE--------------------------------------
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
//--------------------READ ONE--------------------------------------
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
			if(optionalNinja.isPresent()) {
				return optionalNinja.get();
			} else {
				return null;
			}
	}

//-------------------UPDATE --------------------------------------
	public Ninja updateNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
//----------------UPDATE ninja with dojo------------------------
//	public Ninja updateNinjaWithDojo(Ninja ninja, Dojo dojo) {
//		ninja.setDojo(dojo);
//		return ninjaRepo.save(ninja);
//	}
	
//---------------DELETE-----------------------------------
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
