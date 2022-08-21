package nl.novi.backendwhattoeat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface MenuIngredientRepository extends JpaRepository <MenuIngredient, MenuIngredientKey>{
    Collection<MenuIngredient> findAllByMenuId(Long menuId);
    Collection<MenuIngredient> findAllByIngredientId(Long ingredientId);
}
