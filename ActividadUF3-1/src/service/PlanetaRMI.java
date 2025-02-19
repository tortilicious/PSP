package service;

import model.Planeta;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface PlanetaRMI extends Remote {
    String getInfo(String nombrePlaneta) throws RemoteException;

    List<Planeta> getAll() throws RemoteException;
}
