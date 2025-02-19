package service;

import model.Constelacion;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ConstelacionRMI extends Remote {
    String getInfo(String nombreConstelacion) throws RemoteException;

    List<Constelacion> getAll() throws RemoteException;
}
