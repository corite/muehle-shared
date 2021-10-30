package frontend;

import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel {

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawLine(40,40,this.getWidth()-40,40);
        g.drawLine(40,40,40,this.getWidth()-40);
        g.drawLine(40,this.getWidth()-40,this.getWidth()-40,this.getWidth()-40);
        g.drawLine(this.getWidth()-40,40,this.getWidth()-40,this.getWidth()-40);
        g.drawLine(80,80,this.getWidth()-80,80);
        g.drawLine(80,80,80,this.getWidth()-80);
        g.drawLine(80,this.getWidth()-80,this.getWidth()-80,this.getWidth()-80);
        g.drawLine(this.getWidth()-80,80,this.getWidth()-80,this.getWidth()-80);
        g.drawLine(120,120,this.getWidth()-120,120);
        g.drawLine(120,120,120,this.getWidth()-120);
        g.drawLine(120,this.getWidth()-120,this.getWidth()-120,this.getWidth()-120);
        g.drawLine(this.getWidth()-120,120,this.getWidth()-120,this.getWidth()-120);
        g.drawLine(40,this.getWidth()/2,120,this.getWidth()/2);
        g.drawLine(this.getWidth()/2,40,this.getWidth()/2,120);
        g.drawLine(this.getWidth()-120,this.getWidth()/2,this.getWidth()-40,this.getWidth()/2);
        g.drawLine(this.getWidth()/2,this.getWidth()-40,this.getWidth()/2,this.getWidth()-120);
    }
}
