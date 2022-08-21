package nl.novi.backendwhattoeat.models;

import javax.persistence.*;

@Entity
public class CuisineType {

    @Id
    @GeneratedValue

    private Long Id;

    private String name;
    private String description;

    @OneToOne(mappedBy = "cuisineType")

    Menu menu;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
