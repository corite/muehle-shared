package frontend;

import backend.entities.Coordinate;
import backend.entities.StoneState;

import javax.swing.*;

public class Button extends JButton {
    private Coordinate coordinate;
    private StoneState state = StoneState.NONE;

    public Button(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public StoneState getState() {
        return state;
    }

    public void setState(StoneState state) {
        this.state = state;
    }

    public void setCoordinates(int x, int y){
        this.coordinate = new Coordinate(x, y);
    }
}
