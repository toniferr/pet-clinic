package com.toni.petclinic.bootstrap;

import com.toni.petclinic.model.Owner;
import com.toni.petclinic.model.Pet;
import com.toni.petclinic.model.PetType;
import com.toni.petclinic.model.Vet;
import com.toni.petclinic.services.OwnerService;
import com.toni.petclinic.services.PetTypeService;
import com.toni.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    //@Autowire no hace falta(ya es como si lo tuviera)
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

            PetType dog = new PetType();
            dog.setName("dog");
            PetType dogSaved = petTypeService.save(dog);

            PetType cat = new PetType();
            cat.setName("cat");
            PetType catSaved = petTypeService.save(cat);

            Owner owner1 = new Owner();
            //owner1.setId(1L); se comenta ya que se modifica service para id autoincremental
            owner1.setFirstName("Michael");
            owner1.setLastName("Weston");
            owner1.setAddress("123 Brickerel");
            owner1.setCity("Miami");
            owner1.setTelephone("1231231234");

            ownerService.save(owner1);

            Pet mikesPet = new Pet();
            mikesPet.setPetType(dogSaved);
            mikesPet.setOwner(owner1);
            mikesPet.setBirthdate(LocalDate.now());
            mikesPet.setName("Rosco");
            owner1.getPets().add(mikesPet);

            Owner owner2 = new Owner();
        //owner2.setId(2L);
            owner2.setFirstName("Fionna");
            owner2.setLastName("Glenanne");
            owner2.setAddress("123 Brickerel");
            owner2.setCity("Miami");
            owner2.setTelephone("1231231234");

            Pet fionasPet = new Pet();
            fionasPet.setPetType(catSaved);
            fionasPet.setOwner(owner2);
            fionasPet.setBirthdate(LocalDate.now());
            fionasPet.setName("Just Cat");
            owner2.getPets().add(fionasPet);

            ownerService.save(owner2);

            System.out.println("Loader owners...");

            Vet vet1 = new Vet();
        //vet1.setId(1L);
            vet1.setFirstName("Sam");
            vet1.setLastName("Axe");

            vetService.save(vet1);

            Vet vet2 = new Vet();
        //vet2.setId(2L);
            vet2.setFirstName("Jesie");
            vet2.setLastName("Porter");

            vetService.save(vet2);

            System.out.println("Loader vets...");


    }
}
