package com.rohan.tpc.bootstrap;

import com.rohan.tpc.model.Owner;
import com.rohan.tpc.model.Pet;
import com.rohan.tpc.model.PetType;
import com.rohan.tpc.model.Vet;
import com.rohan.tpc.services.OwnerService;
import com.rohan.tpc.services.PetTypeService;
import com.rohan.tpc.services.VetService;
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

        // Pet Types
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType dragon = new PetType();
        dragon.setName("Dragon");
        PetType savedDragonPetType = petTypeService.save(dragon);

        // Owner 1
        Owner owner1 = new Owner();
        owner1.setFirstName("Nathan");
        owner1.setLastName("Drake");
        owner1.setAddress("123 Naughty Dog");
        owner1.setCity("London");
        owner1.setTelephone("+44 1233212");

        // Owner 1: Pet
        Pet natesPet = new Pet();
        natesPet.setPetType(savedDogPetType);
        natesPet.setOwner(owner1);
        natesPet.setBirthDate(LocalDate.now());
        natesPet.setName("Crash");
        owner1.getPets().add(natesPet);

        ownerService.save(owner1);

        // Owner 2
        Owner owner2 = new Owner();
        owner2.setFirstName("Ichigo");
        owner2.setLastName("Kurosaki");
        owner2.setAddress("321 Naughty Dog");
        owner2.setCity("London");
        owner2.setTelephone("+44 1233212");

        // Owner 2: Pet
        Pet kurosakisPet = new Pet();
        kurosakisPet.setPetType(savedDragonPetType);
        kurosakisPet.setOwner(owner2);
        kurosakisPet.setBirthDate(LocalDate.now());
        kurosakisPet.setName("Rukia");
        owner1.getPets().add(kurosakisPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        // Vets
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
