package org.springframework.samples.petclinic.pet;

import lombok.Data;

import java.io.Serializable;

@Data
public class PetTypeDTO implements Serializable {

    private Long id;
    private String name;

    @Override
    public String toString() {
        return this.getName();
    }

}
