package com.gaurav.springpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "OWNERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Owner extends Person {

    @Builder
    public Owner(Long id, String firstName, String lastName,
                 String address, String city, String telephone, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }

    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "CITY")
    private String city;
    @Column(name = "TELEPHONE")
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();
}
