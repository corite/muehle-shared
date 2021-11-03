package backend.entities;

public class Position {

    private Coordinate coordinate;
    private StoneState stoneState;//white, black or not set as defined in the enum


    public Position(int x, int y) {
        this(new Coordinate(x,y));
    }
    public Position(Coordinate coordinate) {
    this(coordinate, StoneState.NONE);
    }

    public Position(Coordinate coordinate, StoneState stoneState) {
        this.coordinate = coordinate;
        this.stoneState = stoneState;
    }

    public StoneState getStoneState() {
        return stoneState;
    }

    public void setStoneState(StoneState stoneState) {
        this.stoneState = stoneState;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

}
