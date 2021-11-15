package frontend;

import backend.entities.Coordinate;
import backend.entities.StoneState;
import backend.exceptions.IllegalMoveException;
import backend.exceptions.IllegalPlayerException;
import backend.exceptions.InvalidPhaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
    Logger logger = LoggerFactory.getLogger(getClass());
    static Button tmp = null;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Button){
            try{
                Gui.getGame().takeStone(Gui.getGame().getNextPlayerToMove(), ((Button) e.getSource()).getCoordinate());
                logger.debug("Stein genommen");
            } catch (IllegalMoveException illegalTakeException){
                try{
                    if (!Gui.getGame().isNextOperationTake()) {
                        Gui.getGame().placeStone(Gui.getGame().getNextPlayerToMove(), ((Button) e.getSource()).getCoordinate());
                        logger.debug("Stein gesetzt");
                    }
                } catch (InvalidPhaseException invalidPlacePhaseException){
                    try{
                        if (tmp == null){
                            if (Gui.getGame().getPositionAtCoordinate(((Button) e.getSource()).getCoordinate()).getStoneState().equals(Gui.getGame().getNextPlayerToMove().getColor())) {
                                tmp = ((Button) e.getSource());
                                logger.debug("tmp gesetzt");
                            }
                        } else{
                            Gui.getGame().moveStone(Gui.getGame().getNextPlayerToMove(), tmp.getCoordinate(), ((Button) e.getSource()).getCoordinate());
                            tmp = null;
                            logger.debug("Stein gezogen");
                        }
                    } catch (InvalidPhaseException invalidMovePhaseException){
                        logger.debug("Ungültige Zugphase!");
                    } catch (IllegalMoveException illegalMoveException){
                        logger.debug("Ungültiger Zug");
                    } catch (IllegalPlayerException illegalPlayerException){
                        logger.debug("Nicht dein Stein");
                    }
                    logger.debug("Ungültige Zugphase!");
                } catch (IllegalMoveException illegalMoveException){
                    logger.debug("Ungültiger Zug");
                }
            }
        }
    }
}
