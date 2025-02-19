package red;

import service.ConstelacionRMI;
import service.ConstelacionRemoto;
import service.PlanetaRMI;
import service.PlanetaRemoto;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            //  Creamos la instancia de la implementación
            ConstelacionRMI constelacionService = new ConstelacionRemoto();
            PlanetaRMI planetaService = new PlanetaRemoto();

            //  Creamos el registro en el puerto 4000
            Registry registry = LocateRegistry.createRegistry(4000);

            //  Registramos el servicio asignándole un nombre
            registry.rebind("ConstelacionService", constelacionService);
            registry.rebind("PlanetaService", planetaService);

            System.out.println("Servidor RMI listo.");
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

    }
}
