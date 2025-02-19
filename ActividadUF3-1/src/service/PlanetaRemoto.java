package service;

import model.Constelacion;
import model.Planeta;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class PlanetaRemoto extends UnicastRemoteObject implements PlanetaRMI {

    private List<Planeta> planetas;

    public PlanetaRemoto() throws RemoteException {

        //  Generamos la lista y la poblamos al crear un objeto PlanetaRemoto
        planetas = new ArrayList<>();
        planetas.add(new Planeta("Mercurio", "El planeta más cercano al Sol y el más pequeño del sistema solar."));
        planetas.add(new Planeta("Venus", "El segundo planeta más cercano al Sol y el más caliente."));
        planetas.add(new Planeta("Tierra", "Nuestro hogar, el tercer planeta desde el Sol y el único conocido con vida."));
        planetas.add(new Planeta("Marte", "El cuarto planeta desde el Sol, conocido como el 'planeta rojo'."));
        planetas.add(new Planeta("Júpiter", "El planeta más grande del sistema solar, un gigante gaseoso."));
        planetas.add(new Planeta("Saturno", "El sexto planeta desde el Sol, famoso por sus anillos."));
        planetas.add(new Planeta("Urano", "El séptimo planeta desde el Sol, un gigante de hielo."));
        planetas.add(new Planeta("Neptuno", "El octavo y más lejano planeta desde el Sol, otro gigante de hielo."));
    }


    @Override
    public String getInfo(String nombrePlaneta) throws RemoteException {

        return planetas.stream()
                .filter(planeta -> planeta.getNombre().equalsIgnoreCase(nombrePlaneta))
                .findFirst()
                .map(Planeta::getDescripcion)
                .orElse("No se ha encontrado esa constelación en la base de datos");
    }

    @Override
    public List<Planeta> getAll() throws RemoteException {
        return planetas;
    }
}
