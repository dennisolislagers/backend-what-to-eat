package nl.novi.backendwhattoeat.repositories;


import nl.novi.backendwhattoeat.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RatingRepository extends JpaRepository <Rating, Long> {
    Optional<Rating> findRatingByRatingEqualsIgnoreCase(Integer rating);
}
