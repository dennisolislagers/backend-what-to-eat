package nl.novi.backendwhattoeat.exceptions;

import java.io.Serial;

public class UserNameNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public UserNameNotFoundException(String username) {
        super("Kan  " + username + " niet vinden!!");
    }

    public UserNameNotFoundException() {
        super("De gebruiker is niet gevonden");
    }

}
