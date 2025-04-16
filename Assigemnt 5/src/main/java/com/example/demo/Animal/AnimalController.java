package com.example.demo.Animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/f24-340")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    // Get all animals
    @GetMapping("/all")
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    // Get an animal by its ID
    @GetMapping("/{id}")
    public Optional<Animal> getAnimalById(@PathVariable int id) {
        return animalService.getAnimalById(id);
    }

    @PutMapping("/update-id/{oldId}")
    public Animal updateAnimalId(@PathVariable int oldId, @RequestParam int newId) {
        // Check if the new ID already exists
        if (animalService.getAnimalById(newId).isPresent()) {
            throw new RuntimeException("Animal with ID " + newId + " already exists.");
        }

        // Proceed with updating the animal ID
        Optional<Animal> animalOptional = animalService.getAnimalById(oldId);
        if (animalOptional.isPresent()) {
            Animal animal = animalOptional.get();
            animal.setAnimalId(newId);  // Set the new ID
            animalService.addAnimal(animal); // Save with new ID
            return animal;
        } else {
            throw new RuntimeException("Animal with ID " + oldId + " not found.");
        }
    }

    // Add a new animal
    @PostMapping("/new")
    public Animal addAnimal(@RequestBody Animal animal) {
        return animalService.addAnimal(animal);
    }

    // Update an existing animal
    @PutMapping("/update/{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody Animal updatedAnimal) {
        return animalService.updateAnimal(id, updatedAnimal);
    }

    // Delete an existing animal
    @DeleteMapping("/delete/{id}")
    public void deleteAnimal(@PathVariable int id) {
        animalService.deleteAnimal(id);
    }

    // Get all animals by species (renamed from 'class' to 'species')
    @GetMapping("/species")
    public List<Animal> getAnimalsBySpecies(@RequestParam String species) {
        return animalService.getAnimalsBySpecies(species);
    }

    // Search animals by name (string contains)
    @GetMapping("/search")
    public List<Animal> searchAnimalsByName(@RequestParam String name) {
        return animalService.searchAnimalsByName(name);
    }
}