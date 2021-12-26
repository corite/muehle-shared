package networking.entities;

import logic.entities.Position;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * the server can send these objects to a client at any time. They should always trigger an update of the clients display with the new information.
 */
public class GameResponse implements Serializable {
    private final String message; //simply a String with information that gets displayed
    private final boolean isYourTurn; //true if an action is expected from the client
    private final ActionType nextAction; // the next action that is going to be performed
    private final ArrayList<Position> gameField;

    public GameResponse(String message, boolean isYourTurn, ActionType nextAction, ArrayList<Position> gameField) {
        this.message = message;
        this.isYourTurn = isYourTurn;
        this.nextAction = nextAction;
        this.gameField = gameField;
    }

    public String getMessage() {
        return message;
    }

    public boolean isYourTurn() {
        return isYourTurn;
    }

    public ActionType getNextAction() {
        return nextAction;
    }

    public ArrayList<Position> getGameField() {
        return gameField;
    }
}
