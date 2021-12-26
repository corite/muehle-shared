package networking.entities;

import java.io.Serializable;

/**
 * This object is used to register a new client.
 */
public class InitialAction implements Serializable {
    private final String name;
    //the name which the PLayer wishes to appear with. A code will be added by the server in order to make it unique amongst all Players

    public InitialAction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
