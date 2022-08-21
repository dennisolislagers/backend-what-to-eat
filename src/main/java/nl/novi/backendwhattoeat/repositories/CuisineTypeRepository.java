package nl.novi.backendwhattoeat.repositories;

import nl.novi.backendwhattoeat.models.CuisineType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuisineTypeRepository extends JpaRepository<CuisineType, Long> {
}
