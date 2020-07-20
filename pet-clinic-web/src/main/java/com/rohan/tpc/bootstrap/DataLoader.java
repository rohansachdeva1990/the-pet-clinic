package com.rohan.tpc.bootstrap;

import com.rohan.tpc.model.Owner;
import com.rohan.tpc.model.Vet;
import com.rohan.tpc.services.OwnerService;
import com.rohan.tpc.services.VetService;
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
        owner1.setFirstName("Nathan");
        owner1.setLastName("Drake");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ichigo");
        owner2.setLastName("Kurosaki");

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Jon");
        vet1.setLastName("Snow");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Harry");
        vet2.setLastName("Potter");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");

    }
}
