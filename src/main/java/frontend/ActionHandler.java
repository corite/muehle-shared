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
    private final Draw draw;

    public ActionHandler(Draw draw) {
        this.draw = draw;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() instanceof Button) {
            Button button = (Button) e.getSource();
            Player player = Gui.getGame().getNextPlayerToMove();
            GamePhase phase = player.getPhase();

            if (Gui.getGame().isNextOperationTake()) {
                try {
                    Gui.getGame().takeStone(player, button.getCoordinate());
                    Gui.getDraw().repaint();
                    logger.debug("Stein genommen");
                } catch (IllegalMoveException ex) {
                    logger.warn("Illegal Take", ex);
                }
            } else {
                try {
                    switch (phase) {

                        case PLACE -> {
                            Gui.getGame().placeStone(player, button.getCoordinate());
                            logger.debug("Stein gesetzt");
                        }

                        case MOVE, FLY -> {
                            if (tmp == null || !Gui.getGame().getPositionAtCoordinate(button.getCoordinate()).getStoneState().equals(StoneState.NONE)) {
                                tmp = button;
                                logger.debug("tmp gesetzt");
                            } else {
                                Gui.getGame().moveStone(player, tmp.getCoordinate(), button.getCoordinate());
                                tmp = null;
                                logger.debug("Stein gezogen");
                            }
                        }
                        case WON, LOST -> {
                            //display something nice
                        }
                    }
                    Gui.getDraw().repaint();
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
