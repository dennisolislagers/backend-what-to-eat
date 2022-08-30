package nl.novi.backendwhattoeat.dtos;

public class LabelDto {

    public Long id;
    public String type;
    public String webLabel;
    public String apiParameter;
    public String definition;

    private MenuDto menuDto;

    public MenuDto getMenuDto() {
        return menuDto;
    }

    public void setMenuDto(MenuDto menuDto) {
        this.menuDto = menuDto;
    }

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

}
