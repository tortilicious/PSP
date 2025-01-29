package modelo;

import java.io.Serializable;

public class Libro implements Serializable {
    private final String isbn;
    private final String titulo;
    private final String autor;
    private final String genero;
    private boolean disponible;

    public Libro(String isbn, String titulo, String autor, String genero, boolean disponible) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.disponible = disponible;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return String.format("""
                Titulo: %s
                    Autor: %s
                    Genero: %s
                    ISBN: %s
                    Disponible: %s
                    
                """, autor, titulo, genero, isbn, disponible);
    }
}
