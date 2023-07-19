package com.estudo.repository;

import com.estudo.entity.Animal;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AnimalRepository implements PanacheRepository<Animal> {
}
