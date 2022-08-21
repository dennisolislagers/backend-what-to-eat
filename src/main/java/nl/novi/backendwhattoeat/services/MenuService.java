package nl.novi.backendwhattoeat.services;

import nl.novi.backendwhattoeat.dtos.MenuDto;
import nl.novi.backendwhattoeat.exceptions.RecordNotFoundException;
import nl.novi.backendwhattoeat.models.Menu;
import nl.novi.backendwhattoeat.repositories.CuisineTypeRepository;
import nl.novi.backendwhattoeat.repositories.IngredientRepository;
import nl.novi.backendwhattoeat.repositories.LabelRepository;
import nl.novi.backendwhattoeat.repositories.MenuRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    private final CuisineTypeRepository cuisineTypeRepository;

    private final IngredientRepository ingredientRepository;

    private final LabelRepository labelRepository;

    public MenuService(MenuRepository menuRepository,
                       CuisineTypeRepository cuisineTypeRepository,
                       IngredientRepository ingredientRepository,
                       LabelRepository labelRepository) {
        this.menuRepository = menuRepository;
        this.cuisineTypeRepository = cuisineTypeRepository;
        this.ingredientRepository = ingredientRepository;
        this.labelRepository = labelRepository;
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
    public List<MenuDto> getAllMenusByHealthLabel (String label) {
        List<Menu> menuList = menuRepository.findAllMenusByLabelEqualsIgnoreCase(label);
        List<MenuDto> menuDtoList = new ArrayList<>();

        for(Menu menu : menuList){
            MenuDto dto = transferToDto(menu);
            menuDtoList.add(dto);
        }
        return menuDtoList;
    }

    public MenuDto addMenu(MenuDto dto) {
        Menu menu = transferToMenu(dto);
        menuRepository.save(menu);
        return transferToDto(menu);
    }

    public void deleteMenu(@RequestBody Long id) {
        menuRepository.deleteById(id);
    }

    public MenuDto updateMenu(Long id, MenuDto inputDto) {

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
        dto.setPortions(menu.getPortions());
        dto.setCalories(menu.getCalories());
        dto.setPeanutAllergy(menu.getPeanutAllergy());
        dto.setCowmilkAllergy(menu.getCowmilkAllergy());
        dto.setGlutenAllergy(menu.getGlutenAllergy());

        return dto;
    }

    public Menu transferToMenu(MenuDto dto){
        var menu = new Menu();

        menu.setId(dto.getId());
        menu.setTitle(dto.getTitle());
        menu.setPortions(dto.getPortions());
        menu.setCalories(dto.getCalories());
        menu.setPeanutAllergy(dto.getPeanutAllergy());
        menu.setCowmilkAllergy(dto.getCowmilkAllergy());
        menu.setGlutenAllergy(dto.getGlutenAllergy());

        return menu;
    }
    public void assignCuisineTypeToMenu(Long id, Long cuisineTypeId){
        var optionalMenu = menuRepository.findById(id);
        var optionalCuisineType = cuisineTypeRepository.findById(cuisineTypeId);

        if(optionalMenu.isPresent() && optionalCuisineType.isPresent()) {
            var menu = optionalMenu.get();
            var cuisineType = optionalCuisineType.get();

            menu.setCuisineType(cuisineType);
            menuRepository.save(menu);
        } else {
            throw new RecordNotFoundException();
        }
    }
    public void assignLabelToMenu(Long id, Long labelId){
        var optionalMenu = menuRepository.findById(id);
        var optionalLabel = labelRepository.findById(labelId);

        if(optionalMenu.isPresent() && optionalLabel.isPresent()) {
            var menu = optionalMenu.get();
            var label = optionalLabel.get();

            menu.setLabel(label);
            menuRepository.save(menu);
        } else {
            throw new RecordNotFoundException();
        }
    }


}




