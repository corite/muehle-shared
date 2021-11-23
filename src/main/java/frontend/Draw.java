package frontend;

import backend.entities.GamePhase;
import backend.entities.StoneState;

import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel {

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.BLACK);

        //outer rectangle

        g.drawRect(50,50, 600,600);

        //middle rectangle

        g.drawRect(150,150, 400,400);

        //inner rectangle

        g.drawRect(250, 250, 200, 200);

        //lines in between

        g.drawLine(50,350,250, 350);
        g.drawLine(450,350,650,350);
        g.drawLine(350,50,350,250);
        g.drawLine(350,450,350,650);

        //filled rectangles on the outer rectangle top and bottom line

        for (int i=0; i<=1;i++){
            for (int j=0; j<=2;j++){
                g.fillRect(50 + j*300-5,50 + i*600-5,10,10);
            }
        }

        //filled rectangles on the middle rectangle top and bottom line

        for (int i=0; i<=1;i++){
            for (int j=0; j<=2;j++){
                g.fillRect(150 + j*200-5,150 + i*400-5,10,10);
            }
        }

        //filled rectangles on the inner rectangle top and bottom line

        for (int i=0; i<=1;i++){
            for (int j=0; j<=2;j++){
                g.fillRect(250 + j*100-5,250 + i*200-5,10,10);
            }
        }

        //filled rectangles on the middle line, left side

        for (int i=0; i<=2;i++){
            g.fillRect(50 + i*100-5,350-5,10,10);
        }

        //filled rectangles on the middle line, right side

        for (int i=0; i<=2;i++){
            g.fillRect(450 + i*100-5,350-5,10,10);
        }

        for (int i=0; i<=23;i++){
            if (Gui.getBtn(i) != null) {
                if (Gui.getGame().getPositionAtCoordinate(Gui.getBtn(i).getCoordinate()).getStoneState().equals(StoneState.BLACK)) {
                    g.setColor(Color.BLACK);
                    g.fillOval(Gui.getBtn(i).getX(), Gui.getBtn(i).getY(), 40, 40);
                    g.setColor(Color.WHITE);
                    g.drawOval(Gui.getBtn(i).getX()+5, Gui.getBtn(i).getY()+5, 30, 30);
                    g.drawOval(Gui.getBtn(i).getX()+10, Gui.getBtn(i).getY()+10, 20, 20);
                    g.setColor(Color.BLACK);
                } else if (Gui.getGame().getPositionAtCoordinate(Gui.getBtn(i).getCoordinate()).getStoneState().equals(StoneState.WHITE)) {
                    g.setColor(Color.WHITE);
                    g.fillOval(Gui.getBtn(i).getX(), Gui.getBtn(i).getY(), 40, 40);
                    g.setColor(Color.BLACK);
                    g.drawOval(Gui.getBtn(i).getX()+5, Gui.getBtn(i).getY()+5, 30, 30);
                    g.drawOval(Gui.getBtn(i).getX()+10, Gui.getBtn(i).getY()+10, 20, 20);
                }
                if (ActionHandler.getTmp() != null){
                    g.setColor(Color.RED);
                    g.drawOval(ActionHandler.getTmp().getX(), ActionHandler.getTmp().getY(), 40, 40);
                    g.setColor(Color.BLACK);
                }
            }
        }
        g.setFont(g.getFont().deriveFont(g.getFont().getSize() * 1.4F));
        if (Gui.getGame().getPlayer1().getPhase().equals(GamePhase.WON)) {
            g.drawString(getResizedString(Gui.getGame().getPlayer1().getName()) + " hat gewonnen.", 700, 50);
        }
        else if (Gui.getGame().getPlayer2().getPhase().equals(GamePhase.WON)) {
            g.drawString(getResizedString(Gui.getGame().getPlayer2().getName()) + " hat gewonnen", 700, 50);
        }
        else {
            g.drawString(getResizedString(Gui.getGame().getNextPlayerToMove().getName()) + " ist am Zug.", 700, 50);
        }

        for (int i=0; i<=8-Gui.getGame().getPlayer1().getPlacedStones(); i++){
            g.setColor(Color.WHITE);
            g.fillOval(700, 600-i*50,40,40);
            g.setColor(Color.BLACK);
            g.drawOval(700+5, 600-i*50+5, 30, 30);
            g.drawOval(700+10, 600-i*50+10, 20, 20);
        }

        for (int i=0; i<=8-Gui.getGame().getPlayer2().getPlacedStones(); i++){
            g.setColor(Color.BLACK);
            g.fillOval(750, 600-i*50,40,40);
            g.setColor(Color.WHITE);
            g.drawOval(750+5, 600-i*50+5, 30, 30);
            g.drawOval(750+10, 600-i*50+10, 20, 20);
            g.setColor(Color.BLACK);
        }
    }

    private String getResizedString(String a) {
        if (a != null) {
            if (a.length() > 12) {
                return a.substring(0, 12) + "...";
            }else{
                return a;
            }
        }else {
            return "";
        }
    }
}
