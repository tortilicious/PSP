import model.Producto;

import java.io.*;
import java.net.Socket;
import java.util.TreeMap;


public class HiloEscuchador implements Runnable {
    private Thread hilo;
    private static int numCliente = 0;
    private Socket enchufeAlCliente;
    private TreeMap <String, Producto> productos;

    public HiloEscuchador(Socket cliente, TreeMap <String, Producto> productos) {
        numCliente++;
        hilo = new Thread(this, "Cliente"+numCliente);
        this.enchufeAlCliente = cliente;
        this.productos = productos;
        hilo.start();
    }


    @Override
    public void run() {
        System.out.println("Estableciendo comunicación con " + hilo.getName());
        try {
            // Gereramos los flujos de entrada y salida de informacion
            BufferedReader entrada = new BufferedReader(new InputStreamReader(enchufeAlCliente.getInputStream()));
            PrintWriter salida = new PrintWriter(enchufeAlCliente.getOutputStream(), true);

            String codigoProducto;
            while ((codigoProducto = entrada.readLine()) != null) {
                System.out.println("Cliente: " + codigoProducto);
                if (codigoProducto.equals("FIN")){
                    System.out.println("Cerrando conexion con " + hilo.getName());
                    salida.println("Conexion terminada");  // avisamos al cliente que hemos cerrado la conexion
                    break;
                }

                // Buscamos el producto solcitado por el cliente
                Producto producto = productos.get(codigoProducto);
                if (producto == null) {
                    salida.println("No se ha encontrado el producto");
                } else {
                    salida.println("Producto encontrado: " + producto);
                }
            }
            // Cerramos los flujos de comunicacion y la conexion.
            salida.close();
            entrada.close();
            enchufeAlCliente.close();
            System.out.println("Conexion terminada"); // Mostramos en la consola del servidor que ya hemos cerrado la conexion
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}