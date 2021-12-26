package networking.entities;

import logic.entities.Player;

/**
 * This action is sent by the client if he wants to end the session. It triggers the currently active game to be ended, and the removal of all records of this player on the server.
 */
public class EndSessionAction {
    Player player;
}
