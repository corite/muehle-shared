package frontend;

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
        draw.paintComponent(draw.getGraphics());
        //Abfangen des Window Resize Events
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            /* Lass ich mal noch so stehen, falls wir uns doch nochmal umentscheiden sollten
            //Gleichsetzen der Werte von Höhe und Breite des Fensters um es quadratisch zu halten. Aufspaltung in
            // 2 Fälle, da sont Höhe/Breite falsch Übertragen wird
            if (frame.getHeight() < frame.getWidth()) {
                frame.setSize(frame.getHeight(), frame.getHeight());
            }
            else{
                frame.setSize(frame.getWidth(), frame.getWidth());
            }
            //Das Gleiche für das JLabel
            draw.setBounds(0,0,frame.getWidth(), frame.getHeight());
            */
                //Wenn das JFrame größer in der Breite wird, wird das JLabel der Breite nach zentriert
                if (frame.getWidth()>frame.getHeight()){
                    draw.setBounds(frame.getWidth()/2-frame.getHeight()/2,0,frame.getHeight(),frame.getHeight());
                    draw.paintComponent(draw.getGraphics());
                }
                //Andersherum, wenn das JFrame größer in der Höhe wird
                else{
                    draw.setBounds(0,frame.getHeight()/2-frame.getWidth()/2,frame.getWidth(),frame.getWidth());
                    draw.paintComponent(draw.getGraphics());
                }
            }
        });
    }
}

