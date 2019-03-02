package com.gaurav.springpetclinic.services;

import com.gaurav.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
