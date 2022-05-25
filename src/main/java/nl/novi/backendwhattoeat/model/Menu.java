package nl.novi.backendwhattoeat.model;

public class Menu {

    private String title;

    public Menu(){}

    public Menu(String title) {
       this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle (String title){
        this.title = title;
    }
}
