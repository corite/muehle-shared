package backend.entities;

public class Player {
    private final String name;
    private final StoneState color;
    private GamePhase phase;
    private int placedStones=0;

    public Player(String name, StoneState color) {
        this.name = name;
        this.phase = GamePhase.PLACE;//initially always place

        if (StoneState.NONE.equals(color) || color == null) {
            throw new IllegalArgumentException("Player color must be white or black");
        }
        this.color=color;
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

    public void addPLacedStone() {
        this.placedStones++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (!getName().equals(player.getName())) return false;
        if (getColor() != player.getColor()) return false;
        return getPhase() == player.getPhase();
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getColor().hashCode();
        result = 31 * result + getPhase().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", phase=" + phase +
                ", placedStones=" + placedStones +
                '}';
    }
}
