package com.stephen.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stephen.dojosninjas.models.Dojo;
import com.stephen.dojosninjas.models.Ninja;


@Repository
public interface NinjaRepo extends CrudRepository<Ninja, Long> {
	List <Ninja> findAll();
	List <Ninja> findAllByDojo(Dojo dojo);

}
