import frontend.GUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String [] args) {
        System.out.println("Hello World");
        logger.info("Also Hello");
        new GUI();



        //2 threads for backend (later networking) and frontend should be spawned here
    }
}
