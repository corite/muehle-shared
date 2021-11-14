package frontend;

import backend.entities.Coordinate;
import backend.entities.StoneState;
import backend.exceptions.IllegalMoveException;
import backend.exceptions.IllegalPlayerException;
import backend.exceptions.InvalidPhaseException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
    Button tmp = null;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Button){
            try{
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
            }
        }
    }
}
