package com.gaurav.springpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "OWNERS")
public class Owner extends Person {

    @Column(name = "ADDRESS")
    private String address;
    @Column(name="CITY")
    private String city;
    @Column(name = "TELEPHONE")
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
