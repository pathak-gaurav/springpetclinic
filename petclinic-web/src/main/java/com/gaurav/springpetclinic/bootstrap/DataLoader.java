package com.gaurav.springpetclinic.bootstrap;

import com.gaurav.springpetclinic.model.Owner;
import com.gaurav.springpetclinic.model.Vet;
import com.gaurav.springpetclinic.services.OwnerService;
import com.gaurav.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
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
