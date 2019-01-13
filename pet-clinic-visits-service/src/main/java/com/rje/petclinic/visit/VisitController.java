package com.rje.petclinic.visit;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
class VisitController {

    private VisitRepository visitRepository;

    @PostMapping("owners/*/pets/{petId}/visits")
    @ResponseStatus(HttpStatus.CREATED)
    public Visit createVisit(@RequestBody Visit visit,
                             @PathVariable("petId") Long petId) {
        visit.setPetId(petId);
        return visitRepository.save(visit);
    }

    @GetMapping("owners/*/pets/{petId}/visits")
    public List<Visit> findVisitsByPetId(@PathVariable("petId") Long petId) {
        return new ArrayList<>(visitRepository.findByPetId(petId));
    }

    @GetMapping("pets/visits")
    public List<Visit> findVisitsByPetIds(@RequestParam("petId") List<Long> petIds) {
        return new ArrayList<>(visitRepository.findByPetIdIn(petIds));
    }

}
