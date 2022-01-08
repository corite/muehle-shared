package networking.entities;

import logic.entities.Player;

import java.io.Serializable;

/**
 * This action is sent by the client if he wants to end the session. It triggers the currently active game to be ended, and the removal of all records of this player on the server.
 */
public class EndSessionAction implements Serializable {
    private final Player player;

    public EndSessionAction(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
