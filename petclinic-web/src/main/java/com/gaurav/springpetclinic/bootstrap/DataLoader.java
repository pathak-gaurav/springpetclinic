package com.gaurav.springpetclinic.bootstrap;

import com.gaurav.springpetclinic.model.Owner;
import com.gaurav.springpetclinic.model.PetType;
import com.gaurav.springpetclinic.model.Vet;
import com.gaurav.springpetclinic.services.OwnerService;
import com.gaurav.springpetclinic.services.PetTypeService;
import com.gaurav.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);
        
        PetType cat = new PetType();
        cat.setName("CAT");
        PetType saveCatPetType =  petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Zack");
        owner1.setLastName("Anderson");


        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Zoella");
        owner2.setLastName("Sugg");


        ownerService.save(owner2);

        System.out.println("Owners Loaded...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Donald");
        vet1.setLastName("Trump");


        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Barak");
        vet2.setLastName("Obama");


        vetService.save(vet2);

        System.out.println("Vet's Loaded...");
    }
}
