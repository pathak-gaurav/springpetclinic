package com.gaurav.springpetclinic.map;

import com.gaurav.springpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final Long ownerId = 1L;
    final String lastName = "Anderson";
    final String firstName = "Zack";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerId).firstName(firstName).lastName(lastName).build());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(ownerId,owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner = Owner.builder().id(id).build();
        Owner saveOwner = ownerMapService.save(owner);
        assertEquals(id,saveOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner save = ownerMapService.save(Owner.builder().build());
        assertNotNull(save);
        assertNotNull(save.getId());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertNull(ownerMapService.findById(ownerId));
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertNull(ownerMapService.findById(ownerId));
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(lastName);
        assertEquals(lastName,owner.getLastName());
        assertNotNull(owner);
    }

    @Test
    void findByLastNameNull() {
        Owner owner = ownerMapService.findByLastName("foo");
        assertNull(owner);
    }
}