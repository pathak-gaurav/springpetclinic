package com.gaurav.springpetclinic.services;

import com.gaurav.springpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    void save(Pet pet);

    Set<Pet> findAll();
}
