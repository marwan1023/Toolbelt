package seniorproject;

import java.net.ServerSocket;
import java.net.Socket;

public class ProcessingServer {

    // initializes the in variable for output and input data
    public static void main(String[] args) {

        Socket client;
        Connection c;

        int port = 9000;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is Listening...");
            while (true) {
                client = serverSocket.accept();
                c = new Connection(client);
                c.start();
            }
        } catch (java.io.IOException e) {
            System.out.println(e);
            System.exit(1);
        }

    }

}
