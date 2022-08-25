package nl.novi.backendwhattoeat.services;

import nl.novi.backendwhattoeat.dtos.MenuDto;
import nl.novi.backendwhattoeat.exceptions.RecordNotFoundException;
import nl.novi.backendwhattoeat.models.Menu;
import nl.novi.backendwhattoeat.repositories.MenuRepository;
import nl.novi.backendwhattoeat.repositories.PhotoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    private final PhotoRepository photoRepository;

    private final PhotoService photoService;

    public MenuService(MenuRepository menuRepository, PhotoRepository photoRepository,
                       PhotoService photoService) {
        this.menuRepository = menuRepository;
        this.photoRepository = photoRepository;
        this.photoService = photoService;
    }

    public List<MenuDto> getAllMenus() {
        List<Menu> menuList = menuRepository.findAll();
        return transferMenuListToDtoList(menuList);
    }

    public List<MenuDto> getAllMenusByTitle(String title) {
        List<Menu> menuList = menuRepository.findAllMenusByTitleEqualsIgnoreCase(title);
        return transferMenuListToDtoList(menuList);
    }

    public List<MenuDto> getAllMenusByCuisineType (String cuisineType) {
        List<Menu> menuList = menuRepository.findAllMenusByCuisineTypeEqualsIgnoreCase(cuisineType);
        return transferMenuListToDtoList(menuList);
    }

    public List<MenuDto> getAllMenusByMealType (String mealType) {
        List<Menu> menuList = menuRepository.findAllMenusByMealTypeEqualsIgnoreCase(mealType);
        return transferMenuListToDtoList(menuList);
    }
    public List<MenuDto> getAllMenusByDishType (String dishType) {
        List<Menu> menuList = menuRepository.findAllMenusByDishTypeEqualsIgnoreCase(dishType);
        return transferMenuListToDtoList(menuList);
    }

    public List <MenuDto> transferMenuListToDtoList(List<Menu> menus){
        List<MenuDto> menuDtoList = new ArrayList<>();

        for(Menu meal : menus){
            MenuDto dto = transferToDto(meal);
            if(meal.getPhoto() != null){
                dto.setPhotoDto(photoService.transferToDto(meal.getPhoto()));
            }
            menuDtoList.add(dto);
        }
        return menuDtoList;
    }

    public MenuDto getMenuById(Long id) {
        if (menuRepository.findById(id).isPresent()) {
            Menu meal = menuRepository.findById(id).get();
            MenuDto dto = transferToDto(meal);
            if(meal.getPhoto() != null){
                dto.setPhotoDto(photoService.transferToDto(meal.getPhoto()));
            }
            return transferToDto(meal);
        }else{
            throw new RecordNotFoundException("geen menu gevonden");
        }
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
    public static MenuDto transferToDto(Menu menu){
        MenuDto dto = new MenuDto();

        dto.setId(menu.getId());
        dto.setTitle(menu.getTitle());
        dto.setPortions(menu.getPortions());
        dto.setCalories(menu.getCalories());
        dto.setCuisineType(menu.getCuisineType());
        dto.setMealType(menu.getMealType());
        dto.setDishType(menu.getDishType());
        dto.setVegan(menu.getVegan());
        dto.setPeanutAllergy(menu.getPeanutAllergy());
        dto.setCowmilkAllergy(menu.getCowmilkAllergy());
        dto.setGlutenAllergy(menu.getGlutenAllergy());
        if(menu.getPhoto() != null){
            dto.setPhotoDto(PhotoService.transferToDto(menu.getPhoto()));
        }

        return dto;
    }

    public Menu transferToMenu(MenuDto dto){
        var menu = new Menu();

        menu.setId(dto.getId());
        menu.setTitle(dto.getTitle());
        menu.setPortions(dto.getPortions());
        menu.setCalories(dto.getCalories());
        menu.setCuisineType(dto.getCuisineType());
        menu.setMealType(dto.getMealType());
        menu.setDishType(dto.getDishType());
        menu.setVegan(dto.getVegan());
        menu.setPeanutAllergy(dto.getPeanutAllergy());
        menu.setCowmilkAllergy(dto.getCowmilkAllergy());
        menu.setGlutenAllergy(dto.getGlutenAllergy());

        return menu;
    }

    public void assignPhotoToMenu(Long id, Long photoId){
        var optionalMenu = menuRepository.findById(id);
        var optionalPhoto = photoRepository.findById(photoId);

        if(optionalMenu.isPresent() && optionalPhoto.isPresent()) {
            var menu = optionalMenu.get();
            var photo = optionalPhoto.get();

            menu.setPhoto(photo);
            menuRepository.save(menu);
        } else {
            throw new RecordNotFoundException();
        }
    }
}




