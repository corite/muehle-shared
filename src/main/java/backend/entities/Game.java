package backend.entities;

import com.google.common.graph.GraphBuilder;
import com.google.common.graph.ImmutableGraph;

public class Game {
    private final ImmutableGraph<Position> field;
    private final Player player1;
    private final Player player2;
    private Player nextPlayerToMove;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.field = getInitialField();
        this.nextPlayerToMove = getStartPlayer();
    }

    private ImmutableGraph<Position> getField() {
        return field;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getNextPlayerToMove() {
        return nextPlayerToMove;
    }

    public void setNextPlayerToMove(Player nextPlayerToMove) {
        this.nextPlayerToMove = nextPlayerToMove;
    }

    private Player getStartPlayer() {
        if (getPlayer1() == null || getPlayer2() == null) {
            throw new IllegalArgumentException("Player cannot be null");
        } else if (getPlayer1().getColor().equals(getPlayer2().getColor())) {
            throw new IllegalArgumentException("Players have to have different colors");
        } //checking that parameters are valid

        return getPlayer1().getColor().equals(StoneState.WHITE) ? getPlayer1() : getPlayer2(); // white player begins the game
    }

    private ImmutableGraph<Position> getInitialField() {
        Position p1 = new Position(-3,3);
        Position p2 = new Position(0,3);
        Position p3 = new Position(3,3);

        Position p4 = new Position(-2,2);
        Position p5 = new Position(0,2);
        Position p6 = new Position(2,2);

        Position p7 = new Position(-1,1);
        Position p8 = new Position(0,1);
        Position p9 = new Position(1,1);

        Position p10 = new Position(-3,0);
        Position p11 = new Position(-2,0);
        Position p12 = new Position(-1,0);
        Position p13 = new Position(1,0);
        Position p14 = new Position(2,0);
        Position p15 = new Position(3,0);

        Position p16 = new Position(-1,-1);
        Position p17 = new Position(0,-1);
        Position p18 = new Position(1,-1);

        Position p19 = new Position(-2,-2);
        Position p20 = new Position(0,-2);
        Position p21 = new Position(2,-2);

        Position p22 = new Position(-3,-3);
        Position p23 = new Position(0,-3);
        Position p24 = new Position(3,-3);


        return GraphBuilder
                .undirected()
                .<Position>immutable()

                .putEdge(p1,p2)
                .putEdge(p2,p3)
                .putEdge(p1,p10)
                .putEdge(p2,p5)
                .putEdge(p3,p15)

                .putEdge(p4,p5)
                .putEdge(p5,p6)
                .putEdge(p4,p11)
                .putEdge(p5,p8)
                .putEdge(p6,p14)

                .putEdge(p7,p8)
                .putEdge(p8,p9)
                .putEdge(p7,p12)
                .putEdge(p9,p13)


                .putEdge(p10,p11)
                .putEdge(p11,p12)
                .putEdge(p13,p14)
                .putEdge(p14,p15)


                .putEdge(p16,p17)
                .putEdge(p17,p18)
                .putEdge(p16,p12)
                .putEdge(p18,p13)

                .putEdge(p19,p20)
                .putEdge(p20,p21)
                .putEdge(p19,p11)
                .putEdge(p20,p17)
                .putEdge(p21,p14)

                .putEdge(p22,p23)
                .putEdge(p23,p24)
                .putEdge(p22,p10)
                .putEdge(p23,p20)
                .putEdge(p24,p15)
                .build();
    }

}
