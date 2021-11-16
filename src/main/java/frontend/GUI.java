package frontend;

import backend.entities.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Gui {

    private static Draw draw;
    private final JFrame frame;
    private static final Button[]btn = new Button[24];
    private static Game game;

    public Gui(){

        //creating window and window settings
        frame = new JFrame("Muehle");
        frame.setBounds(0,0,1000, 1000);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //creating JLabel from draw class and draw settings
        draw = new Draw();
        draw.setBounds(0,0,1000,1000);
        draw.setVisible(true);
        frame.add(draw);

        String name1 = JOptionPane.showInputDialog(frame,"Enter username for Player 1!");
        String name2 = JOptionPane.showInputDialog(frame,"Enter username for Player 2!");
        Player player1 = new Player(name1, StoneState.WHITE);
        Player player2 = new Player(name2, StoneState.BLACK);
        game = new Game(player1, player2);

        //create buttons
        ArrayList<Coordinate> coordinates = game.getField().nodes().stream().map(Position:: getCoordinate).collect(Collectors.toCollection(ArrayList::new));
        coordinates.sort(((o1, o2) -> o1.getY() == o2.getY() ? Integer.compare(o1.getX(), o2.getX()) : -Integer.compare(o1.getY(),o2.getY())));
        System.out.println(coordinates);
        for (int i=0; i< btn.length; i++){
            System.out.println(coordinates.get(i));
            btn[i] = new Button(coordinates.get(i));
            btn[i].setVisible(true);
            btn[i].addActionListener(new ActionHandler());
            btn[i].setFocusPainted(false);
            btn[i].setContentAreaFilled(false);
            btn[i].setBorder(null);
            frame.add(btn[i]);
        }
        this.placeBtn(0,0);

        //catch window resize event
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                //keep JLabel squared
                if (frame.getWidth()>frame.getHeight()){
                    draw.setBounds(frame.getWidth()/2-frame.getHeight()/2,0,frame.getHeight(),frame.getHeight());
                    placeBtn((frame.getWidth()-draw.getWidth())/2,0);
                }
                else{
                    draw.setBounds(0,frame.getHeight()/2-frame.getWidth()/2,frame.getWidth(),frame.getWidth());
                    placeBtn(0,(frame.getHeight()-draw.getWidth())/2);
                }
                Gui.getDraw().repaint();
            }
        });
    }

    public static Game getGame() {
        return game;
    }

    public static Button getBtn(int i){
        return btn[i];
    }

    public static Draw getDraw() {
        return draw;
    }

    //Button placement

    private void placeBtn(int width, int height) {
        btn[0].setBounds(width+2*draw.getWidth()/20-20, height+2*draw.getHeight()/20-20, 40, 40);
        btn[1].setBounds(width+10*draw.getWidth()/20-20, height+2*draw.getHeight()/20-20, 40, 40);
        btn[2].setBounds(width+18*draw.getWidth()/20-20, height+2*draw.getHeight()/20-20, 40, 40);
        btn[3].setBounds(width+5*draw.getWidth()/20-20, height+5*draw.getHeight()/20-20, 40, 40);
        btn[4].setBounds(width+10*draw.getWidth()/20-20, height+5*draw.getHeight()/20-20, 40, 40);
        btn[5].setBounds(width+15*draw.getWidth()/20-20, height+5*draw.getHeight()/20-20, 40, 40);
        btn[6].setBounds(width+8*draw.getWidth()/20-20, height+8*draw.getHeight()/20-20, 40, 40);
        btn[7].setBounds(width+10*draw.getWidth()/20-20, height+8*draw.getHeight()/20-20, 40, 40);
        btn[8].setBounds(width+12*draw.getWidth()/20-20, height+8*draw.getHeight()/20-20, 40, 40);
        btn[9].setBounds(width+2*draw.getWidth()/20-20, height+draw.getHeight()/2-20, 40, 40);
        btn[10].setBounds(width+5*draw.getWidth()/20-20, height+draw.getHeight()/2-20, 40, 40);
        btn[11].setBounds(width+8*draw.getWidth()/20-20, height+draw.getHeight()/2-20, 40, 40);
        btn[12].setBounds(width+12*draw.getWidth()/20-20, height+draw.getHeight()/2-20, 40, 40);
        btn[13].setBounds(width+15*draw.getWidth()/20-20, height+draw.getHeight()/2-20, 40, 40);
        btn[14].setBounds(width+18*draw.getWidth()/20-20, height+draw.getHeight()/2-20, 40, 40);
        btn[15].setBounds(width+8*draw.getWidth()/20-20, height+12*draw.getHeight()/20-20, 40, 40);
        btn[16].setBounds(width+10*draw.getWidth()/20-20, height+12*draw.getHeight()/20-20, 40, 40);
        btn[17].setBounds(width+12*draw.getWidth()/20-20, height+12*draw.getHeight()/20-20, 40, 40);
        btn[18].setBounds(width+5*draw.getWidth()/20-20, height+15*draw.getHeight()/20-20, 40, 40);
        btn[19].setBounds(width+10*draw.getWidth()/20-20, height+15*draw.getHeight()/20-20, 40, 40);
        btn[20].setBounds(width+15*draw.getWidth()/20-20, height+15*draw.getHeight()/20-20, 40, 40);
        btn[21].setBounds(width+2*draw.getWidth()/20-20, height+18*draw.getHeight()/20-20, 40, 40);
        btn[22].setBounds(width+10*draw.getWidth()/20-20, height+18*draw.getHeight()/20-20, 40, 40);
        btn[23].setBounds(width+18*draw.getWidth()/20-20, height+18*draw.getHeight()/20-20, 40, 40);
    }
}