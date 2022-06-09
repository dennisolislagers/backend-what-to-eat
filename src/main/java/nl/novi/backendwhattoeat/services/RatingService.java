package nl.novi.backendwhattoeat.services;

import nl.novi.backendwhattoeat.dtos.RatingDto;
import nl.novi.backendwhattoeat.models.Rating;
import nl.novi.backendwhattoeat.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public List<RatingDto> getAllRatings() {
        List<RatingDto> dtos = new ArrayList<>();
        List<Rating> ratings = ratingRepository.findAll();
        for (Rating rating : ratings) {
            dtos.add(transfersToDto(rating));
        }
        return dtos;
    }

    public RatingDto getRatingByRating (Integer rating){
        Optional<Rating> rating =
    }

    public RatingDto getRatingById(Long id) {
        return null;
    }

    public RatingDto addRating(RatingDto ratingDto) {
        return null;
    }

    public void deleteRating(Long id) {
        return null;
    }
}
