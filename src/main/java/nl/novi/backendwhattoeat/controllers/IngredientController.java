package nl.novi.backendwhattoeat.controllers;

import nl.novi.backendwhattoeat.dtos.IngredientDto;
import nl.novi.backendwhattoeat.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("ingredients")
public class IngredientController {
    
    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService){
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<IngredientDto> getAllIngredients() {
        List<IngredientDto> ingredients = ingredientService.getAllIngredients();
        return ingredients;
    }

    @GetMapping("{id}")
    public IngredientDto getIngredientById(@PathVariable("id") Long id) {
        IngredientDto ingredient = ingredientService.getIngredientById(id);
        return ingredient;
    }

    @PostMapping
    public IngredientDto addPhoto(@RequestBody IngredientDto ingredientDto){
        IngredientDto ingredient = ingredientService.addIngredient(ingredientDto);
        return ingredient;
    }

    @DeleteMapping("{id}")
    public void deleteIngredient(@PathVariable("id") Long id) {
        ingredientService.deleteIngredient(id);
    }
}
