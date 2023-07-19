package com.estudo.service;

import com.estudo.entity.Animal;
import com.estudo.entity.AnimalRecord;
import com.estudo.repository.AnimalRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class AnimalService {

    @Inject
    AnimalRepository animalRepository;

    public List<Animal> getAnimals(){
        return animalRepository.listAll();
    }

    public void postAnimal(AnimalRecord animalRecord){

        Animal animal = new Animal();

        animal.setCor(animalRecord.cor());
        animal.setNome(animalRecord.nome());
        animal.setPeso(animalRecord.peso());

        animalRepository.persist(animal);
    }
}
