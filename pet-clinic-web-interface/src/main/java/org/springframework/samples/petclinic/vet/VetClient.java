package org.springframework.samples.petclinic.vet;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("vets-service")
interface VetClient {

    @RequestMapping(method = RequestMethod.GET, value = "/vets")
    List<VetDTO> findAllVets();
}
