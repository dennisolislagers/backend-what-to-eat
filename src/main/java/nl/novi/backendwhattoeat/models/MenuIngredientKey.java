package nl.novi.backendwhattoeat.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MenuIngredientKey implements Serializable {

    @Column(name = "menu_id")
    private Long menuId;

    @Column(name = "ingredient_id")
    private Long ingredientId;

    public MenuIngredientKey(){}
    public MenuIngredientKey(Long menuId, Long ingredientId){
        this.menuId = menuId;
        this.ingredientId = ingredientId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    @Override
    public boolean equals(Object object){
       if(this == object) return true;
       if(object == null || getClass() != object.getClass()) return false;
       MenuIngredientKey that = (MenuIngredientKey) object;
       return menuId.equals(that.menuId)&& ingredientId.equals(that.ingredientId);
    }
    @Override
    public int hashCode(){return Objects.hash(menuId, ingredientId);}
}
