package nl.novi.backendwhattoeat.repositories;

import nl.novi.backendwhattoeat.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface MenuRepository extends JpaRepository <Menu, Long> {

    List<Menu> findAllMenusByTitleEqualsIgnoreCase(String title);

    List<Menu> findAllMenusByCuisineTypeEqualsIgnoreCase(String cuisineType);

    List<Menu> findAllMenusByLabelEqualsIgnoreCase(String Label);
}