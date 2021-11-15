package frontend;

import backend.entities.Coordinate;
import backend.entities.StoneState;

import javax.swing.*;

public class Button extends JButton {
    private Coordinate coordinate;
<<<<<<< HEAD
=======
    private StoneState state = StoneState.NONE;
>>>>>>> 87b657703dc6f089c04816708060f6f575d950e5

    public Button(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

<<<<<<< HEAD
=======
    public StoneState getState() {
        return state;
    }

    public void setState(StoneState state) {
        this.state = state;
    }

>>>>>>> 87b657703dc6f089c04816708060f6f575d950e5
    public void setCoordinates(int x, int y){
        this.coordinate = new Coordinate(x, y);
    }
}
