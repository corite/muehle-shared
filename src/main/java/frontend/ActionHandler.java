package frontend;

import backend.entities.Coordinate;
import backend.entities.StoneState;
import backend.exceptions.IllegalMoveException;
import backend.exceptions.IllegalPlayerException;
import backend.exceptions.InvalidPhaseException;
<<<<<<< HEAD
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
=======
>>>>>>> 87b657703dc6f089c04816708060f6f575d950e5

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
<<<<<<< HEAD
    Logger logger = LoggerFactory.getLogger(getClass());
    static Button tmp = null;
=======
    Button tmp = null;
>>>>>>> 87b657703dc6f089c04816708060f6f575d950e5
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Button){
            try{
<<<<<<< HEAD
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
=======
                System.out.println(Gui.getGame().getNextOperationTake());
                Gui.getGame().placeStone(Gui.getGame().getNextPlayerToMove(), ((Button) e.getSource()).getCoordinate());
                System.out.println(Gui.getGame().getNextOperationTake());
                if (Gui.getGame().getNextPlayerToMove().getColor() == StoneState.WHITE){
                    ((Button) e.getSource()).setState(StoneState.WHITE);
                    Gui.getDraw().repaint();
                }else if(Gui.getGame().getNextPlayerToMove().getColor() == StoneState.BLACK){
                    ((Button) e.getSource()).setState(StoneState.BLACK);
                    Gui.getDraw().repaint();
                }
                System.out.println("Stein gesetzt");
            } catch (InvalidPhaseException invalidPhaseException){
                System.out.println("Ungültige Zugphase!");
            } catch (IllegalMoveException illegalMoveException){
                System.out.println("Ungültiger Zug");
            }
            try{
                if (tmp == null){
                    tmp = ((Button) e.getSource());
                } else{
                    Gui.getGame().moveStone(Gui.getGame().getNextPlayerToMove(), tmp.getCoordinate(), ((Button) e.getSource()).getCoordinate());
                    System.out.println(Gui.getGame().getNextOperationTake());
                    if (Gui.getGame().getNextPlayerToMove().getColor() == StoneState.WHITE){
                        tmp.setState(StoneState.NONE);
                        ((Button) e.getSource()).setState(StoneState.WHITE);
                        Gui.getDraw().repaint();
                    }else if(Gui.getGame().getNextPlayerToMove().getColor() == StoneState.BLACK){
                        tmp.setState(StoneState.NONE);
                        ((Button) e.getSource()).setState(StoneState.BLACK);
                        Gui.getDraw().repaint();
                    }
                    System.out.println("Stein gezogen");
                }
            } catch (InvalidPhaseException invalidPhaseException){
                System.out.println("Ungültige Zugphase!");
            } catch (IllegalMoveException illegalMoveException){
                System.out.println("Ungültiger Zug");
            } catch (IllegalPlayerException illegalPlayerException){
                System.out.println("Nicht dein Stein");
>>>>>>> 87b657703dc6f089c04816708060f6f575d950e5
            }
        }
    }
}
