package logic.entities;

import java.io.OutputStream;
import java.io.Serializable;

public class Player implements Serializable {
    private final String name;
    private StoneState color;
    private final int nameId;
    private GamePhase phase;
    private int placedStones=0;
    private OutputStream outputStream;

    public Player(String name, int nameId, StoneState color, OutputStream outputStream) {
        this.name = name;
        this.nameId = nameId;
        this.phase = GamePhase.PLACE;//initially always place
        this.color = color;
        this.outputStream = outputStream;
    }

    public String getName() {
        return name;
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

    public int getNameId() {
        return nameId;
    }

    public String getPlayerId() {
        return getName()+"#"+getNameId();
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void setColor(StoneState color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (getNameId() != player.getNameId()) return false;
        return getName() != null ? getName().equals(player.getName()) : player.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getNameId();
        return result;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", nameId=" + nameId +
                ", phase=" + phase +
                ", placedStones=" + placedStones +
                '}';
    }
}
