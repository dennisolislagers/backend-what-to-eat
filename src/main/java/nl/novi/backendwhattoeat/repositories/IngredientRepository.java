package nl.novi.backendwhattoeat.repositories;

import nl.novi.backendwhattoeat.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository <Ingredient, Long> {

    List<Ingredient> findIngredientsByProductNameEqualsIgnoreCase(String productName);
}
