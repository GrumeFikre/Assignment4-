package Individual.Assignment5.MVC.App.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    // Custom query for finding animals by species
    List<Animal> findBySpecies(String species);

    // Custom query for searching animals by name containing a substring
    List<Animal> findByNameContaining(String name);
}