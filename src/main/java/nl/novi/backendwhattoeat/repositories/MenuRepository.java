package nl.novi.backendwhattoeat.repositories;

import nl.novi.backendwhattoeat.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository <Menu, Long> {


    List<Menu> findAllMenusByCuisineTypeEqualsIgnoreCase(String cuisineType);
    List<Menu> findAllMenusByMealTypeEqualsIgnoreCase(String mealType);
    List<Menu> findAllMenusByDishTypeEqualsIgnoreCase(String dishType);

    Optional<Menu> findMenuByTitleEqualsIgnoreCase(String title);
}