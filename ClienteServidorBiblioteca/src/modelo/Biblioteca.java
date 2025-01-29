package modelo;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Libro> listaLibros;


    //  Creamos la instancia biblioteca cargada con libros.
    //  Esta clase simulará la BBDD
    public Biblioteca() {
        listaLibros = new ArrayList<>();

        listaLibros.add(new Libro("978-0140449136", "El Quijote", "Miguel de Cervantes", "Novela", true));
        listaLibros.add(new Libro("978-0140449266", "El Quijote", "Miguel de Cervantes", "Novela", false));
        listaLibros.add(new Libro("978-0307743657", "Matar a un ruiseñor", "Harper Lee", "Novela", true));
        listaLibros.add(new Libro("978-0451524935", "1984", "George Orwell", "Ciencia Ficción", true));
        listaLibros.add(new Libro("978-0192838023", "Orgullo y prejuicio", "Jane Austen", "Romance", true));
        listaLibros.add(new Libro("978-0199535569", "Orgullo y prejuicio", "Jane Austen", "Romance", false));
        listaLibros.add(new Libro("978-0679735779", "Cien años de soledad", "Gabriel García Márquez", "Realismo Mágico", true));
        listaLibros.add(new Libro("978-0553213119", "Drácula", "Bram Stoker", "Terror", true));
        listaLibros.add(new Libro("978-0307474278", "El gran Gatsby", "F. Scott Fitzgerald", "Novela", false));
        listaLibros.add(new Libro("978-0142437230", "Moby Dick", "Herman Melville", "Aventura", true));
        listaLibros.add(new Libro("978-0140186390", "El corazón de las tinieblas", "Joseph Conrad", "Aventura", true));
        listaLibros.add(new Libro("978-0199536436", "Emma", "Jane Austen", "Romance", true));
        listaLibros.add(new Libro("978-0140283297", "Cumbres Borrascosas", "Emily Brontë", "Romance", true));
        listaLibros.add(new Libro("978-0199538461", "Cumbres Borrascosas", "Emily Brontë", "Romance", false));
        listaLibros.add(new Libro("978-0140439199", "Los miserables", "Victor Hugo", "Novela", true));

    }

    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }
}


