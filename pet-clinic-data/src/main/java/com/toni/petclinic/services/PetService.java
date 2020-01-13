package com.toni.petclinic.services;

import com.toni.petclinic.model.Pet;

import java.util.Set;

public class PetService {

    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
