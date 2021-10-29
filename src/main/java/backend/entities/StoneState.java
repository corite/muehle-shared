package backend.entities;

public enum StoneState {
    NONE(-1),BLACK(0),WHITE(1);
    private final int state;


    StoneState(int state) {
        this.state=state;
    }
    public int getValue() {
        return state;
    }


}
