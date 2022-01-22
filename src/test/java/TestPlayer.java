import logic.entities.Player;
import logic.entities.StoneState;
import logic.entities.User;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.fail;

public class TestPlayer {
    @Test
    public void testPlayer() {
        User user  = new User("a",new ByteArrayOutputStream());
        new Player(user, StoneState.WHITE);
        new Player(user, StoneState.BLACK);
        try {
            new Player(user, StoneState.NONE);
            fail();
        } catch (Exception e) {}
    }
}
