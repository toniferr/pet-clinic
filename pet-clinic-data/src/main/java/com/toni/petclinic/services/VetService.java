package com.toni.petclinic.services;

import com.toni.petclinic.model.Vet;

import java.util.Set;

public class VetService {

    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
