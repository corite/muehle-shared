package frontend;

import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel {

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.BLACK);

        //Äußerer Rahmen

        g.drawRect(2*this.getWidth()/20,2*this.getHeight()/20, 16*this.getWidth()/20,16*this.getHeight()/20);

        //Mittlerer Rahmen

        g.drawRect(5*this.getWidth()/20,5*this.getHeight()/20,10*this.getWidth()/20,10*this.getHeight()/20);

        //Innerer Rahmen

        g.drawRect(8*this.getWidth()/20, 8*this.getHeight()/20, 4*this.getWidth()/20, 4*this.getHeight()/20);

        //Verbindungslinien

        g.drawLine(this.getWidth()/2,2*this.getHeight()/20,this.getWidth()/2,8*this.getHeight()/20);
        g.drawLine(this.getWidth()/2,12*this.getHeight()/20,this.getWidth()/2,18*this.getHeight()/20);
        g.drawLine(2*this.getWidth()/20,this.getHeight()/2,8*this.getWidth()/20,this.getHeight()/2);
        g.drawLine(12*this.getWidth()/20,this.getHeight()/2,18*this.getWidth()/20,this.getHeight()/2);
    }
}
