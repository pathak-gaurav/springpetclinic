package com.gaurav.springpetclinic.bootstrap;

import com.gaurav.springpetclinic.model.Owner;
import com.gaurav.springpetclinic.model.Vet;
import com.gaurav.springpetclinic.services.OwnerService;
import com.gaurav.springpetclinic.services.VetService;
import com.gaurav.springpetclinic.services.map.OwnerServiceMap;
import com.gaurav.springpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Zack");
        owner1.setLastName("Anderson");
        owner1.setId(1L);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Zoella");
        owner2.setLastName("Sugg");
        owner2.setId(2L);

        System.out.println("Owners Loaded...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Donald");
        vet1.setLastName("Trump");
        vet1.setId(1L);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Barak");
        vet2.setLastName("Obama");
        vet2.setId(2L);

        System.out.println("Vet's Loaded...");
    }
}
