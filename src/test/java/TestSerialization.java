import logic.entities.*;
import networking.entities.*;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSerialization {



    @Test
    public void testSerializationAndDeserialization() throws IOException, ClassNotFoundException{
        User selfUser = new User("a", new ByteArrayOutputStream());
        User otherUser = new User("b", new ByteArrayOutputStream());
        Player self = new Player(selfUser, StoneState.BLACK);
        Player other = new Player(otherUser, StoneState.WHITE);

        testSerializationAndDeserialization(new RegisterLoginUserAction("a","secure", true));
        testSerializationAndDeserialization(new RegisterLoginUserResponse(selfUser,true, "yay"));

        testSerializationAndDeserialization(new ListUsersAction(selfUser));
        testSerializationAndDeserialization(new ListUsersResponse(new ArrayList<>(List.of(selfUser))));

        testSerializationAndDeserialization(new GameAction(self,ActionType.PLACE,new Coordinate(0,0)));
        testSerializationAndDeserialization(new GameResponse("hello", ActionType.PLACE,self, other, new ArrayList<>(List.of(new Position(0,0)))));

        testSerializationAndDeserialization(new EndGameAction(self));
        testSerializationAndDeserialization(new EndGameResponse("oh no"));

        testSerializationAndDeserialization(new ConnectAction(selfUser,otherUser));
        testSerializationAndDeserialization(new ReconnectAction(self));
        testSerializationAndDeserialization(new DisconnectResponse(self));
        testSerializationAndDeserialization(new EndSessionAction(selfUser));


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
