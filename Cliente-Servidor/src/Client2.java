import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String host = "localhost";
        int port = 5000;


        try (Socket socket = new Socket(host, port)) {
            // Generamos los flujos de entrada y salida
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            while (true) {
                String mensaje = scanner.nextLine(); // Leer mensaje del usuario
                salida.println(mensaje); // Enviar mensaje al servidor
                String respuesta = entrada.readLine(); // Recibir respuesta del servidor
                System.out.println("Respuesta del servidor: " + respuesta);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
