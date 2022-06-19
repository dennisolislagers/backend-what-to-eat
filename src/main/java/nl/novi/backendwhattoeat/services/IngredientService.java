package nl.novi.backendwhattoeat.services;

import nl.novi.backendwhattoeat.dtos.IngredientDto;
import nl.novi.backendwhattoeat.exceptions.RecordNotFoundException;
import nl.novi.backendwhattoeat.models.Ingredient;
import nl.novi.backendwhattoeat.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public List<IngredientDto> getAllIngredients() {
        List<IngredientDto> dtos = new ArrayList<>();
        List<Ingredient> ingredients = ingredientRepository.findAll();
        for (Ingredient ingredient: ingredients) {
            dtos.add(transferToDto(ingredient));
        }
        return dtos;
    }

    public IngredientDto getIngredientById(Long id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if(ingredient.isPresent()) {
            return transferToDto(ingredient.get());
        } else {
            throw new RecordNotFoundException("No ingredient with " + id + " found");
        }
    }

    public IngredientDto addIngredient(IngredientDto ingredientDto) {
        Ingredient photo =  transferToIngredient(ingredientDto);
        ingredientRepository.save(photo);
        return ingredientDto;
    }

    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }

    public IngredientDto transferToDto(Ingredient ingredient) {
        var dto = new IngredientDto();

        dto.id = ingredient.getId();
        dto.productName = ingredient.getProductName();
        dto.sort = ingredient.getSort();
        dto.amount = ingredient.getAmount();

        return dto;
    }

    public Ingredient transferToIngredient(IngredientDto dto){
        var ingredient = new Ingredient();

        ingredient.setId(dto.getId());
        ingredient.setProductName(dto.getProductName());
        ingredient.setSort(dto.getSort());
        ingredient.setAmount(dto.getAmount());

        return ingredient;
    }

}
