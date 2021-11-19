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
        frame.setBounds(0,0,1000, 750);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //creating JLabel from draw class and draw settings
        draw = new Draw();
        draw.setBounds(0,0,1000,750);
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
        for (int i=0; i< btn.length; i++){
            btn[i] = new Button(coordinates.get(i));
            btn[i].setVisible(true);
            btn[i].addActionListener(new ActionHandler());
            btn[i].setFocusPainted(true);
            btn[i].setContentAreaFilled(true);
            btn[i].setBorder(null);
            frame.add(btn[i]);
        }
        this.placeBtn();

        //catch window resize event

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

    private void placeBtn() {
        btn[0].setBounds(50-20, 50-20, 40, 40);
        btn[1].setBounds(350-20, 50-20, 40, 40);
        btn[2].setBounds(650-20, 50-20, 40, 40);
        btn[3].setBounds(150-20, 150-20, 40, 40);
        btn[4].setBounds(350-20, 150-20, 40, 40);
        btn[5].setBounds(550-20, 150-20, 40, 40);
        btn[6].setBounds(250-20, 250-20, 40, 40);
        btn[7].setBounds(350-20, 250-20, 40, 40);
        btn[8].setBounds(450-20, 250-20, 40, 40);
        btn[9].setBounds(50-20, 350-20, 40, 40);
        btn[10].setBounds(150-20, 350-20, 40, 40);
        btn[11].setBounds(250-20, 350-20, 40, 40);
        btn[12].setBounds(450-20, 350-20, 40, 40);
        btn[13].setBounds(550-20, 350-20, 40, 40);
        btn[14].setBounds(650-20, 350-20, 40, 40);
        btn[15].setBounds(250-20, 450-20, 40, 40);
        btn[16].setBounds(350-20, 450-20, 40, 40);
        btn[17].setBounds(450-20, 450-20, 40, 40);
        btn[18].setBounds(150-20, 550-20, 40, 40);
        btn[19].setBounds(350-20, 550-20, 40, 40);
        btn[20].setBounds(550-20, 550-20, 40, 40);
        btn[21].setBounds(50-20, 650-20, 40, 40);
        btn[22].setBounds(350-20, 650-20, 40, 40);
        btn[23].setBounds(650-20, 650-20, 40, 40);
    }
}