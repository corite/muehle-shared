package networking.entities;

import logic.entities.User;

import java.io.Serializable;

/**
 * meant to notify a client that he or his opponent has ended the session, and that the server has acted accordingly and deleted the Game
 */
public class EndGameResponse implements Serializable {
    private final User endingUser;
    private final String message;

    public EndGameResponse(User endingUser, String message) {
        this.endingUser = endingUser;
        this.message = message;
    }

    public User getEndingUser() {
        return endingUser;
    }

    public String getMessage() {
        return message;
    }
}
