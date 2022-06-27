package nl.novi.backendwhattoeat.controllers;

import nl.novi.backendwhattoeat.dtos.FavouriteDto;
import nl.novi.backendwhattoeat.dtos.IngredientDto;
import nl.novi.backendwhattoeat.dtos.MenuDto;
import nl.novi.backendwhattoeat.services.IngredientService;
import nl.novi.backendwhattoeat.services.MenuIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("ingredients")
public class IngredientController {
    
    private final IngredientService ingredientService;
    private final MenuIngredientService menuIngredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService, MenuIngredientService menuIngredientService){
        this.ingredientService = ingredientService;
        this.menuIngredientService = menuIngredientService;
    }

    @GetMapping
    public ResponseEntity<List<IngredientDto>> getAllIngredients(@RequestParam(value = "product_name", required = false) Optional<String> productName) {
        List<IngredientDto> dtos;
        if(productName.isEmpty()){
            dtos = ingredientService.getAllIngredients();
        }else{
            dtos = ingredientService.findAllIngredientsByProductName(productName.get());
        }
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<IngredientDto> getIngredientById(@PathVariable("id") Long id) {
        IngredientDto ingredient = ingredientService.getIngredientById(id);
        return ResponseEntity.ok().body(ingredient);
    }

    @GetMapping("menus/{ingredientId}")
    public Collection<MenuDto> getMenuIngredientByIngredientId(@PathVariable("ingredientId") Long ingredientId){
        return menuIngredientService.getMenuIngredientByIngredientId(ingredientId);
    }


    @PostMapping
    public ResponseEntity<IngredientDto> addPhoto(@RequestBody IngredientDto ingredientDto){
        IngredientDto ingredient = ingredientService.addIngredient(ingredientDto);

        final URI location = URI.create("/ingredients/" + ingredient.getId());
        return ResponseEntity.created(location).body(ingredient);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteIngredient(@PathVariable("id") Long id) {
        ingredientService.deleteIngredient(id);

        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public ResponseEntity<Object> updateIngredient(@PathVariable Long id, @RequestBody IngredientDto newIngredient) {

        IngredientDto dto = ingredientService.updateIngredient(id, newIngredient);

        return ResponseEntity.ok().body(dto);
    }
}
