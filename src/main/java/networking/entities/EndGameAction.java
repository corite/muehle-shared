package networking.entities;

import logic.entities.Player;

import java.io.Serializable;

/**
 * is used to disconnect a Player from an active game. After this, the User is viewed as ready to play (and still active).
 * If the user wants to Disconnect from the server altogether, he has to send a EndSessionAction afterwards.
 */
public class EndGameAction implements Serializable {
    private final Player self;

    public EndGameAction(Player self) {
        this.self = self;
    }

    public Player getSelf() {
        return self;
    }
}
