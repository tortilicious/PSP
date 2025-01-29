
import model.Producto;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.TreeMap;

public class Servidor {
    private static TreeMap<String, Producto> productos = new TreeMap<>();

    public static void main(String[] args) {

        // Poblamos el treemap
        productos.put("PL",new Producto("Peras limoneras", 14, 5f));
        productos.put("PC",new Producto("Peras conferencia", 12, 7f));
        productos.put("PN",new Producto("Plátano canario", 5, 2.5f));
        productos.put("BN",new Producto("Bananas", 7, 1.3f));
        productos.put("TP",new Producto("Tomates tipo pera", 8, 1.7f));
        productos.put("TR",new Producto("Tomates Raf", 7, 5.3f));
        productos.put("UN",new Producto("Uvas negras", 8, 3.2f));
        productos.put("UB",new Producto("Uvas blancas", 5, 2.7f));
        productos.put("PT",new Producto("Picotas", 8, 4.3f));
        productos.put("CR",new Producto("Ciruelas rojas", 10, 2.8f));
        productos.put("MR",new Producto("Melocotones rojos", 3, 2.5f));
        productos.put("MA",new Producto("Melocotones amarillos", 4, 3.2f));


        System.out.println("APLICACIÓN DE SERVIDOR MULTITAREA");
        System.out.println("----------------------------------");
        try {
            // Abrimos la conexion y ponemos el servidor en espera
            ServerSocket servidor = new ServerSocket();
            InetSocketAddress direccion = new InetSocketAddress("localhost", 2001);  //ojo el puerto
            servidor.bind(direccion);

            System.out.println("Servidor listo para aceptar solicitudes");
            System.out.println("Dirección IP: " + direccion.getAddress());
            while (true) {
                // Conectamos con el cliente
                Socket enchufeAlCliente = servidor.accept();
                System.out.println("Comunicación entrante");

                // Generamos el hilo que se encargara de tratar con el cliente
                new HiloEscuchador(enchufeAlCliente, productos );
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}