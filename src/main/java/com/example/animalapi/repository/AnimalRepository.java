package com.example.animalapi.repository;

import com.example.animalapi.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findByNameContaining(String name);

    @Query("SELECT a FROM Animal a WHERE a.breed = ?1")
    List<Animal> findByBreed(String breed);
}