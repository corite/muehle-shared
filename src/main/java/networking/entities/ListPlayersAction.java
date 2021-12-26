package networking.entities;

import logic.entities.Player;

import java.io.Serializable;

/**
 * requests a List of all currently available players.
 */
public class ListPlayersAction implements Serializable {
    private final Player self;

    public ListPlayersAction(Player self) {
        this.self = self;
    }

    public Player getSelf() {
        return self;
    }
}
