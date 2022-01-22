package networking.entities;

import logic.entities.User;

import java.io.Serializable;

/**
 * This action is sent by the client if he wants to end the session. It triggers the removal of this user from the Server.
 * If the User is still in a Game, EndGameAction has to be sent first.
 */
public class EndSessionAction implements Serializable {
    private final User user;

    public EndSessionAction(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
