package com.gaurav.springpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PET_TYPES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetType extends BaseEntity {

    @Column(name = "NAME")
    private String name;
}
