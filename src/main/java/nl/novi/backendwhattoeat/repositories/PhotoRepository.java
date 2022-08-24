package nl.novi.backendwhattoeat.repositories;

import nl.novi.backendwhattoeat.models.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
