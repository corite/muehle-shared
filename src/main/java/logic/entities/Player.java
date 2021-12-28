package logic.entities;

import java.io.Serializable;

public class Player implements Serializable {
    private final String name;
    private final StoneState color;
    private final int nameId;
    private GamePhase phase;
    private int placedStones=0;

    public Player(String name, int nameId, StoneState color) {
        this.name = name;
        this.nameId = nameId;
        this.phase = GamePhase.PLACE;//initially always place
        this.color = color;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (nameId != player.nameId) return false;
        if (getPlacedStones() != player.getPlacedStones()) return false;
        if (getName() != null ? !getName().equals(player.getName()) : player.getName() != null) return false;
        if (getColor() != player.getColor()) return false;
        return getPhase() == player.getPhase();
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getColor() != null ? getColor().hashCode() : 0);
        result = 31 * result + nameId;
        result = 31 * result + (getPhase() != null ? getPhase().hashCode() : 0);
        result = 31 * result + getPlacedStones();
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
