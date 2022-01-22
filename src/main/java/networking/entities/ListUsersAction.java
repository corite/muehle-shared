package networking.entities;

import logic.entities.User;

import java.io.Serializable;

/**
 * requests a List of all currently available players.
 */
public class ListUsersAction implements Serializable {
    private final User self;

    public ListUsersAction(User self) {
        this.self = self;
    }

    public User getSelf() {
        return self;
    }
}
