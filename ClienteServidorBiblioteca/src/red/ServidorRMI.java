package red;

import servicio.BibliotecaRemota;
import modelo.Biblioteca;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            Biblioteca biblioteca = new Biblioteca();
            BibliotecaRemota bibliotecaRemota = new BibliotecaRemota(biblioteca);

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("BibliotecaRemota", bibliotecaRemota);

            System.out.println("Servidor RMI listo y esperando solicitudes...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
