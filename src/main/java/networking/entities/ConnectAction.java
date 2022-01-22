package networking.entities;

import logic.entities.User;

import java.io.Serializable;

public class ConnectAction implements Serializable {
    private final User self;
    private final User other;

    public ConnectAction(User self, User other) {
        this.self = self;
        this.other = other;
    }

    public User getSelf() {
        return self;
    }

    public User getOther() {
        return other;
    }
}
