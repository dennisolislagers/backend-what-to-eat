package nl.novi.backendwhattoeat.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String type;
    public String webLabel;
    public String apiParameter;
    public String definition;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
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
