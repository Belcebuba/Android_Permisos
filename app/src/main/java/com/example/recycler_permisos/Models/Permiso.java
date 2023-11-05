package com.example.recycler_permisos.Models;

public class Permiso {

    String nombre;
    String descripcion;
    boolean isSeleccionado;

    public Permiso(String nombre, String descripcion) {
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

    public boolean isSeleccionado() {
        return isSeleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        isSeleccionado = seleccionado;
    }
}
