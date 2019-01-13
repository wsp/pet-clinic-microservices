package com.rje.petclinic.pets;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/pets")
class PetController {

    public PetRepository petRepository;
    public PetTypeRepository petTypeRepository;

    @GetMapping("/petTypes")
    public List<PetType> findPetTypes() {
        List<PetType> petTypes = new ArrayList<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @GetMapping("/{petId}")
    public Pet findPetById(@PathVariable("petId") Long petId) {
        return petRepository.findById(petId)
                .orElseThrow(() -> new RuntimeException("pet with id=" + petId + " not found"));
    }

}
