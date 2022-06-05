package nl.novi.backendwhattoeat.services;

import nl.novi.backendwhattoeat.Dtos.MenuDto;
import nl.novi.backendwhattoeat.Dtos.MenuInputDto;
import nl.novi.backendwhattoeat.exceptions.MenuNotFoundException;
import nl.novi.backendwhattoeat.models.Menu;
import nl.novi.backendwhattoeat.repositories.MenuRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository){
        this.menuRepository = menuRepository;
    }

    public List<MenuDto> getAllMenus() {
        List<Menu> recipeList = menuRepository.findAll();
        List<MenuDto> recipeDtoList = new ArrayList<>();

        for (Menu recipe : recipeList) {
            MenuDto dto = transferToDto(recipe);
            recipeDtoList.add(dto);
        }
        return recipeDtoList;
    }

    public List<MenuDto> getAllMenusByCuisineType(String cuisineType) {
        List<Menu> recipeList = menuRepository.findAllMenusByCuisineTypeEqualsIgnoreCase(cuisineType);
        List<MenuDto> recipeDtoList = new ArrayList<>();

        for (Menu recipe : recipeList) {
            MenuDto dto = transferToDto(recipe);
            recipeDtoList.add(dto);
        }
        return recipeDtoList;
    }

        public MenuDto getMenuById(Long id) {

            if (menuRepository.findById(id).isPresent()){
                Menu recipe = menuRepository.findById(id).get();
                return transferToDto(recipe);
            } else {
                throw new MenuNotFoundException("geen menu gevonden");
        }
    }

    public MenuDto addMenu(MenuInputDto dto) {

        Menu recipe = transferToMenu(dto);
        menuRepository.save(recipe);

        return transferToDto(recipe);
    }

    public void deleteMenu(@RequestBody Long id) {

        menuRepository.deleteById(id);

    }

        public MenuDto updateMenu(Long id, MenuInputDto inputDto) {

            if (menuRepository.findById(id).isPresent()){

                Menu recipe = menuRepository.findById(id).get();

                Menu recipe1 = transferToMenu(inputDto);
                recipe1.setId(recipe.getId());

                menuRepository.save(recipe1);

                return transferToDto(recipe1);

            } else {

                throw new MenuNotFoundException("geen menu gevonden");

            }

        }

        public Menu transferToMenu(MenuInputDto dto){
        var menu = new Menu();

        menu.setTitle(dto.getTitle());
        menu.setCuisineType(dto.getCuisineType());
        menu.setHealthLabel(dto.getHealthLabel());
        menu.setDietLabel(dto.getDietLabel());
        menu.setHasPhoto(dto.getHasPhoto());
        menu.setRating(dto.getRating());

        return menu;
    }

    public MenuDto transferToDto(Menu menu){
        MenuDto dto = new MenuDto();

        dto.setId(menu.getId());
        dto.setTitle(menu.getTitle());
        dto.setCuisineType(menu.getCuisineType());
        dto.setHealthLabel(menu.getHealthLabel());
        dto.setDietLabel(menu.getDietLabel());
        dto.setHasPhoto(menu.getHasPhoto());
        dto.setRating(menu.getRating());

        return dto;
    }

}
