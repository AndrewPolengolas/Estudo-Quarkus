package com.estudo.controller;

import com.estudo.entity.Animal;
import com.estudo.entity.AnimalRecord;
import com.estudo.service.AnimalService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;

import java.util.List;

@Path("/animais")
public class AnimalController {

    @Inject
    AnimalService animalService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<List<Animal>> get(){

        List<Animal> retorno = animalService.getAnimals();

        return ResponseBuilder
                .ok(retorno, MediaType.APPLICATION_JSON)
                .build();
    }

    @POST
    @Transactional
    public RestResponse<?> post(AnimalRecord animalRecord){

        animalService.postAnimal(animalRecord);

        return ResponseBuilder
                .ok()
                .build();
    }
}
