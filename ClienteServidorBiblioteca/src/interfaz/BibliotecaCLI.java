package interfaz;

import modelo.Libro;

import java.util.List;
import java.util.Scanner;

public class BibliotecaCLI {
    Scanner sc = new Scanner(System.in);

    public void mostrarMenuGeneral() {
        System.out.println("""
                    Menú Biblioteca
                -----------------------
                1. Listar libros
                2. Buscar libros por Título
                3. Buscar libros por Autor
                4. Buscar libros por Género
                5. Alquilar libro
                6. Devolver libro
                0. Salir
                -----------------------
                """);
    }

    public String pedirTitulo() {
        System.out.println("Por favor introduzca el título del libro: ");
        return sc.nextLine().trim();
    }

    public String pedirAutor() {
        System.out.println("Por favor introduzca el autor: ");
        return sc.nextLine().trim();
    }

    public String pedirGenero() {
        System.out.println("Por favor introduzca el genero del libro: ");
        return sc.nextLine().trim();
    }

    public String pedirISBN() {
        System.out.println("Por favor introduzca el ISBN del libro que quiere devolver: ");
        return sc.nextLine().trim();
    }

    public void mostrarLibros(List<Libro> libros) {
        if (libros.isEmpty()) {
            System.out.println("No se han encontrado libros.");
        } else {
            libros.forEach(System.out::println);
        }
    }


}
