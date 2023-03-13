import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Main {
    public static void main(String[] args)throws IOException{
            final ServerSocket server = new ServerSocket(8080);
            System.out.println("Listening for connection on port 8080 ...");

            while (true) {
                try (final Socket socket = server.accept()){
                    send(socket);
                } catch(IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
    }

    private static void read(Socket socket) throws IOException {
        final InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        final BufferedReader reader = new BufferedReader(isr);

        String line = reader.readLine();
        while (!line.isEmpty()) {
            System.out.println(line);
            line = reader.readLine();
        }
    }

    private static void send(Socket socket) throws IOException {
        final Date today = new Date();
        final String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today + "\nHello world! My first Java server is built!";
        socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
    }
}