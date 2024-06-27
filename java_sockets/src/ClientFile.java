import java.util.*;
import java.io.*;
import java.net.*;

public class ClientFile {
    private final static String ADDRESS = "127.0.0.1";
    private final static int PORT = 4531;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(ADDRESS, PORT);
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());


            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();

            output.writeUTF(message); // send message to the server
            String response = input.readUTF();

            System.out.println("Server Response: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
