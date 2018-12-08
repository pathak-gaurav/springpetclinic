package com.gaurav.springpetclinic.bootstrap;

import com.gaurav.springpetclinic.model.Owner;
import com.gaurav.springpetclinic.model.Pet;
import com.gaurav.springpetclinic.model.PetType;
import com.gaurav.springpetclinic.model.Vet;
import com.gaurav.springpetclinic.services.OwnerService;
import com.gaurav.springpetclinic.services.PetTypeService;
import com.gaurav.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        PetType saveCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Zack");
        owner1.setLastName("Anderson");
        owner1.setAddress("High Street");
        owner1.setCity("Brighton");
        owner1.setTelephone("+44 -123 456 789");

        Pet zackPet = new Pet();
        zackPet.setPetType(saveDogPetType);
        zackPet.setOwner(owner1);
        zackPet.setBirtDate(LocalDate.of(2010, 10, 11));
        zackPet.setName("appolo");
        owner1.getPets().add(zackPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Zoella");
        owner2.setLastName("Sugg");
        owner2.setAddress("Trafalgar Square");
        owner2.setCity("London");
        owner2.setTelephone("+44 -187 654 321");

        Pet zoellaPet = new Pet();
        zoellaPet.setPetType(saveCatPetType);
        zoellaPet.setOwner(owner2);
        zoellaPet.setName("sherlock");
        zoellaPet.setBirtDate(LocalDate.of(2013, 01, 23));
        owner2.getPets().add(zoellaPet);

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
