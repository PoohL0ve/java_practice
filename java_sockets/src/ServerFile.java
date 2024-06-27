import java.io.*;
import java.net.*;


public class ServerFile {
    private static final int PORT = 4531;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                Session session = new Session(server.accept()); // Socket s = server.accept
                session.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Session extends Thread {
    private final Socket socket;

    public Session(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() {
        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            for (int i = 0; i < 5; i++) {
                String message = input.readUTF();
                output.writeUTF(message);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}