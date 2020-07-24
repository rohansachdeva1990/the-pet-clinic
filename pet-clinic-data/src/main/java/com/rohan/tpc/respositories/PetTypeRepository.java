package com.rohan.tpc.respositories;

import com.rohan.tpc.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
