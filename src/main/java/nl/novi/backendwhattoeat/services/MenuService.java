package nl.novi.backendwhattoeat.services;

import nl.novi.backendwhattoeat.dtos.MenuDto;
import nl.novi.backendwhattoeat.dtos.CreateMenuDto;
import nl.novi.backendwhattoeat.exceptions.RecordNotFoundException;
import nl.novi.backendwhattoeat.models.Menu;
import nl.novi.backendwhattoeat.repositories.CommentRepository;
import nl.novi.backendwhattoeat.repositories.MenuRepository;
import nl.novi.backendwhattoeat.repositories.RatingRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    private final CommentRepository commentRepository;

    private final CommentService commentService;

    private final RatingService ratingService;

    private final RatingRepository ratingRepository;

    public MenuService(MenuRepository menuRepository,
                       CommentRepository commentRepository,
                       CommentService commentService,
                       RatingRepository ratingRepository,
                       RatingService ratingService){
        this.menuRepository = menuRepository;
        this.commentRepository = commentRepository;
        this.commentService = commentService;
        this.ratingService = ratingService;
        this.ratingRepository = ratingRepository;
    }

    public List<MenuDto> getAllMenus() {
        List<Menu> menuList = menuRepository.findAll();
        return transferMenuListToDtoList(menuList);
    }

    public List<MenuDto> getAllMenusByTitle(String title) {
        List<Menu> menuList = menuRepository.findAllMenusByTitleEqualsIgnoreCase(title);
        return transferMenuListToDtoList(menuList);
    }

    public List<MenuDto> transferMenuListToDtoList(List<Menu> menus){
        List<MenuDto> menuDtoList = new ArrayList<>();

        for(Menu menu : menus) {
            MenuDto dto = transferToDto(menu);
            if(menu.getComment() != null){
                dto.setCommentDto(commentService.transferToDto(menu.getComment()));
            }
            menuDtoList.add(dto);
        }
        return menuDtoList;
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
                throw new RecordNotFoundException("geen menu gevonden");
        }
    }

    public MenuDto addMenu(CreateMenuDto dto) {

        Menu recipe = transferToMenu(dto);
        menuRepository.save(recipe);

        return transferToDto(recipe);
    }

    public void deleteMenu(@RequestBody Long id) {

        menuRepository.deleteById(id);

    }

        public MenuDto updateMenu(Long id, CreateMenuDto inputDto) {

            if (menuRepository.findById(id).isPresent()){

                Menu recipe = menuRepository.findById(id).get();

                Menu recipe1 = transferToMenu(inputDto);
                recipe1.setId(recipe.getId());

                menuRepository.save(recipe1);

                return transferToDto(recipe1);

            } else {

                throw new RecordNotFoundException("geen menu gevonden");

            }

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

}
