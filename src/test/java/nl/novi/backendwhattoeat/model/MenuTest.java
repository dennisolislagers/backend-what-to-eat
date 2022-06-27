package nl.novi.backendwhattoeat.model;



import nl.novi.backendwhattoeat.models.Menu;
import org.junit.jupiter.api.*;



import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    Menu menu;

    @BeforeAll
    static void setupAll(){
    }

    @BeforeEach
    void setupEach(){
    }

    @Test
    void getTitle(){
        String actual = menu.getTitle();
        String expected = "titel van het menu";

        assertEquals(expected, actual);

    }
    @Test
    void getCuisineType(){
        String actual = menu.getCuisineType();
        String expected = "keukentype";

        assertEquals(expected, actual);
    }
    @Test
    void getHealthLabel(){
        String actual = menu.getHealthLabel();
        String expected = "gezondheidslabel";

        assertEquals(expected, actual);
    }
    @Test
    void getDietLabel(){
        String actual = menu.getDietLabel();
        String expected = "dieetvorm";

        assertEquals(expected, actual);
    }
    @Test
    void getPortions(){
        Integer actual = menu.getPortions();
        Integer expected = 8;

        assertEquals(expected, actual);
    }
    @Test
    void getCalories(){
        Integer actual = menu.getCalories();
        Integer expected = 250;

        assertEquals(expected, actual);
    }
    @Test
    void getHasPhoto(){
        boolean actual = menu.getHasPhoto();
        boolean expected = true;

        assertEquals(expected, actual);
    }
    @AfterEach
    void tearDown(){

    }

}
