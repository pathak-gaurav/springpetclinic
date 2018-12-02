package com.gaurav.springpetclinic.services;

import com.gaurav.springpetclinic.model.Owner;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    void save(Owner owner);

    Set<Owner> findAll();
}
