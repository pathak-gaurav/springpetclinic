package com.gaurav.springpetclinic.bootstrap;

import com.gaurav.springpetclinic.model.*;
import com.gaurav.springpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("CAT");
        PetType saveCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);


        Owner owner1 = new Owner();
        owner1.setFirstName("Zack");
        owner1.setLastName("Anderson");
        owner1.setAddress("High Street");
        owner1.setCity("Brighton");
        owner1.setTelephone("+44 -123 456 789");

        Pet zackPet = new Pet();
        zackPet.setPetType(saveDogPetType);
        zackPet.setOwner(owner1);
        zackPet.setBirthDate(LocalDate.of(2010, 10, 11));
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
        zoellaPet.setBirthDate(LocalDate.of(2013, 01, 23));
        owner2.getPets().add(zoellaPet);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(zoellaPet);
        catVisit.setDescription("Sneezy Kitten");
        catVisit.setDate(LocalDate.of(2018, Month.MARCH, 22));

        visitService.save(catVisit);

        System.out.println("Owners Loaded...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Donald");
        vet1.setLastName("Trump");
        vet1.getSpecialities().add(savedRadiology);


        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Barak");
        vet2.setLastName("Obama");
        vet2.getSpecialities().add(savedDentistry);

        vetService.save(vet2);
        System.out.println("Vet's Loaded...");
    }
}
