package nl.novi.backendwhattoeat.repositories;

import nl.novi.backendwhattoeat.models.MenuIngredient;
import nl.novi.backendwhattoeat.models.MenuIngredientKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface MenuIngredientRepository extends JpaRepository<MenuIngredient, MenuIngredientKey> {
    Collection<MenuIngredient> findAllByTelevisionId(Long menuId);
    Collection<MenuIngredient> findAllByWallBracketId(Long ingredientId);
}
