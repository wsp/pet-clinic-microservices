package com.rje.petclinic.vet;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vets")
class VetController {

    private VetRepository vetRepository;

    @GetMapping("")
    public List<Vet> findAllVets() {
        List<Vet> vetsList = new ArrayList<>();
        vetRepository.findAll().forEach(vetsList::add);
        return vetsList;
    }

}
