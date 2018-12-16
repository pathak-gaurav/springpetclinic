package com.gaurav.springpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "VISITS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Visit extends BaseEntity {

    @Column(name = "DATE")
    private LocalDate date;
    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "PET_ID")
    private Pet pet;
}
