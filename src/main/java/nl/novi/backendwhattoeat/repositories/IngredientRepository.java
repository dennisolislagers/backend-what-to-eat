package nl.novi.backendwhattoeat.repositories;

import nl.novi.backendwhattoeat.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IngredientRepository extends JpaRepository <Ingredient, Long> {

}
