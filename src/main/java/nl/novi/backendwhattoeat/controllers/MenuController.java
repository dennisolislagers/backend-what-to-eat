package nl.novi.backendwhattoeat.controllers;

import nl.novi.backendwhattoeat.dtos.CreateMenuDto;
import nl.novi.backendwhattoeat.dtos.MenuDto;
import nl.novi.backendwhattoeat.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("menus")
public class MenuController {

    private final MenuService menuService;

    @Autowired

    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }

    @GetMapping
    public ResponseEntity<List<MenuDto>> getAllMenus(@RequestParam(value = "title", required = false) Optional<String> title) {

        List<MenuDto> dtos;

        if (title.isEmpty()){

            dtos = menuService.getAllMenus();

        } else {

            dtos = menuService.getAllMenusByTitle (title.get());

        }

        return ResponseEntity.ok().body(dtos);

    }

    @GetMapping("{id}")
    public ResponseEntity<MenuDto> getMenu(@PathVariable("id") Long id) {

        MenuDto menu = menuService.getMenuById(id);

        return ResponseEntity.ok().body(menu);

    }

    @PostMapping
    public ResponseEntity<Object> addMenu(@RequestBody CreateMenuDto createMenuDto){

        MenuDto menu = menuService.addMenu(createMenuDto);

        return ResponseEntity.created(null).body(menu);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteMenu(@PathVariable("id") Long id) {

        menuService.deleteMenu(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateMenu(@PathVariable Long id, @RequestBody CreateMenuDto newMenu) {

        MenuDto dto = menuService.updateMenu(id, newMenu);

            return ResponseEntity.ok().body(dto);
        }
    }
