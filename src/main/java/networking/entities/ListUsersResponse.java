package networking.entities;

import logic.entities.User;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * lists all available users.
 */
public class ListUsersResponse implements Serializable {
    private final ArrayList<User> users;

    public ListUsersResponse(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
