package service;

import model.Constelacion;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ConstelacionRemoto extends UnicastRemoteObject implements ConstelacionRMI {

    //  Simulamos la base de datos donde vamos a consultar las constelaciones
    private List<Constelacion> constelaciones;

    public ConstelacionRemoto() throws RemoteException {
        //  Generamos la lista y la poblamos al crear un objeto ConstelacionRemoto
        constelaciones = new ArrayList<>();
        constelaciones.add(new Constelacion("Osa Mayor", "Se desplaza en círculos alrededor del polo norte."));
        constelaciones.add(new Constelacion("Osa Menor", "Su estrella más conocida es la polar que se encuentra en la prolongación del eje de la tierra."));
        constelaciones.add(new Constelacion("Tauro", "Una de las constelaciones más conocidas desde tiempos remotos."));
        constelaciones.add(new Constelacion("Leo", "De las más brillantes del Zodíaco."));
        constelaciones.add(new Constelacion("Escorpio", "Sus estrellas forman un escorpión."));
        constelaciones.add(new Constelacion("Can Mayor", "Contiene la estrella Sirio, la más brillante en el cielo nocturno."));
        constelaciones.add(new Constelacion("Casiopea", "Tiene forma de M o W. Es conocida desde mucha antigüedad."));
        constelaciones.add(new Constelacion("El Boyero", "Contiene la estrella Arturo, uno de las más luminosas del cielo."));
        constelaciones.add(new Constelacion("Cruz del sur", "Señala al polo sur. Constelación muy pequeña."));
        constelaciones.add(new Constelacion("Acuario", "Una de las más antiguas. Incluye 56 estrellas."));
        constelaciones.add(new Constelacion("Géminis", "Destaca por sus dos gemelos, las estrellas Cástor y Pólux."));
    }


    @Override
    public String getInfo(String nombreConstelacion) throws RemoteException {

        return constelaciones.stream()
                .filter(constelacion -> constelacion.getNombre().equalsIgnoreCase(nombreConstelacion))
                .findFirst()
                .map(Constelacion::getDescripcion)
                .orElse("No se ha encontrado esa constelación en la base de datos");
    }

    @Override
    public List<Constelacion> getAll() throws RemoteException {
        return constelaciones;
    }
}
