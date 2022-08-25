package nl.novi.backendwhattoeat.model;

import nl.novi.backendwhattoeat.models.Ingredient;
import nl.novi.backendwhattoeat.models.Label;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IngredientTest {

    @Test
    void setId(){
        Ingredient ingredient = new Ingredient();
        ingredient.setId(4L);

        Long expected = 4L;
        assertEquals(expected, ingredient.getId());
    }
    @Test
    void setFoodId(){
        Ingredient ingredient = new Ingredient();
        ingredient.setFoodId("salt");

        String expected = "salt";
        assertEquals(expected, ingredient.getFoodId());

    }
    @Test
    void setQuantity(){
        Ingredient ingredient = new Ingredient();
        ingredient.setQuantity(1);

        Integer expected = 1;
        assertEquals(expected, ingredient.getQuantity());

    }
    @Test
    void setMeasure(){
        Ingredient ingredient = new Ingredient();
        ingredient.setMeasure("teaspoon");
        String expected = "teaspoon";

        assertEquals(expected, ingredient.getMeasure());

    }
    @Test
    void setFoodCategory(){
        Ingredient ingredient = new Ingredient();
        ingredient.setFoodCategory("spices");
        String expected = "spices";

        assertEquals(expected, ingredient.getFoodCategory());
    }

}
