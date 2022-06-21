package nl.novi.backendwhattoeat.controllers;

import nl.novi.backendwhattoeat.services.MenuIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("menuingredient")
public class MenuIngredientController {
    private MenuIngredientService menuIngredientService;

    @Autowired
    public MenuIngredientController (MenuIngredientService menuIngredientService){
        this.menuIngredientService = menuIngredientService;
    }

    @PostMapping
    public void addMenuIngredient(@PathVariable("menuId") Long menuId, @PathVariable("ingredientId") Long ingredientId){
        menuIngredientService.addMenuIngredient(menuId, ingredientId);
    }
}
