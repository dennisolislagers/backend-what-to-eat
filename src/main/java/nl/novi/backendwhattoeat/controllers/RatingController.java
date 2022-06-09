package nl.novi.backendwhattoeat.controllers;

import nl.novi.backendwhattoeat.dtos.RatingDto;
import nl.novi.backendwhattoeat.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping ("ratings")

public class RatingController {
    private final RatingService ratingService;

    @Autowired
    public RatingController (RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping
    public List<RatingDto> getAllRatings() {
        List<RatingDto> ratings = ratingService.getAllRatings();
        return ratings;
    }

    @GetMapping("{id}")
    public RatingDto getRatingById(@PathVariable("id") Long id) {
        RatingDto rating = ratingService.getRatingById(id);
        return rating;
    }

    @PostMapping
    public RatingDto addMenu(@RequestBody RatingDto ratingDto){
        RatingDto rating = ratingService.addRating(ratingDto);
        return rating;
    }

    @DeleteMapping("{id}")
    public void deleteRating(@PathVariable("id") Long id) {
        ratingService.deleteRating(id);
    }

}
