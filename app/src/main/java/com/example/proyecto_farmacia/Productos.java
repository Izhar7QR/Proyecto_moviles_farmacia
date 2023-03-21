package com.example.proyecto_farmacia;

public class Productos {

    String Nombre, Descripcion, Precio, Sirve, efectosGraves, efectosSecundarios
            , otro_uso, usar;

    public Productos(){}

    public Productos(String nombre, String descripcion, String precio,String sirve, String efectosecundario, String efectograve, String otroUso, String usa) {
        this.Nombre = nombre;
        this.Descripcion = descripcion;
        this.Precio = precio;
        this.Sirve = sirve;
        this.efectosGraves = efectograve;
        this.efectosSecundarios = efectosecundario;
        this.otro_uso = otroUso;
        this.usar = usa;
    }

    public String getSirve() {
        return Sirve;
    }

    public void setSirve(String sirve) {
        Sirve = sirve;
    }

    public String getEfectosGraves() {
        return efectosGraves;
    }

    public void setEfectosGraves(String efectosGraves) {
        this.efectosGraves = efectosGraves;
    }

    public String getEfectosSecundarios() {
        return efectosSecundarios;
    }

    public void setEfectosSecundarios(String efectosSecundarios) {
        this.efectosSecundarios = efectosSecundarios;
    }

    public String getOtro_uso() {
        return otro_uso;
    }

    public void setOtro_uso(String otro_uso) {
        this.otro_uso = otro_uso;
    }

    public String getUsar() {
        return usar;
    }

    public void setUsar(String usar) {
        this.usar = usar;
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
