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

        //Punkte für das äußere Rechteck für die obere und untere Linie

        for (int i=5; i<=15;i+=+5){
            for (int j=5; j<=15;j+=10){
                g.fillRect(i*this.getWidth()/20-5,j*this.getHeight()/20-5,10,10);
            }
        }

        //Punkte für das mittlere Rechteck für die obere und untere Linie

        for (int i=2; i<=18;i+=+8){
            for (int j=2; j<=18;j+=16){
                g.fillRect(i*this.getWidth()/20-5,j*this.getHeight()/20-5,10,10);
            }
        }

        //Punkte für das innere Rechteck für die obere und untere Linie

        for (int i=8; i<=12;i+=+2){
            for (int j=8; j<=12;j+=4){
                g.fillRect(i*this.getWidth()/20-5,j*this.getHeight()/20-5,10,10);
            }
        }

        //Punkte für die mittlere Linie, Linke Seite

        for (int i=2; i<=8;i+=+3){
            g.fillRect(i*this.getWidth()/20-5,this.getHeight()/2-5,10,10);
        }

        //Punkte für die mittlere Linie, Rechte Seite

        for (int i=12; i<=18;i+=+3){
            g.fillRect(i*this.getWidth()/20-5,this.getHeight()/2-5,10,10);
        }
    }
}
