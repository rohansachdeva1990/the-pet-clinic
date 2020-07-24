package com.rohan.tpc.respositories;

import com.rohan.tpc.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
