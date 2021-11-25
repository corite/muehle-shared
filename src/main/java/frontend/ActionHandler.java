package frontend;

import backend.entities.GamePhase;
import backend.entities.Player;
import backend.entities.StoneState;
import backend.exceptions.GameException;
import backend.exceptions.IllegalMoveException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static Button tmp = null;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() instanceof Button) {
            Button button = (Button) e.getSource();
            Player player = Gui.getGame().getNextPlayerToMove();
            GamePhase phase = player.getPhase();
            Draw draw = Gui.getDraw();

            if (Gui.getGame().isNextOperationTake()) {

                //try to perform take operation if the next operation is take and repaint JLabel properly

                try {
                    Gui.getGame().takeStone(player, button.getCoordinate());
                    draw.repaint();
                    logger.debug("took Stone from coordinate " + button.getCoordinate());
                } catch (IllegalMoveException ex) {
                    logger.warn("Illegal Take", ex);
                }
            } else {
                try {

                    //try to perform different phase moves and repaint JLabel

                    switch (phase) {

                        case PLACE -> {
                            Gui.getGame().placeStone(player, button.getCoordinate());
                            logger.debug("set stone at coordinate " + button.getCoordinate());
                        }

                        case MOVE, FLY -> {
                            if (tmp == null || !Gui.getGame().getPositionAtCoordinate(button.getCoordinate()).getStoneState().equals(StoneState.NONE)) {
                                tmp = button;
                                logger.debug("set tmp stone at coordinate " + button.getCoordinate());
                            } else {
                                Gui.getGame().moveStone(player, tmp.getCoordinate(), button.getCoordinate());
                                logger.debug("moved stone from coordinate " + tmp.getCoordinate() + " to coordinate " + button.getCoordinate());
                                tmp = null;
                            }
                        }
                    }
                    draw.repaint();
                } catch (GameException ex) {
                    logger.warn("Illegal Move", ex);
                }
            }
        }
    }

    public static Button getTmp() {
        return tmp;
    }
}
