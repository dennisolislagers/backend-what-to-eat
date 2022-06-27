package nl.novi.backendwhattoeat.exceptions;

import java.io.Serial;

public class InvalidPasswordException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public InvalidPasswordException(String message) {
        super(message);
    }

    public InvalidPasswordException() {
        super("Het wachtwoord moet minmaal 1 kleine letter en 1 cijfer bevatten.");
    }
}
