package networking.entities;

import logic.entities.Player;

import java.io.Serializable;

/**
 * is sent by the client if a previously established connection gets interrupted. The server then assigns a new thread and everything continues as per usual.
 */
public class ReconnectAction implements Serializable {
    private final Player player;

    public ReconnectAction(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
