package servicio;

import modelo.Libro;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface BibliotecaInterfaceRMI extends Remote {
    List<Libro> mostrarLibros() throws RemoteException;
    String alquilarLibro(String titulo) throws RemoteException;
    String devolverLibro(String isbn) throws RemoteException;
    List<Libro> buscarLibrosTitulo(String titulo) throws RemoteException;
    List<Libro> buscarLibrosAutor(String autor) throws RemoteException;
    List<Libro> buscarLibrosGenero(String genero) throws RemoteException;
}
