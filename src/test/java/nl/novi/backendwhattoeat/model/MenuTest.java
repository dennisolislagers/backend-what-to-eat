package nl.novi.backendwhattoeat.model;

import nl.novi.backendwhattoeat.models.Menu;
import org.junit.jupiter.api.*;

import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    void setId(){
        Menu menu = new Menu();
        menu.setId(1L);

        Long expected = 1L;
        assertEquals(expected, menu.getId());
    }

    @Test
    void setTitle(){
        Menu menu = new Menu();
        menu.setTitle("sajoer boontjes");

        String expected = "sajoer boontjes";
        assertEquals(expected, menu.getTitle());
    }
    @Test
    void setPortions(){
        Menu menu = new Menu();
        menu.setPortions(4);

        Integer expected = 4;
        assertEquals(expected, menu.getPortions());
    }
    @Test
    void setCalories(){
        Menu menu = new Menu();
        menu.setCalories(850);
        Integer expected = 850;

        assertEquals(expected, menu.getCalories());
    }

    @Test
    void setCuisineType(){
        Menu menu = new Menu();
        menu.setCuisineType("asian");
        String expected = "asian";

        assertEquals(expected, menu.getCuisineType());
    }
    @Test
    void setmealType(){
        Menu menu = new Menu();
        menu.setMealType("dinner");
        String expected = "dinner";

        assertEquals(expected, menu.getMealType());
    }
    @Test
    void setDishType(){
        Menu menu = new Menu();
        menu.setDishType("side dish");
        String expected = "side dish";

        assertEquals(expected, menu.getDishType());
    }
    @Test
    void setVegan(){
        Menu menu = new Menu();
        menu.setVegan(TRUE);
        boolean expected = TRUE;

        assertEquals(expected, menu.getVegan());
    }
    @Test
    void setPeanutAllergy(){
        Menu menu = new Menu();
        menu.setPeanutAllergy(TRUE);
        boolean expected = TRUE;

        assertEquals(expected, menu.getPeanutAllergy());
    }
    @Test
    void setCowmilkAllergy(){
        Menu menu = new Menu();
        menu.setCowmilkAllergy(TRUE);
        boolean expected = TRUE;

        assertEquals(expected, menu.getCowmilkAllergy());
    }
    @Test
    void setGlutenAllergy(){
        Menu menu = new Menu();
        menu.setGlutenAllergy(TRUE);
        boolean expected = TRUE;

        assertEquals(expected, menu.getGlutenAllergy());
    }


}
