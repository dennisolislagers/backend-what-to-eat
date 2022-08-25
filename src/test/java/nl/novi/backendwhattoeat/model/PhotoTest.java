package nl.novi.backendwhattoeat.model;

import nl.novi.backendwhattoeat.models.Photo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhotoTest {

    @Test
    void setId(){
        Photo photo = new Photo();
        photo.setId(1L);

        Long expected = 1L;
        assertEquals(expected, photo.getId());
    }
    @Test
    void setTitle(){
        Photo photo = new Photo();
        photo.setTitle("sajoer boontjes");

        String expected = "sajoer boontjes";
        assertEquals(expected, photo.getTitle());
    }
    @Test
    void setFileName(){
        Photo photo = new Photo();
        photo.setFileName("saj_boo_12");

        String expected = "saj_boo_12";
        assertEquals(expected, photo.getFileName());
    }
    @Test
    void setImageSize(){
        Photo photo = new Photo();
        photo.setImageSize("small");

        String expected = "small";
        assertEquals(expected, photo.getImageSize());
    }
    @Test
    void setDimensions(){
        Photo photo = new Photo();
        photo.setDimensions("200x200");

        String expected = "200x200";
        assertEquals(expected, photo.getDimensions());
    }
}
