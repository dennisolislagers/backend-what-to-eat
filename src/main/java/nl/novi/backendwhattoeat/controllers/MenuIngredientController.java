package nl.novi.backendwhattoeat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("menuingredient")
public class MenuIngredientController {
    private final MenuIngredientService menuIngredientService;

    @Autowired
    public MenuIngredientController (MenuIngredientService menuIngredientService){
        this.menuIngredientService = menuIngredientService;
    }

    @PostMapping
    public void addMenuIngredient(@PathVariable("menuId") Long menuId, @PathVariable("ingredientId") Long ingredientId){
        menuIngredientService.addMenuIngredient(menuId, ingredientId);
    }
}
