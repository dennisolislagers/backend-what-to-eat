package nl.novi.backendwhattoeat.exceptions;

import java.io.Serial;

public class UserNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public UserNotFoundException(String username) {
        super("Kan  " + username + " niet vinden!!");
    }

    public UserNotFoundException() {
        super("De gebruiker is niet gevonden");
    }

}
