package com.toni.petclinic.repositories;

import com.toni.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findbyLastName(String lastName);
}
