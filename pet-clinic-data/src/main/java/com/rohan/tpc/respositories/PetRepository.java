package com.rohan.tpc.respositories;

import com.rohan.tpc.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
