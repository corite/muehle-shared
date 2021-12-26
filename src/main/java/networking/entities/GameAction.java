package networking.entities;

import logic.entities.Coordinate;
import logic.entities.Player;

import java.io.Serializable;

/**
 * represents any game-action performed by a player
 */
public class GameAction implements Serializable {
    private final Player player;
    private final ActionType type;
    private final Coordinate from;
    private final Coordinate to;


    public GameAction(Player player, ActionType type, Coordinate from, Coordinate to) {
        this.player = player;
        this.type = type;
        this.from = from;
        this.to = to;
    }
    public GameAction(Player player, ActionType type, Coordinate coordinate) {
        this(player,type,null,coordinate);
    }

    public Player getPlayer() {
        return player;
    }

    public ActionType getType() {
        return type;
    }

    public Coordinate getFrom() {
        return from;
    }

    public Coordinate getTo() {
        return to;
    }

    public Coordinate getPlaceOrTakeCoordinate() {
        if (!getType().equals(ActionType.MOVE)) {
            return to;
        } else {
            throw new IllegalArgumentException("type was move, expected take or place");
        }


    }
}
