package backend.entities;

public enum GamePhase {
    PLACE(0),MOVE(1),FLY(2);
    private final int state;


    GamePhase(int state) {
        this.state=state;
    }
    public int getValue() {
        return state;
    }
}
