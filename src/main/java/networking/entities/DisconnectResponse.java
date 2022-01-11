package networking.entities;

import logic.entities.Player;

import java.io.Serializable;

public class DisconnectResponse implements Serializable {
    private final Player disconnectedPlayer;

    public DisconnectResponse(Player disconnectedPlayer) {
        this.disconnectedPlayer = disconnectedPlayer;
    }

    public Player getDisconnectedPlayer() {
        return disconnectedPlayer;
    }
}
