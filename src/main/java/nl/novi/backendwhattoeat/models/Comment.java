package nl.novi.backendwhattoeat.models;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    private Long id;
    private String text;

}
