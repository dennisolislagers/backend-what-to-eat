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
    public IngredientDto getIngredient(@PathVariable("id") Long id) {
        IngredientDto ingredientDto = ingredientService.getIngredientById(id);
        return ingredientDto;
    }

    @PostMapping
    public IngredientDto addIngredient(@RequestBody IngredientDto dto) {
        IngredientDto ingredient = ingredientService.addIngredient(dto);
        return ingredient;
    }

    @DeleteMapping("{id}")
    public void deleteIngredient (@PathVariable("id") Long id) {ingredientService.deleteIngredient(id);
    }
    @PutMapping("{id}")
    public IngredientDto updateIngredient(@PathVariable("id") Long id, @RequestBody IngredientDto dto) {
        ingredientService.updateIngredient(id, dto);
        return dto;
    }

    @GetMapping("menus/{ingredientId}")
    public Collection<MenuDto> getMenuByIngredientId(@PathVariable("ingredientId") Long ingredientId){
        return menuIngredientService.getMenuIngredientByIngredientId(ingredientId);
    }
}
