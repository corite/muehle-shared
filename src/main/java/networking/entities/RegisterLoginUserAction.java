package networking.entities;

import java.io.Serializable;

public class RegisterLoginUserAction implements Serializable {
    private final String userName;
    private final String password;
    private final boolean isRegisterAction;

    public RegisterLoginUserAction(String userName, String password, boolean isRegisterAction) {
        this.userName = userName;
        this.password = password;
        this.isRegisterAction = isRegisterAction;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isRegisterAction() {
        return isRegisterAction;
    }
}
