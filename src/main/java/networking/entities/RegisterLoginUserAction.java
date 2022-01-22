package networking.entities;

import java.io.Serializable;

public class RegisterLoginUserAction implements Serializable {
    private final String name;
    private final String password;
    private final boolean isRegisterAction;

    public RegisterLoginUserAction(String name, String password, boolean isRegisterAction) {
        this.name = name;
        this.password = password;
        this.isRegisterAction = isRegisterAction;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean isRegisterAction() {
        return isRegisterAction;
    }
}
