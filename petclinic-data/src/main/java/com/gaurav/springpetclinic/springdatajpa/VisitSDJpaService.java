package com.gaurav.springpetclinic.springdatajpa;

import com.gaurav.springpetclinic.model.Visit;
import com.gaurav.springpetclinic.repositories.VisitRepository;
import com.gaurav.springpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitSDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }

    @Override
    public void delete(Visit visit) {
        visitRepository.delete(visit);
    }
}
