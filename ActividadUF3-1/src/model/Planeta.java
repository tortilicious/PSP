package model;

import java.io.Serial;
import java.io.Serializable;

public class Planeta implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String descripcion;

    public Planeta(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return String.format("%s: \n\t%s", nombre, descripcion);
    }
}
