package com.gaurav.springpetclinic.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "VISITS")
public class Visit extends BaseEntity {

    @Column(name = "DATE")
    private LocalDate date;
    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "PET_ID")
    private Pet pet;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
