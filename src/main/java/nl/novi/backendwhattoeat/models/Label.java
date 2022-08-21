package nl.novi.backendwhattoeat.models;


import javax.persistence.*;

@Entity
public class Label {

    @Id
    @GeneratedValue
    Long id;

    private String type;
    private String webLabel;
    private String apiParameter;
    private String definition;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWebLabel() {
        return webLabel;
    }

    public void setWebLabel(String webLabel) {
        this.webLabel = webLabel;
    }

    public String getApiParameter() {
        return apiParameter;
    }

    public void setApiParameter(String apiParameter) {
        this.apiParameter = apiParameter;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
