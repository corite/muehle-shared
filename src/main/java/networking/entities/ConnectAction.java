package networking.entities;

import logic.entities.Player;

import java.io.Serializable;

public class ConnectAction implements Serializable {
    private final Player self;
    private final Player other;

    public ConnectAction(Player self, Player other) {
        this.self = self;
        this.other = other;
    }

    public Player getSelf() {
        return self;
    }

    public Player getOther() {
        return other;
    }
}
