package nl.novi.backendwhattoeat.dtos;


import lombok.Data;
import nl.novi.backendwhattoeat.models.Authority;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class CreateUserDto {

    @NotBlank (message = "gebruikersnaam moet ingevuld zijn")
    private String username;

    @Size(min=4, max=20, message = "het wachtwoord moet tussen 4 en 20 tekens lang zijn")
    private String password;

    @Email(message = "er is geen geldig emailadres ingevuld")
    private String emailadress;

    private String role;
    private boolean enabled;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailadress() {
        return emailadress;
    }

    public void setEmailadress(String emailadress) {
        this.emailadress = emailadress;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
