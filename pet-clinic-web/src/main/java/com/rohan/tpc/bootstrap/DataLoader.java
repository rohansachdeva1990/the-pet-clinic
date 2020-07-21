package com.rohan.tpc.bootstrap;

import com.rohan.tpc.model.Owner;
import com.rohan.tpc.model.PetType;
import com.rohan.tpc.model.Vet;
import com.rohan.tpc.services.OwnerService;
import com.rohan.tpc.services.PetTypeService;
import com.rohan.tpc.services.VetService;
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
        PetType savedDogPetType = petTypeService.save(dog);

        PetType dragon = new PetType();
        dragon.setName("Dragon");
        PetType savedDragonPetType = petTypeService.save(dragon);

        Owner owner1 = new Owner();
        owner1.setFirstName("Nathan");
        owner1.setLastName("Drake");

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
