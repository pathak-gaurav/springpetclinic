package com.gaurav.springpetclinic.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PETS")
public class Pet extends BaseEntity {

    @Column(name="NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "PET_TYPE_ID")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private Owner owner;

    @Column(name="BIRTH_DATE")
    private LocalDate birtDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirtDate() {
        return birtDate;
    }

    public void setBirtDate(LocalDate birtDate) {
        this.birtDate = birtDate;
    }
}
