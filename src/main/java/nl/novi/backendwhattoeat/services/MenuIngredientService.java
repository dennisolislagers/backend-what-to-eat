package nl.novi.backendwhattoeat.services;

import nl.novi.backendwhattoeat.dtos.IngredientDto;
import nl.novi.backendwhattoeat.dtos.MenuDto;
import nl.novi.backendwhattoeat.exceptions.RecordNotFoundException;
import nl.novi.backendwhattoeat.models.Ingredient;
import nl.novi.backendwhattoeat.models.Menu;
import nl.novi.backendwhattoeat.models.MenuIngredient;
import nl.novi.backendwhattoeat.models.MenuIngredientKey;
import nl.novi.backendwhattoeat.repositories.IngredientRepository;
import nl.novi.backendwhattoeat.repositories.MenuIngredientRepository;
import nl.novi.backendwhattoeat.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class MenuIngredientService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private MenuIngredientRepository menuIngredientRepository;

    public Collection<MenuDto> getMenuIngredientByIngredientId(Long ingredientId){
        Collection<MenuDto> dtos = new HashSet<>();
        Collection<MenuIngredient> menuIngredients = menuIngredientRepository.findAllByIngredientId(ingredientId);
        for(MenuIngredient menuIngredient : menuIngredients){
            Menu menu = menuIngredient.getMenu();
            MenuDto dto = new MenuDto();

            menu.setId(dto.getId());
            menu.setTitle(dto.getTitle());
            menu.setCuisineType(dto.getCuisineType());
            menu.setDietLabel(dto.getDietLabel());
            menu.setCalories(dto.getCalories());
            menu.setPortions(dto.getPortions());
            menu.setHasPhoto(dto.getHasPhoto());
            menu.setHealthLabel(dto.getHealthLabel());

            dtos.add(dto);
        }
        return dtos;
    }

    public Collection<IngredientDto> getMenuIngredientByMenuId(Long menuId){
        Collection<IngredientDto> dtos = new HashSet<>();
        Collection<MenuIngredient> menuIngredients = menuIngredientRepository.findAllByIngredientId(menuId);
        for(MenuIngredient menuIngredient : menuIngredients){
            Ingredient ingredient = menuIngredient.getIngredient();
            IngredientDto dto = new IngredientDto();

            ingredient.setId(dto.getId());
            ingredient.setProductName(dto.getProductName());
            ingredient.setSort(dto.getSort());
            ingredient.setAmount(dto.getAmount());


            dtos.add(dto);
        }
        return dtos;
    }
    public MenuIngredientKey addMenuIngredient(Long menuId, Long ingredientId){
        var menuIngredient = new MenuIngredient();
        if (!menuRepository.existsById(menuId)) {
            throw new RecordNotFoundException();
        }
        Menu menu = menuRepository.findById(menuId).orElse(null);
        if (!ingredientRepository.existsById(ingredientId)) {
            throw new RecordNotFoundException();
        }
        Ingredient ingredient = ingredientRepository.findById(ingredientId).orElse(null);
        menuIngredient.setMenu(menu);
        menuIngredient.setIngredient(ingredient);
        MenuIngredientKey id = new MenuIngredientKey(menuId, ingredientId);
        menuIngredient.setId(id);
        menuIngredientRepository.save(menuIngredient);
        return id;
    }
}
