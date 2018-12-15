package com.gaurav.springpetclinic.repositories;

import com.gaurav.springpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
