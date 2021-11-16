package frontend;

import backend.entities.StoneState;

import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel {

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.BLACK);

        //outer rectangle

        g.drawRect(2*this.getWidth()/20,2*this.getHeight()/20, 16*this.getWidth()/20,16*this.getHeight()/20);

        //middle rectangle

        g.drawRect(5*this.getWidth()/20,5*this.getHeight()/20,10*this.getWidth()/20,10*this.getHeight()/20);

        //inner rectangle

        g.drawRect(8*this.getWidth()/20, 8*this.getHeight()/20, 4*this.getWidth()/20, 4*this.getHeight()/20);

        //lines in between

        g.drawLine(this.getWidth()/2,2*this.getHeight()/20,this.getWidth()/2,8*this.getHeight()/20);
        g.drawLine(this.getWidth()/2,12*this.getHeight()/20,this.getWidth()/2,18*this.getHeight()/20);
        g.drawLine(2*this.getWidth()/20,this.getHeight()/2,8*this.getWidth()/20,this.getHeight()/2);
        g.drawLine(12*this.getWidth()/20,this.getHeight()/2,18*this.getWidth()/20,this.getHeight()/2);

        //filled rectangles on the outer rectangle top and bottom line

        for (int i=2; i<=18;i+=+8){
            for (int j=2; j<=18;j+=16){
                g.fillRect(i*this.getWidth()/20-5,j*this.getHeight()/20-5,10,10);
            }
        }

        //filled rectangles on the middle rectangle top and bottom line

        for (int i=5; i<=15;i+=+5){
            for (int j=5; j<=15;j+=10){
                g.fillRect(i*this.getWidth()/20-5,j*this.getHeight()/20-5,10,10);
            }
        }

        //filled rectangles on the inner rectangle top and bottom line

        for (int i=8; i<=12;i+=+2){
            for (int j=8; j<=12;j+=4){
                g.fillRect(i*this.getWidth()/20-5,j*this.getHeight()/20-5,10,10);
            }
        }

        //filled rectangles on the middle line, left side

        for (int i=2; i<=8;i+=+3){
            g.fillRect(i*this.getWidth()/20-5,this.getHeight()/2-5,10,10);
        }

        //filled rectangles on the middle line, right side

        for (int i=12; i<=18;i+=+3){
            g.fillRect(i*this.getWidth()/20-5,this.getHeight()/2-5,10,10);
        }

        for (int i=0; i<=23;i++){
            if (Gui.getBtn(i) != null) {
                if (Gui.getGame().getPositionAtCoordinate(Gui.getBtn(i).getCoordinate()).getStoneState().equals(StoneState.BLACK)) {
                    g.setColor(Color.BLACK);
                    g.fillOval(Gui.getBtn(i).getX(), Gui.getBtn(i).getY(), 40, 40);
                    g.setColor(Color.WHITE);
                    g.drawOval(Gui.getBtn(i).getX()+5, Gui.getBtn(i).getY()+5, 30, 30);
                    g.drawOval(Gui.getBtn(i).getX()+10, Gui.getBtn(i).getY()+10, 20, 20);
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
                }
            }
        }
        repaint();
    }
}
