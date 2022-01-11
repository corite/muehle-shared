import logic.entities.Coordinate;
import logic.entities.Player;
import logic.entities.Position;
import logic.entities.StoneState;
import networking.entities.*;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSerialization {



    @Test
    public void testSerializationAndDeserialization() throws IOException, ClassNotFoundException{
        Player self = new Player("a", 1, StoneState.BLACK, new ByteArrayOutputStream());
        Player other = new Player("b",1, StoneState.WHITE, null);

        testSerializationAndDeserialization(new InitialAction("a"));
        testSerializationAndDeserialization(new InitialResponse(self));

        testSerializationAndDeserialization(new ListPlayersAction(self));
        testSerializationAndDeserialization(new ListPlayersResponse(new ArrayList<>(List.of(self))));

        testSerializationAndDeserialization(new GameAction(self,ActionType.PLACE,new Coordinate(0,0)));
        testSerializationAndDeserialization(new GameResponse("hello", ActionType.PLACE,self, other, new ArrayList<>(List.of(new Position(0,0)))));

        testSerializationAndDeserialization(new EndSessionAction(self));
        testSerializationAndDeserialization(new ConnectAction(self,other));
        testSerializationAndDeserialization(new ReconnectAction(self));
    }

    
    private void testSerializationAndDeserialization(Object o) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); //using byte array outputStream to test serialization without having to set up a socket etc.
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        oos.writeObject(o);
        oos.flush();

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));


        String writeName = o.getClass().getName();
        String readName = ois.readObject().getClass().getName();
        assertEquals(writeName,readName);
    }


}
