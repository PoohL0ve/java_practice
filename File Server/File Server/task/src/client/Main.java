package client;
import java.io.*;
import java.net.*;

public class Main {
    private static String address = "127.0.0.1";
    private static int port = 34781;

    public static void main(String[] args) {
        try (Socket socket = new Socket(InetAddress.getByName(address), port)) {
            System.out.println("Client started!");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String sendMsg = "Give me everything you have!";
            output.writeUTF(sendMsg);
            String received = input.readUTF();

            System.out.println("Sent: " + sendMsg);
            System.out.println("Received: " + received);
        } catch (IOException e) {
            System.out.println("Connection cannot be made");
        }
    }
}
