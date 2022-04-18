package com.annie.dojoandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annie.dojoandninjas.models.Dojo;
import com.annie.dojoandninjas.repositories.DojoRepo;

@Service
public class DojoService {

//-----------------Dependency Injection- to talk to dojoRepo------
	@Autowired
	private DojoRepo dojoRepo;

// ---------------READ All--------------------------------------
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
	
// ---------------CREATE--------------------------------------
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	
// ---------------READ ONE--------------------------------------
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}	
	
// --------------UPDATE----------------------------------------
	public Dojo updateDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
		
	
// --------------Delete----------------------------------------
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}
	

	
	

}
