package nl.novi.backendwhattoeat.controllers;

import nl.novi.backendwhattoeat.dtos.IngredientDto;
import nl.novi.backendwhattoeat.dtos.MenuDto;
import nl.novi.backendwhattoeat.services.IngredientService;
import nl.novi.backendwhattoeat.services.MenuIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
import java.util.List;


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
    public List<IngredientDto> getAllIngredients() {
        List<IngredientDto> ingredients = ingredientService.getAllIngredients();
        return ingredients;
    }

    @GetMapping("{id}")
    public IngredientDto getIngredientById(@PathVariable("id") Long id) {
        IngredientDto ingredient = ingredientService.getIngredientById(id);
        return ingredient;
    }

    @GetMapping("menus/{ingredientId}")
    public Collection<MenuDto> getMenuIngredientByIngredientId(@PathVariable("ingredientId") Long ingredientId){
        return menuIngredientService.getMenuIngredientByIngredientId(ingredientId);
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
