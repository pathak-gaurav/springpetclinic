package com.gaurav.springpetclinic.repositories;

import com.gaurav.springpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
