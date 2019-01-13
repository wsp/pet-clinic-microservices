package com.rje.petclinic.visit;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VisitRepository extends CrudRepository<Visit, Long> {

    List<Visit> findByPetId(Long petId);

    List<Visit> findByPetIdIn(List<Long> petIds);

}
