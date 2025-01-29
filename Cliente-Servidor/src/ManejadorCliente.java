import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ManejadorCliente implements Runnable {
    private Socket socketCliente;

    public ManejadorCliente(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }

    @Override
    public void run() {
        try (
                // Crear flujos de entrada y salida para comunicarse con el cliente
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
                PrintWriter salida = new PrintWriter(socketCliente.getOutputStream(), true);
        ) {
            String mensajeCliente;
            while ((mensajeCliente = entrada.readLine()) != null) { // Leer mensaje del cliente
                System.out.println("Mensaje recibido del cliente: " + mensajeCliente);

                // Enviar una respuesta al cliente
                salida.println("Servidor: Mensaje recibido - " + mensajeCliente);

                // Si el cliente envía "fin", terminar la comunicación
                if (mensajeCliente.equalsIgnoreCase("fin")) {
                    System.out.println("Cliente solicitó terminar la conexión.");
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Cliente desconectado: " + socketCliente.getInetAddress());
        } finally {
            try {
                socketCliente.close(); // Cerrar el socket del cliente
                System.out.println("Conexión con el cliente cerrada.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}