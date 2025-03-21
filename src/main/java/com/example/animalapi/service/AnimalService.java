package com.example.animalapi.service;

import com.example.animalapi.model.Animal;
import com.example.animalapi.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Optional<Animal> getAnimalById(int id) {
        return animalRepository.findById(id);
    }

    public List<Animal> getAnimalsByBreed(String breed) {
        return animalRepository.findByBreed(breed);
    }

    public List<Animal> searchAnimalsByName(String name) {
        return animalRepository.findByNameContaining(name);
    }

    public Animal addAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal updateAnimal(int id, Animal updatedAnimal) {
        return animalRepository.findById(id)
                .map(animal -> {
                    animal.setName(updatedAnimal.getName());
                    animal.setDescription(updatedAnimal.getDescription());
                    animal.setBreed(updatedAnimal.getBreed());
                    animal.setAge(updatedAnimal.getAge());
                    animal.setActiveDate(updatedAnimal.getActiveDate());
                    return animalRepository.save(animal);
                }).orElse(null);
    }

    public void deleteAnimal(int id) {
        animalRepository.deleteById(id);
    }
}