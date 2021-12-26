package logic.entities;

import java.io.Serializable;

public enum StoneState implements Serializable {
    NONE(-1),BLACK(0),WHITE(1);
    private final int state;


    StoneState(int state) {
        this.state=state;
    }
    public int getValue() {
        return state;
    }



    @Override
    public String toString() {
        return "{" + state + '}';
    }
}
