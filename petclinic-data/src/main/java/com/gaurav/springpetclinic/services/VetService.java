package com.gaurav.springpetclinic.services;

import com.gaurav.springpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    void save(Vet vet);

    Set<Vet> findAll();
}
