package nl.novi.backendwhattoeat.exceptions;

import java.io.Serial;

public class NotAuthorizedException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public NotAuthorizedException(String message) {
        super(message);
    }

    public NotAuthorizedException() {
        super("U heeft geen rechten om deze actie uit te voeren");
    }

}
