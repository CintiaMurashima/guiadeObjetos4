package com.company;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Alquiler {

    private Cliente cliente;
    private LocalDate fechaRetiro;
    private LocalDate fechaDevolucion;
    private Pelicula pelicula;

    public Alquiler() {}

    public Alquiler(Cliente cliente, LocalDate fechaRetiro, LocalDate fechaDevolucion, Pelicula pelicula) {
        this.cliente = cliente;
        this.fechaRetiro= fechaRetiro;
        this.fechaDevolucion = fechaDevolucion;
        this.pelicula = pelicula;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(LocalDate fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }


    @Override
    public String toString() {
        return "Alquiler{" +
                "cliente=" + cliente +
                ", fechaRetiro=" + fechaRetiro +
                ", fechaDevolucion=" + fechaDevolucion +
                ", pelicula=" + pelicula +
                '}';
    }


}
