package com.stephen.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stephen.dojosninjas.models.Dojo;
import com.stephen.dojosninjas.repositories.DojoRepo;

@Service
public class DojoServ {
	
	private final DojoRepo dojoRepo;
	public DojoServ(DojoRepo dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	// returns all the dojo
    public List<Dojo> allDojos() {
        return dojoRepo.findAll();
    }
    
    // creates a dojo
    public Dojo createDojo(Dojo dojo) {
    	System.out.println(dojo.getId());
        return dojoRepo.save(dojo);
    }
    
    // retrieves a dojo
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepo.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
    
    // update a dojo
    public Dojo updateDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
    // Delete a dojo
	public void deleteDojo(Dojo dojo) {
		dojoRepo.delete(dojo);
	}
	
}
