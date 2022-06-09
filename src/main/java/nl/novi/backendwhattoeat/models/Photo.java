package nl.novi.backendwhattoeat.models;

import javax.persistence.*;

@Entity
public class Photo {

    @Id
    @GeneratedValue
    private Long id;
    private String fileName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
