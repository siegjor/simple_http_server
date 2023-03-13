import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        try {
            final ServerSocket server = new ServerSocket(8080);
            System.out.println("Listening for connection on port 8080 ...");

            while (true) {
                final Socket serverClient = server.accept();
                final InputStreamReader isr = new InputStreamReader(serverClient.getInputStream());
                final BufferedReader reader = new BufferedReader(isr);

                String line = reader.readLine();
                while (!line.isEmpty()) {
                    System.out.println(line);
                    line = reader.readLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}