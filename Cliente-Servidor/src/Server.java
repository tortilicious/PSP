import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        int port = 5000;

        try(ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Waiting for connection...");

            while (true) {
                Socket socketCliente = serverSocket.accept();
                System.out.println("Connection accepted from " + socketCliente.getInetAddress());

                ManejadorCliente manejador = new ManejadorCliente(socketCliente);
                Thread thread = new Thread(manejador);
                thread.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
