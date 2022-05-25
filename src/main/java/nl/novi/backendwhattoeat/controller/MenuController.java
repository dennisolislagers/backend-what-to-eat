package nl.novi.backendwhattoeat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import nl.novi.backendwhattoeat.model.Menu;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {


    @GetMapping
    public ResponseEntity<List<Menu>> getAllMenus() {
        final Menu broodjes = new Menu("broodjes");
        final Menu eitjes = new Menu("eitjes");
        final List<Menu> allMenus = List.of(broodjes, eitjes);
        return ResponseEntity.ok(allMenus);
    }

    @GetMapping("{title}")
    public ResponseEntity<Menu> getMenuByTitle(@PathVariable String title) {
        if ("broodjes".equals(title)) {
            return ResponseEntity.ok(new Menu("broodjes"));
        } else if ("eitjes".equals(title)) {
            return ResponseEntity.ok(new Menu("eitjes"));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping()
    public ResponseEntity<Menu> createMenu(@RequestBody Menu newMenu){
        System.out.println("Er is een nieuw gerecht met de titel: " + newMenu.getTitle());
        return ResponseEntity.created(null).build();
    }
}