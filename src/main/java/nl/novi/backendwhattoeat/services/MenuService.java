package nl.novi.backendwhattoeat.services;

import nl.novi.backendwhattoeat.dtos.MenuDto;
import nl.novi.backendwhattoeat.dtos.CreateMenuDto;
import nl.novi.backendwhattoeat.exceptions.RecordNotFoundException;
import nl.novi.backendwhattoeat.models.Menu;
import nl.novi.backendwhattoeat.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<Menu> menuList = menuRepository.findAll();
        List<MenuDto> menuDtoList = new ArrayList<>();

        for(Menu menu : menuList) {
            MenuDto dto = transferToDto(menu);
            menuDtoList.add(dto);
        }
        return menuDtoList;
    }

    public MenuDto getMenuById(Long id) {
        if (menuRepository.findById(id).isPresent()) {
            Menu menu = menuRepository.findById(id).get();
            return transferToDto(menu);
        }else{
            throw new RecordNotFoundException("geen menu gevonden");
        }
    }

    public List<MenuDto> getAllMenusByTitle(String title) {
        List<Menu> menuList = menuRepository.findAllMenusByTitleEqualsIgnoreCase(title);
        List<MenuDto> menuDtoList = new ArrayList<>();

        for(Menu menu : menuList){
            MenuDto dto = transferToDto(menu);
            menuDtoList.add(dto);
        }
        return menuDtoList;
    }

    public List<MenuDto> getAllMenusByCuisineType (String cuisineType) {
        List<Menu> menuList = menuRepository.findAllMenusByCuisineTypeEqualsIgnoreCase(cuisineType);
        List<MenuDto> menuDtoList = new ArrayList<>();

        for(Menu menu : menuList){
            MenuDto dto = transferToDto(menu);
            menuDtoList.add(dto);
        }
        return menuDtoList;
    }
    public List<MenuDto> getAllMenusByHealthLabel (String healthLabel) {
        List<Menu> menuList = menuRepository.findAllMenusByHealthLabelEqualsIgnoreCase(healthLabel);
        List<MenuDto> menuDtoList = new ArrayList<>();

        for(Menu menu : menuList){
            MenuDto dto = transferToDto(menu);
            menuDtoList.add(dto);
        }
        return menuDtoList;
    }

    public List<MenuDto> getAllMenusByDietLabel (String dietLabel) {
        List<Menu> menuList = menuRepository.findAllMenusByDietLabelEqualsIgnoreCase(dietLabel);
        List<MenuDto> menuDtoList = new ArrayList<>();

        for(Menu menu : menuList){
            MenuDto dto = transferToDto(menu);
            menuDtoList.add(dto);
        }
        return menuDtoList;
    }
    public MenuDto addMenu(CreateMenuDto dto) {
        Menu menu = transferToMenu(dto);
        menuRepository.save(menu);
        return transferToDto(menu);
    }

    public void deleteMenu(@RequestBody Long id) {
        menuRepository.deleteById(id);
    }

    public MenuDto updateMenu(Long id, CreateMenuDto inputDto) {

        if (menuRepository.findById(id).isPresent()){

            Menu menu = menuRepository.findById(id).get();

            Menu menu1 = transferToMenu(inputDto);
            menu1.setId(menu.getId());

            menuRepository.save(menu1);

            return transferToDto(menu1);

        } else {

            throw new RecordNotFoundException("geen menu gevonden");

        }

    }

    public MenuDto transferToDto(Menu menu){
        MenuDto dto = new MenuDto();

        dto.setId(menu.getId());
        dto.setTitle(menu.getTitle());
        dto.setCuisineType(menu.getCuisineType());
        dto.setHealthLabel(menu.getHealthLabel());
        dto.setDietLabel(menu.getDietLabel());
        dto.setHasPhoto(menu.getHasPhoto());
        dto.setCalories(menu.getCalories());
        dto.setPortions(menu.getPortions());

        return dto;
    }

    public Menu transferToMenu(CreateMenuDto createMenu){
        var menu = new Menu();

        menu.setTitle(createMenu.getTitle());
        menu.setCuisineType(createMenu.getCuisineType());
        menu.setHealthLabel(createMenu.getHealthLabel());
        menu.setDietLabel(createMenu.getDietLabel());
        menu.setCalories(createMenu.getCalories());
        menu.setPortions(createMenu.getPortions());
        menu.setHasPhoto(createMenu.getHasPhoto());

        return menu;
    }


}




