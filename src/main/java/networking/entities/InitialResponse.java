package networking.entities;

import logic.entities.Player;

import java.io.Serializable;

/**
 * This object is sent to the client after receiving the InitialAction. It contains the Player-Object used to identify this player for the rest of the session.
 */
public class InitialResponse implements Serializable {
    private final Player self;

    public InitialResponse(Player self) {
        this.self = self;
    }

    public Player getSelf() {
        return self;
    }
}
