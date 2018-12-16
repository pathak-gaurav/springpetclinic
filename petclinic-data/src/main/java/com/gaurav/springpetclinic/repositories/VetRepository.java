package com.gaurav.springpetclinic.repositories;

import com.gaurav.springpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
