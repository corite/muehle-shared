import logic.entities.*;
import logic.exceptions.IllegalMoveException;
import logic.exceptions.IllegalPlayerException;
import logic.exceptions.InvalidPhaseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static org.junit.jupiter.api.Assertions.*;

public class TestGame {
    Game game;
    User user1;
    User user2;
    Player player1;
    Player player2;
    OutputStream os;


    @BeforeEach
    public void getLegalGame() {
        user1 = new User("a", new ByteArrayOutputStream());
        user2 = new User("b", new ByteArrayOutputStream());
        player1 = new Player(user1, StoneState.BLACK);
        player2 = new Player(user2,StoneState.WHITE);
        game = new Game(player1,player2);
    }

    public Game getIllegalGame1() {
        Player player1 = new Player(user1, StoneState.WHITE);
        Player player2 = new Player(user2, StoneState.WHITE);
        return new Game(player1,player2);
    }

    public Game getIllegalGame2() {
        Player player1 = new Player(user1,StoneState.BLACK);
        Player player2 = new Player(user2,StoneState.BLACK);
        return new Game(player1,player2);
    }


    @Test
    public void testGetStartPlayer() {
        try {
            getIllegalGame1();
            fail();
        } catch (Exception e) {}

        try {
            getIllegalGame2();
            fail();
        } catch (Exception e) {}

    }

    @Test
    public void testGetInitialField() {
        assertEquals(game.getField().nodes().size(),24);
    }

    @Test
    public void testGetNextPlayerToMove() {
        assertEquals(player2, game.getNextPlayerToMove());
        game.placeStone(player2,new Coordinate(-1,0));
        assertEquals(player1, game.getNextPlayerToMove());
    }

    @Test
    public void testPlaceStone() {
        game.placeStone(player2,new Coordinate(-1,0));
        //should go well

        try {
            game.placeStone(player2, new Coordinate(-2,0));
            fail();
            //should fail because the same player tries to move again
        } catch (IllegalPlayerException e) {}

        try {
            game.placeStone(player1, new Coordinate(-1,0));
            fail();
            //should fail because the same stone is placed twice
        } catch (IllegalMoveException e) {}
        game.placeStone(player1, new Coordinate(-2,0));
        //should go well
    }

    @Test
    public void testMoveStone() {
        try {
            game.moveStone(player2, new Coordinate(-1,0), new Coordinate(-2,0));
            fail();
        } catch (InvalidPhaseException e) {}
    }

}
