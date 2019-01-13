package org.springframework.samples.petclinic.speciality;

import lombok.Data;

import java.io.Serializable;

@Data
public class SpecialtyDTO implements Serializable {

    private Long id;
    private String description;

}
