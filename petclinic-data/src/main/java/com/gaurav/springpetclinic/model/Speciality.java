package com.gaurav.springpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SPECIALITY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Speciality extends BaseEntity {

    @Column(name = "DESCRIPTION")
    private String description;

    public String getDescription() {
        return description;
    }
}
