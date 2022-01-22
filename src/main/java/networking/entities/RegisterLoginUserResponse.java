package networking.entities;

import logic.entities.User;

import java.io.Serializable;

public class RegisterLoginUserResponse implements Serializable {
    private final User user;
    private final boolean wasSuccessful;
    private final String message;


    public RegisterLoginUserResponse(User user, boolean wasSuccessful, String message) {
        this.user = user;
        this.wasSuccessful = wasSuccessful;
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public boolean wasSuccessful() {
        return wasSuccessful;
    }

    public String getMessage() {
        return message;
    }
}
