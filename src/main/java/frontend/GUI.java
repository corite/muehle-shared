package frontend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class GUI{
    public GUI(){
        Draw draw = new Draw();
        JFrame frame = new JFrame("Muehle");
        //Windowerstellung und Settings
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        draw.setBounds(0,0,500,500);
        draw.setVisible(true);
        frame.add(draw);
        //Die Components müssen zu Beginn erneut gezeichnet werden, da ansonsten nur die Hälfte angezeigt wird? Seid der
        //Änderung des resize events
        //Abfangen des Window Resize Events

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                //Wenn das JFrame größer in der Breite wird, wird das JLabel der Breite nach zentriert
                if (frame.getWidth()>frame.getHeight()){
                    draw.setBounds(frame.getWidth()/2-frame.getHeight()/2,0,frame.getHeight(),frame.getHeight());
                }
                //Andersherum, wenn das JFrame größer in der Höhe wird
                else{
                    draw.setBounds(0,frame.getHeight()/2-frame.getWidth()/2,frame.getWidth(),frame.getWidth());
                }
            }
        });
    }
}

