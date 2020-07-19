package com.rohan.tpc.services;

import com.rohan.tpc.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
