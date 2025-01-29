import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Cliente {
    public static void main(String[] args) {
        System.out.println(" APLICACIÓN CLIENTE");
        System.out.println("-----------------------------------");
        Scanner lector = new Scanner(System.in);
        try {

            // Establecemos conexion con el servidor
            Socket cliente = new Socket();
            InetSocketAddress direccionServidor = new InetSocketAddress("localhost", 2001);
            System.out.println("Esperando a que el servidor acepte la conexión");
            cliente.connect(direccionServidor);
            System.out.println("Comunicación establecida con el servidor");

            // Generamos los flujos de entrada y salida
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);


            String mensajeCliente = "";
            while (!mensajeCliente.equals("FIN")) {
                System.out.println("Escribe mensaje (FIN para terminar): ");
                mensajeCliente = lector.nextLine().trim().toUpperCase();
                salida.println(mensajeCliente);
                System.out.println("Esperando respuesta ...... ");

                // Recogemos y mostramos la respuesta del servidor
                String respuestaServidor = entrada.readLine();
                System.out.println("Servidor: " + respuestaServidor);
            }

            //  Cerramos los flujos de comunicacion y conexion
            entrada.close();
            salida.close();
            cliente.close();
            System.out.println("Comunicación cerrada");  // Informamos al usuario que se ha terminado la conexion con el servidor
        } catch (UnknownHostException e) {
            System.out.println("No se puede establecer comunicación con el servidor");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S");
            System.out.println(e.getMessage());
        }
    }
}