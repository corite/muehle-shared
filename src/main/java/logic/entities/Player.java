package logic.entities;

import logic.exceptions.IllegalPlayerException;

import java.io.OutputStream;
import java.io.Serializable;

public class Player implements Serializable {
    private final User user;
    private final StoneState color;
    private GamePhase phase;
    private int placedStones=0;

    public Player(User user, StoneState color) {
        this.user = user;
        this.phase = GamePhase.PLACE;//initially always place
        this.color = color;

        if (StoneState.NONE.equals(color)) {
            throw new IllegalArgumentException("player can only be white or black");
        }
    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return getUser().getName();
    }

    public StoneState getColor() {
        return color;
    }

    public GamePhase getPhase() {
        return phase;
    }

    public void setPhase(GamePhase phase) {
        this.phase = phase;
    }

    public int getPlacedStones() {
        return placedStones;
    }

    public void addPlacedStone() {
        this.placedStones++;
    }

    public OutputStream getOutputStream() {
        return getUser().getOutputStream();
    }

    public void setOutputStream(OutputStream outputStream) {
        getUser().setOutputStream(outputStream);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return getUser() != null ? getUser().equals(player.getUser()) : player.getUser() == null;
    }

    @Override
    public int hashCode() {
        return getUser() != null ? getUser().hashCode() : 0;
    }

    @Override
    public String toString() {
        return getUser().toString();
    }
}
