import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) {

        try {
            final ServerSocket server = new ServerSocket(8080);
            System.out.println("Listening for connection on port 8080 ...");
            while (true) {}
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}