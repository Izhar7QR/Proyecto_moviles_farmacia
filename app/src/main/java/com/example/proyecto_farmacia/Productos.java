package com.example.proyecto_farmacia;

public class Productos {

    String Nombre, Descripcion, Precio;

    public Productos(){}

    public Productos(String nombre, String descripcion, String precio) {
        this.Nombre = nombre;
        this.Descripcion = descripcion;
        this.Precio = precio;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }
}
