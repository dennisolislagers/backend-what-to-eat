package nl.novi.backendwhattoeat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavouriteRepository extends JpaRepository<Favourite, Long>{
    List<Favourite> findFavouriteByTitleEqualsIgnoreCase(String title);
}
