package nl.novi.backendwhattoeat.services;

import nl.novi.backendwhattoeat.dtos.IngredientDto;
import nl.novi.backendwhattoeat.exceptions.RecordNotFoundException;
import nl.novi.backendwhattoeat.models.Ingredient;
import nl.novi.backendwhattoeat.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
        Ingredient ingredient =  transferToIngredient(ingredientDto);
        ingredientRepository.save(ingredient);
        return ingredientDto;
    }

    public void deleteIngredient( @RequestBody Long id) {
        ingredientRepository.deleteById(id);
    }

    public IngredientDto updateIngredient(Long id, IngredientDto ingredientDto) {

        if (ingredientRepository.findById(id).isPresent()) {

            Ingredient ingredient = ingredientRepository.findById(id).get();

            Ingredient newIngredient= transferToIngredient(ingredientDto);
            newIngredient.setId(ingredient.getId());

            ingredientRepository.save(newIngredient);

            return transferToDto(newIngredient);

        } else {
            throw new RecordNotFoundException("Geen ingredient gevonden");
        }
    }

    public IngredientDto transferToDto(Ingredient ingredient) {
        var dto = new IngredientDto();

        dto.id = ingredient.getId();
        dto.foodId = ingredient.getFoodId();
        dto.quantity = ingredient.getQuantity();
        dto.measure = ingredient.getMeasure();
        dto.foodCategory = ingredient.getFoodCategory();

        return dto;
    }

    public Ingredient transferToIngredient(IngredientDto dto){
        var ingredient = new Ingredient();

        ingredient.setId(dto.getId());
        ingredient.setFoodId(dto.getFoodId());
        ingredient.setQuantity(dto.getQuantity());
        ingredient.setMeasure(dto.getMeasure());
        ingredient.setFoodCategory(dto.getFoodCategory());

        return ingredient;
    }
}
