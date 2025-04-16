package Individual.Assignment5.MVC.App.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    // Get all animals
    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    // Get an animal by its ID
    @GetMapping("/{id}")
    public Optional<Animal> getAnimalById(@PathVariable int id) {
        return animalService.getAnimalById(id);
    }

    // Add a new animal
    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal) {
        return animalService.addAnimal(animal);
    }

    // Update an existing animal
    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody Animal updatedAnimal) {
        return animalService.updateAnimal(id, updatedAnimal);
    }

    // Delete an existing animal
    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable int id) {
        animalService.deleteAnimal(id);
    }

    // Get all animals by species
    @GetMapping("/species")
    public List<Animal> getAnimalsBySpecies(@RequestParam String species) {
        return animalService.getAnimalsBySpecies(species);
    }

    // Search animals by name containing a string
    @GetMapping("/search")
    public List<Animal> searchAnimalsByName(@RequestParam String name) {
        return animalService.searchAnimalsByName(name);
    }
}