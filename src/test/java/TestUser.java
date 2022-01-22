import logic.entities.User;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.fail;

public class TestUser {


    @Test
    public void testUser() {
        try {
            new User(null, new ByteArrayOutputStream());
            fail();
        } catch (Exception e) {}

        try {
            new User("a", null);
            fail();
        } catch (Exception e) {}
    }
}
