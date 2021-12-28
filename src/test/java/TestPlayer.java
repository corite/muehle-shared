import logic.entities.Player;
import logic.entities.StoneState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class TestPlayer {
    @Test
    public void testPlayer() {
        new Player("a", 1, StoneState.NONE);
        new Player("b", 1, StoneState.WHITE);
        new Player("c",1, StoneState.BLACK);
    }
}
