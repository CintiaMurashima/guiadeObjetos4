package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente {

    private String nombre;
    private String telefono;
    private String direccion;
    private ArrayList<Alquiler> pelisAlquiladas= new ArrayList<Alquiler>();

    public Cliente() {}

    public Cliente(String nombre, String telefono, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Alquiler> getPelisAlquiladas() {
        return pelisAlquiladas;
    }

    public void setPelisAlquiladas(ArrayList<Alquiler> pelisAlquiladas) {
        this.pelisAlquiladas = pelisAlquiladas;
    }

    public void agregarAlquiler(Alquiler alquiler){
        this.pelisAlquiladas.add(alquiler);
    }

        public void alquileresCliente() {
            int i = 0;
            while (i < 10 && i < pelisAlquiladas.size()) {
                System.out.println(pelisAlquiladas.get(i).getPelicula().getTitulo());
                i++;
            }
        }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
