package nl.novi.backendwhattoeat.controller;

import nl.novi.backendwhattoeat.repository.MenuRepository;
import nl.novi.backendwhattoeat.exceptions.RecordNotFoundException;
import nl.novi.backendwhattoeat.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/menus")
public class MenuController {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @GetMapping
    public ResponseEntity<List<Menu>> getAllMenus(@RequestParam(value = "title", required = false) String title) {
        List<Menu> menus;
        if (title == null){
            menus = menuRepository.findAll();
            return ResponseEntity.ok().body(menus);
        }else {
            menus = menuRepository.findAllMenusByTitleEqualsIgnoreCase(title);
        }
        return ResponseEntity.ok().body(menus);
    }
    @GetMapping("{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable("id") Long id) {

        Optional<Menu> menu = menuRepository.findById(id);

        if(menu.isEmpty()){
            throw new RecordNotFoundException("Er is geen gerecht gevonden met nummer: " + id);
        } else {
            Menu menu1 = menu.get();
            return ResponseEntity.ok().body(menu1);
        }
    }
    @PostMapping()
    public ResponseEntity<Menu> addMenu(@RequestBody Menu menu){

        menuRepository.save(menu);
        return ResponseEntity.created(null).body(menu);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteMenu(@PathVariable("id") Long id) {

        menuRepository.deleteById(id);

        return ResponseEntity.noContent().build();

    }

}