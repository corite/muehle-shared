package networking.entities;

import java.io.Serializable;

/**
 * meant to notify a client that he or his opponent has ended the session, and that the server has acted accordingly and deleted the Game
 */
public class EndSessionResponse implements Serializable {
    private final String message;

    public EndSessionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
