package com.company;

public class Pelicula implements Comparable<Pelicula>{

    private String titulo;
    private String fechaLanzamiento;
    private double duracion;
    private String clasificacion;
    private int copias;
    private String paisSiglas;
    private String descripcion;
    private String genero;
    private int alquiler;


    public Pelicula(String titulo, String fechaLanzamiento, double duracion, String clasificacion, int copias, String paisSiglas, String descripcion, String genero) {
        this.titulo = titulo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.duracion = duracion;
        this.copias = copias;
        this.paisSiglas = paisSiglas;
        this.descripcion = descripcion;
        this.alquiler= 0;
        if (clasificacion == "G" ||
                clasificacion == "PG" ||
                clasificacion == "PG-13" ||
                clasificacion == "R" ||
                clasificacion == "NC-17" ||
                clasificacion == "UNRATED"
        )
            this.clasificacion = clasificacion;
        else
            this.clasificacion = "UNRATED";

        if(  genero == "Accion" ||
                genero == "Aventura"||
                genero == "Comedia" ||
                genero == "Drama"||
                genero == "Horror"||
                genero == "Documental"
        )
            this.genero= genero;
        else
            this.genero="Accion";
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(int alquiler) {
        this.alquiler = alquiler;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getCopias() {
        return copias;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }

    public String getPaisSiglas() {
        return paisSiglas;
    }

    public void setPaisSiglas(String paisSiglas) {
        this.paisSiglas = paisSiglas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", fechaLanzamiento='" + fechaLanzamiento + '\'' +
                ", duracion=" + duracion +
                ", clasificacion=" + clasificacion +
                ", copias=" + copias +
                ", paisSiglas='" + paisSiglas + '\'' +
                ", descripcion='" + descripcion + '\'' +
                " alquileres=" + alquiler +  '\'' +
                '}';
    }

    @Override
    public int compareTo(Pelicula pelicula) {
        int valor;
        if (this.alquiler < pelicula.getAlquiler()) {
            valor = -1;
        } else if(this.alquiler > pelicula.getAlquiler()) {
            valor = 1;
        } else {
            valor = 0;
        }
        return valor;
    }
}
