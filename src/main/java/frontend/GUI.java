package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class GUI{

    public static void main(String[] args){

        Draw draw = new Draw();
        JFrame frame = new JFrame("Muehle");
        frame.setSize(500, 500);
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                if (frame.getHeight() < frame.getWidth()) {
                    frame.setSize(frame.getHeight(), frame.getHeight());
                }
                else{
                    frame.setSize(frame.getWidth(), frame.getWidth());
                }
                draw.setSize(frame.getWidth(), frame.getHeight());
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        draw.setBounds(0,0,640,480);
        draw.setVisible(true);
        frame.add(draw);
        draw.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                draw.paintComponent(draw.getGraphics());
            }
        });
    }
}
