package nl.novi.backendwhattoeat.repository;

import nl.novi.backendwhattoeat.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository <Menu, Long> {

    List<Menu> findAllMenusByTitleEqualsIgnoreCase(String title);
}
