import backend.entities.Player;
import backend.entities.StoneState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class TestPlayer {
    @Test
    public void testPlayer() {
        try {
            new Player("a", 1, StoneState.NONE);
            fail();
        } catch (IllegalArgumentException e) {}

        new Player("b", 1, StoneState.WHITE);
        new Player("c",1, StoneState.BLACK);
    }
}
