package backend.entities;

public class Player {
    private final String name;
    private final StoneState color;
    private GamePhase phase;

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
}
