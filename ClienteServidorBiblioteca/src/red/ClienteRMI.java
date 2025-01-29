package red;

import interfaz.BibliotecaCLI;
import modelo.Libro;
import servicio.BibliotecaInterfaceRMI;
import servicio.BibliotecaRemota;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class ClienteRMI {
    public static void main(String[] args) {
        BibliotecaCLI cli = new BibliotecaCLI();
        Scanner entrada = new Scanner(System.in);

        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            BibliotecaInterfaceRMI bibliotecaRemota = (BibliotecaInterfaceRMI) registry.lookup("BibliotecaRemota");
            int opcion = -1;
            List<Libro> listaBusquedaLibros;
            String mensaje;

            do {
                cli.mostrarMenuGeneral();
                try {
                    opcion = Integer.parseInt(entrada.nextLine());
                    switch (opcion) {
                        case 1:
                            listaBusquedaLibros = bibliotecaRemota.mostrarLibros();
                            listaBusquedaLibros.forEach(System.out::println);
                            System.out.println();
                            break;

                        case 2:
                            String titulo = cli.pedirTitulo();
                            listaBusquedaLibros = bibliotecaRemota.buscarLibrosTitulo(titulo);
                            cli.mostrarLibros(listaBusquedaLibros);
                            System.out.println();
                            break;

                        case 3:
                            String autor = cli.pedirAutor();
                            listaBusquedaLibros = bibliotecaRemota.buscarLibrosAutor(autor);
                            cli.mostrarLibros(listaBusquedaLibros);
                            System.out.println();
                            break;

                        case 4:
                            String genero = cli.pedirGenero();
                            listaBusquedaLibros = bibliotecaRemota.buscarLibrosGenero(genero);
                            cli.mostrarLibros(listaBusquedaLibros);
                            System.out.println();
                            break;

                        case 5:
                            String tituloAlquiler = cli.pedirTitulo();
                            mensaje = bibliotecaRemota.alquilarLibro(tituloAlquiler);
                            System.out.println(mensaje);
                            System.out.println();
                            break;

                        case 6:
                            String isbn = cli.pedirISBN();
                            mensaje = bibliotecaRemota.devolverLibro(isbn);
                            System.out.println(mensaje);
                            System.out.println();
                            break;

                        case 0:
                            System.out.println("Programa finalizado.");
                        default:
                            System.out.println("Introduzca un valor válido");
                            System.out.println();
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Por favor, introduzca un número");
                    System.out.println();
                }
            } while (opcion != 0);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}