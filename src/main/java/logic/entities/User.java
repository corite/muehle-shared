package logic.entities;

import java.io.OutputStream;
import java.io.Serializable;

public class User implements Serializable {
    private final String name;
    private transient OutputStream outputStream;

    public User(String name, OutputStream outputStream) {
        this.name = name;
        this.outputStream = outputStream;
        if (name ==null || outputStream == null) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return getName() != null ? getName().equals(user.getName()) : user.getName() == null;
    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }

    @Override
    public String toString() {
        return getName();
    }
}
