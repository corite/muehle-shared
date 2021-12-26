package networking.entities;

import logic.entities.Player;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * lists all available players.
 */
public class ListPlayersResponse implements Serializable {
    private final ArrayList<Player> players;

    public ListPlayersResponse(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
