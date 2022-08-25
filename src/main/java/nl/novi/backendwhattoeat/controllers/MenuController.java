package nl.novi.backendwhattoeat.controllers;

import nl.novi.backendwhattoeat.dtos.IdInputDto;
import nl.novi.backendwhattoeat.dtos.IngredientDto;
import nl.novi.backendwhattoeat.dtos.MenuDto;
import nl.novi.backendwhattoeat.services.MenuIngredientService;
import nl.novi.backendwhattoeat.services.MenuService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("menus")
public class MenuController {

    private final MenuService menuService;
    private final MenuIngredientService menuIngredientService;

    @Autowired
    public MenuController(MenuService menuService,
                          MenuIngredientService menuIngredientService){
        this.menuService = menuService;
        this.menuIngredientService = menuIngredientService;
    }

    @GetMapping
    public ResponseEntity<List<MenuDto>> getAllMenus(@RequestParam(value = "title", required = false)
                                                     Optional<String> title,
                                                     @RequestParam(value = "cuisine_type", required = false)
                                                     Optional<String> cuisineType,
                                                     @RequestParam(value = "mealType", required = false)
                                                     Optional<String> mealType,
                                                     @RequestParam(value ="dishType", required = false)
                                                     Optional<String> dishType)
                                                      {
        List<MenuDto> dtos;
        if (title.isPresent() && cuisineType.isEmpty() && mealType.isEmpty() && dishType.isEmpty()) {
            dtos = menuService.getAllMenusByTitle (title.get());
        } else if (title.isEmpty() && cuisineType.isPresent() && mealType.isEmpty() && dishType.isEmpty()){
            dtos = menuService.getAllMenusByCuisineType(cuisineType.get());
        } else if (title.isEmpty() && cuisineType.isEmpty() && mealType.isPresent() && dishType.isEmpty()){
            dtos = menuService.getAllMenusByMealType(mealType.get());
        } else if (title.isEmpty() && cuisineType.isEmpty() && mealType.isEmpty() && dishType.isPresent()) {
            dtos = menuService.getAllMenusByDishType(dishType.get());
        } else{
            dtos = menuService.getAllMenus();
            }
            return ResponseEntity.ok().body(dtos);

    }

    @GetMapping("{id}")
    public ResponseEntity<MenuDto> getMenu(@PathVariable ("id") Long id) {

        MenuDto menu = menuService.getMenuById(id);

        return ResponseEntity.ok().body(menu);

    }

    @GetMapping("ingredients/{menuId}")
    public Collection<IngredientDto> getMenuIngredientByMenuId(@PathVariable("menuId") Long menuId){
        return menuIngredientService.getMenuIngredientByMenuId(menuId);
    }


    @PostMapping
    public ResponseEntity<Object> addMenu(@RequestBody MenuDto menuDto){

        final MenuDto menu = menuService.addMenu(menuDto);

        final URI location = URI.create("/menus/" + menu.getId());
        return ResponseEntity.created(location).body(menu);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteMenu(@PathVariable("id") Long id) {

        menuService.deleteMenu(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("{id}/photo")
    public void assignPhotoToMenu(@PathVariable("id") Long id, @RequestBody IdInputDto input) {
        menuService.assignPhotoToMenu(id, input.id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateMenu(@PathVariable Long id, @RequestBody MenuDto newMenu) {

        MenuDto dto = menuService.updateMenu(id, newMenu);

            return ResponseEntity.ok().body(dto);
        }
    }
