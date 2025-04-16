package com.example.demo.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findBySpecies(String species); // Custom query for finding animals by species
    List<Animal> findByNameContaining(String name); // Custom query for searching by name
}