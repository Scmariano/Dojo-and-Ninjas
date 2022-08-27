package com.stephen.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stephen.dojosninjas.models.Ninja;
import com.stephen.dojosninjas.repositories.NinjaRepo;


@Service
public class NinjaServ {
	private final NinjaRepo ninjaRepo;
	public NinjaServ(NinjaRepo ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	// returns all the ninjas
    public List<Ninja> allNinjas() {
        return ninjaRepo.findAll();
    }
    
    // creates a ninja
    public Ninja createNinja(Ninja ninja) {
        return ninjaRepo.save(ninja);
    }
    
    // retrieves a ninja
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
    
    // update a ninja
    public Ninja updateDojo(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
    // Delete a ninja
	public void deleteDojo(Ninja ninja) {
		ninjaRepo.delete(ninja);
	}
	
}
