package nl.novi.backendwhattoeat.controllers;

import nl.novi.backendwhattoeat.dtos.FavouriteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("favourites")
public class FavouriteController {

    private final FavouriteService favouriteService;

    @Autowired
    public FavouriteController(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
    }

    @GetMapping
    public ResponseEntity<List<FavouriteDto>> getAllFavourites(@RequestParam(value = "title", required = false) Optional<String> title) {
        List<FavouriteDto> dtos;
        if (title.isEmpty()){
            dtos = favouriteService.getAllFavourites();
        } else {
            dtos = favouriteService.findAllFavouritesByTitle (title.get());
        }
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<FavouriteDto> getFavouriteById(@PathVariable("id") Long id) {

        FavouriteDto favourite = favouriteService.getFavouriteById(id);

        return ResponseEntity.ok().body(favourite);

    }

    @PostMapping
    public ResponseEntity<FavouriteDto> createFavourite(@RequestBody FavouriteDto favouriteDto){

        FavouriteDto favourite = favouriteService.createFavourite(favouriteDto);

        final URI location = URI.create("/favourites/" + favourite.getId());
        return ResponseEntity.created(location).body(favourite);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFavourite(@PathVariable("id") Long id){
        favouriteService.deleteFavourite(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateFavourite(@PathVariable Long id, @RequestBody FavouriteDto newFavourite) {

        FavouriteDto dto = favouriteService.updateFavourite(id, newFavourite);

        return ResponseEntity.ok().body(dto);
    }


}
