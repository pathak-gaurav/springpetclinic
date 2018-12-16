package com.gaurav.springpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "VETS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "VETS_SPECIALTIES", joinColumns = @JoinColumn(name = "VET_ID"),
            inverseJoinColumns = @JoinColumn(name = "SPECIALTY_ID"))
    private Set<Speciality> specialities = new HashSet<>();
}
