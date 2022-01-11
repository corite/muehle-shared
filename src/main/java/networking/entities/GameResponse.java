package networking.entities;

import logic.entities.Player;
import logic.entities.Position;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * the server can send these objects to a client at any time. They should always trigger an update of the clients display with the new information.
 */
public class GameResponse implements Serializable {
    private final String message; //simply a String with information that gets displayed
    private final ActionType nextAction; // the next action that is going to be performed
    private final Player nextPlayerToMove; //player that has to do something next
    private final Player otherPlayer;
    private final ArrayList<Position> gameField; //the current field

    public GameResponse(String message, ActionType nextAction, Player nextPlayerToMove, Player otherPlayer, ArrayList<Position> gameField) {
        this.message = message;
        this.nextAction = nextAction;
        this.nextPlayerToMove = nextPlayerToMove;
        this.otherPlayer = otherPlayer;
        this.gameField = gameField;
    }

    public String getMessage() {
        return message;
    }

    public ActionType getNextAction() {
        return nextAction;
    }

    public Player getNextPlayerToMove() {
        return nextPlayerToMove;
    }

    public Player getOtherPlayer() {
        return otherPlayer;
    }

    public ArrayList<Position> getGameField() {
        return gameField;
    }
}
