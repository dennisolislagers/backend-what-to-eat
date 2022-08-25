package nl.novi.backendwhattoeat.model;

import nl.novi.backendwhattoeat.models.Label;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LabelTest {

    @Test
    void setId(){
        Label label = new Label();
        label.setId(2L);

        Long expected = 2L;
        assertEquals(expected, label.getId());
    }

    @Test
    void setType(){
        Label label = new Label();
        label.setType("Health");

        String expected = "Health";
        assertEquals(expected, label.getType());
    }
    @Test
    void setWebLabel(){
        Label label = new Label();
        label.setWebLabel("Celery-Free");

        String expected = "Celery-Free";
        assertEquals(expected, label.getWebLabel());
    }
    @Test
    void setApiParameter(){
        Label label = new Label();
        label.setApiParameter("celery-free");

        String expected = "celery-free";
        assertEquals(expected, label.getApiParameter());
    }
    @Test
    void setDefinition(){
        Label label = new Label();
        label.setDefinition(" does not contain celery or deritavives");

        String expected = " does not contain celery or deritavives";
        assertEquals(expected, label.getDefinition());
    }
}
