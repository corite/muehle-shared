package backend.entities;

public class Position {
    private final int x;
    private final int y;
    private StoneState stoneState;//white, black or not set as defined in the enum


    public Position(int x, int y) {
    this(x,y, StoneState.NONE);
    }

    public Position(int x, int y, StoneState stoneState) {
        this.x = x;
        this.y = y;
        this.stoneState = stoneState;
    }

    public int getX() {
        return x;
    }

    public StoneState getStoneState() {
        return stoneState;
    }

    public void setStoneState(StoneState stoneState) {
        this.stoneState = stoneState;
    }

    public int getY() {
        return y;
    }
}
