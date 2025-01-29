package servicio;

import modelo.Biblioteca;
import modelo.Libro;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class BibliotecaRemota extends UnicastRemoteObject implements BibliotecaInterfaceRMI {
    private final Biblioteca biblioteca;

    public BibliotecaRemota(Biblioteca biblioteca) throws RemoteException {
        this.biblioteca = biblioteca;
    }

    @Override
    public List<Libro> mostrarLibros() throws RemoteException {
        System.out.println("Cliente ha solicitado listar todos los libros.");
        return biblioteca.getListaLibros();
    }

    @Override
    public String alquilarLibro(String titulo) throws RemoteException {
        System.out.println("Cliente ha solicitado alquilar el libro: " + titulo);

        Libro libroFiltado = biblioteca.getListaLibros().stream()
                .filter(libro -> libro.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);

        if (libroFiltado == null) {
            System.out.println("Libro no encontrado: " + titulo);
            return "El libro no existe en la biblioteca";

        } else if (!libroFiltado.getDisponible()) {
            System.out.println("Libro ya alquilado: " + titulo);
            return "El libro ya ha sido alquilado previamente";

        } else {
            synchronized (libroFiltado) {
                libroFiltado.setDisponible(false);
                System.out.println("Libro alquilado con éxito: " + titulo);
                return "El libro ha sido alquilado con éxito";
            }
        }
    }

    @Override
    public String devolverLibro(String isbn) throws RemoteException {
        System.out.println("Cliente ha solicitado devolver el libro con ISBN: " + isbn);

        Libro libroFiltado = biblioteca.getListaLibros().stream()
                .filter(libro -> libro.getIsbn().equalsIgnoreCase(isbn))
                .findFirst()
                .orElse(null);

        if (libroFiltado == null) {
            System.out.println("Libro no encontrado con ISBN: " + isbn);
            return "El libro no existe en la biblioteca";

        } else if (libroFiltado.getDisponible()) {
            System.out.println("Libro no estaba alquilado: " + isbn);
            return "Ese libro no está alquilado actualmente";

        } else {
            synchronized (libroFiltado) {
                libroFiltado.setDisponible(true);
                System.out.println("Libro devuelto con éxito: " + isbn);
                return "El libro ha sido devuelto con éxito";
            }
        }
    }

    @Override
    public List<Libro> buscarLibrosTitulo(String titulo) throws RemoteException {
        System.out.println("Cliente ha buscado libros por título: " + titulo);

        return biblioteca.getListaLibros().stream()
                .filter(libro -> libro.getTitulo().equalsIgnoreCase(titulo))
                .toList();
    }

    @Override
    public List<Libro> buscarLibrosAutor(String autor) throws RemoteException {
        System.out.println("Cliente ha buscado libros por autor: " + autor);

        return biblioteca.getListaLibros().stream()
                .filter(libro -> libro.getAutor().equalsIgnoreCase(autor))
                .toList();
    }

    @Override
    public List<Libro> buscarLibrosGenero(String genero) throws RemoteException {
        System.out.println("Cliente ha buscado libros por género: " + genero);

        return biblioteca.getListaLibros().stream()
                .filter(libro -> libro.getGenero().equalsIgnoreCase(genero))
                .toList();
    }
}