package backend.entities;

import backend.exceptions.GameException;
import backend.exceptions.IllegalMoveException;
import backend.exceptions.InvalidPhaseException;
import backend.exceptions.IllegalPlayerException;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.ImmutableGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

import static backend.entities.GamePhase.*;
import static backend.entities.StoneState.NONE;

public class Game {
    private final ImmutableGraph<Position> field;
    private final Player player1;
    private final Player player2;
    private Player nextPlayerToMove;
    private boolean isNextOperationTake;

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

    private void setNextPlayerToMove(Player nextPlayerToMove) {
        this.nextPlayerToMove = nextPlayerToMove;
    }

    public boolean isNextOperationTake() {
        return isNextOperationTake;
    }

    private void setNextOperationTake(boolean nextOperationTake) {
        isNextOperationTake = nextOperationTake;
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

    /**
     * Checks if it is this players turn to make a move.
     * @param player the player to be checked
     */
    private boolean isThisPlayersTurn(Player player) {
        return this.getNextPlayerToMove().equals(player);
    }

    private Position getPositionAtCoordinate(Coordinate coordinate) {
        return getField()
                .nodes()
                .stream()
                .filter(position -> position.getCoordinate().equals(coordinate))
                .findFirst()
                .get();
    }
    private boolean isCoordinateOccupied(Coordinate coordinate) {
        return !NONE.equals(getPositionAtCoordinate(coordinate).getStoneState());
    }


    /**
     * checks whether the player has a stone at position 'from' and whether position 'to' is not occupied
     */
    private boolean isMovePossible(Player player, Coordinate from, Coordinate to) {
        return getPositionAtCoordinate(from).getStoneState().equals(player.getColor()) && getPositionAtCoordinate(to).getStoneState().equals(NONE);
    }
    private boolean areAdjacentNodes(Coordinate from, Coordinate to) {
        return getField().adjacentNodes(getPositionAtCoordinate(from)).contains(getPositionAtCoordinate(to));
    }




    private ArrayList<Position> getPositions(Player player) {
        return getField()
                .nodes()
                .stream()
                .filter(position -> position.getStoneState().equals(player.getColor()))
                .collect(Collectors.toCollection(ArrayList::new));
    }



    private Player getOtherPlayer(Player player) {
        if (getPlayer1().equals(player)) {
            return getPlayer2();
        } else if (getPlayer2().equals(player)) {
            return getPlayer1();
        } else {
            throw new IllegalPlayerException();
        }
    }
    private void updateGamePhases() {
        updateGamePhase(getPlayer1());
        updateGamePhase(getPlayer2());
    }

    private void updateGamePhase(Player player) {
        GamePhase oldPhase = player.getPhase();
        switch (oldPhase) {
            case PLACE -> {
                if (player.getPlacedStones()==9) {
                    player.setPhase(MOVE);
                }
            }
            case MOVE -> {
                if (getPositions(player).size()<=3) {
                    player.setPhase(FLY);
                }
                if (!isAbleToMove(player)) {
                    player.setPhase(LOST);
                    getOtherPlayer(player).setPhase(WON);
                }
            }
            case FLY -> {
                if (getPositions(player).size()==0) {
                    player.setPhase(LOST);
                    getOtherPlayer(player).setPhase(WON);
                }
                if (!isAbleToMove(player)) {
                    player.setPhase(LOST);
                    getOtherPlayer(player).setPhase(WON);
                }
            }
        }
    }

    private boolean areOnTheSameAxis(Position... positions) {
        long distinctXCoordinates = Arrays.stream(positions)
                .map(Position::getCoordinate)
                .map(Coordinate::getX)
                .distinct()
                .count();
        long distinctYCoordinates = Arrays.stream(positions)
                .map(Position::getCoordinate)
                .map(Coordinate::getY)
                .distinct()
                .count();
        return distinctXCoordinates ==1 || distinctYCoordinates == 1;
    }

    private boolean isPartOfMill(Player player, Coordinate coordinate) {
        for (Position neighbour : getField().adjacentNodes(getPositionAtCoordinate(coordinate))) {
            //if one of the adjacent nodes has a neighbour of the same colour that is not the original one and if they are in a straight line , they complete a mill
            if (getField().adjacentNodes(neighbour).stream()
                    .filter(pos -> player.getColor().equals(pos.getStoneState()))//Stones of the same colour
                    .anyMatch(pos -> !pos.equals(neighbour) && areOnTheSameAxis(pos,neighbour,getPositionAtCoordinate(coordinate))))
                //Neighbouring stone that is not the original one and where all stones are in a straight line
            {
                return true;
            }
        }
        return false;
    }

    private boolean isAbleToMove(Player player) {
        ArrayList<Position> playerPositions = getPositions(player);
        for (Position position : playerPositions) {
            if (getField().adjacentNodes(position).stream().anyMatch(pos -> NONE.equals(pos.getStoneState()))) {
                return true;
            }
        }
        return false;
    }

    private void checkValidPlaceInput(Player player, Coordinate coordinate) throws GameException{
        if (!isThisPlayersTurn(player)) {
            throw new IllegalPlayerException();
        } else if (!GamePhase.PLACE.equals(player.getPhase())) {
            throw new InvalidPhaseException();
        }

        if (isCoordinateOccupied(coordinate)) {
            throw new IllegalMoveException();
        }
    }
    private void checkValidMoveInput(Player player, Coordinate from, Coordinate to) throws GameException{
        if (!isThisPlayersTurn(player)) {
            throw new IllegalPlayerException();
        }

        switch (player.getPhase()) {
            case MOVE -> {
                if (!isMovePossible(player,from,to) || !areAdjacentNodes(from,to)) {
                    //Checks the StoneStates of from and to
                    throw new IllegalMoveException();
                }
            }
            case FLY -> {
                if (!isMovePossible(player,from,to)) {
                    throw new IllegalMoveException();
                }
            }
            default -> throw new InvalidPhaseException();
        }
    }

    private void checkValidTakeInput(Player player, Coordinate coordinate) throws GameException{
        if (!isThisPlayersTurn(player)) {
            throw new IllegalPlayerException();
        }
        if (!isNextOperationTake()) {
            throw new IllegalMoveException();
            //todo: maybe throw separate Exception
        }
        if (!getOtherPlayer(player).getColor().equals(getPositionAtCoordinate(coordinate).getStoneState())) {
            //a player can only take stones from another player, not from himself or unoccupied stones
            throw new IllegalMoveException();
        }
        if (isPartOfMill(getOtherPlayer(player),coordinate)) {
            //stone to take can not be in a mill
            throw  new IllegalMoveException();
        }

    }

    /**
     * use this method only in the players 'place' phase in order to place a stone on the field
     * @param player that wants to place the stone
     * @param coordinate where the stone is supposed to be placed
     * @throws GameException if the operation was illegal.
     */
    public void placeStone(Player player, Coordinate coordinate) throws GameException {
        checkValidPlaceInput(player,coordinate);
        getPositionAtCoordinate(coordinate).setStoneState(player.getColor());
        player.addPLacedStone();
        updateGamePhases();

        if (isPartOfMill(player,coordinate)) {
            setNextPlayerToMove(player);
            setNextOperationTake(true);
        } else {
            setNextPlayerToMove(getOtherPlayer(player));
        }
    }

    /**
     * use this method in the move and the fly phase in order to move stones
     * @param player that wants to place the stone
     * @param from the position the player wants to move
     * @param to the position the player wants to move to
     * @throws GameException if the operation was somehow illegal
     */
    public void moveStone(Player player, Coordinate from, Coordinate to) throws GameException {
        checkValidMoveInput(player,from,to);
        getPositionAtCoordinate(from).setStoneState(NONE);
        getPositionAtCoordinate(to).setStoneState(player.getColor());
        updateGamePhases();

        if (isPartOfMill(player,to)) {
            setNextPlayerToMove(player);
            setNextOperationTake(true);
        } else {
            setNextPlayerToMove(getOtherPlayer(player));
        }
    }

    /**
     * use this method after the player has completed a mill and can take a stone from the other player
     * @param player player that wants to take the stone
     * @param stoneToTake the stone he wants to take
     * @throws GameException if the operation was somehow illegal
     */
    public void takeStone(Player player, Coordinate stoneToTake) throws GameException {
        checkValidTakeInput(player,stoneToTake);
        getPositionAtCoordinate(stoneToTake).setStoneState(NONE);
        updateGamePhases();

        setNextOperationTake(false);// will continue as per usual in the next move
        setNextPlayerToMove(getOtherPlayer(player));
    }

    public void printField() {
        for (int i = 3; i >= -3; i--) {
            int finalI = i;
            getField().nodes().stream()
                    .filter(pos -> pos.getCoordinate().getY() == finalI)
                    .sorted(Comparator.comparingInt(pos -> pos.getCoordinate().getX()))
                    .map(Position::getStoneState)
                    .forEach(System.out::print);
            System.out.println();
        }
    }

}