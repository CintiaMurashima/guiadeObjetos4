package com.company;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {


        ArrayList<Pelicula> peliculas= new ArrayList<>();
        ArrayList<Cliente> clientes= new ArrayList<>();
        ArrayList<Alquiler> alquileres= new ArrayList<>();

        Pelicula peli1=new Pelicula("los angeles de charly","2010",120,"PG",2,"usa","bien","Accion");
        Pelicula peli2=new Pelicula("avatar","2020",120,"PG",2,"usa","buena","Accion");
        Pelicula peli3=new Pelicula("avenger","2020",120,"PG",5,"usa","excelente","Aventura");

        Cliente cli1= new Cliente("Mati","2234566789","ruta225");
        Cliente cli2= new Cliente("Cin","2234566789","ruta226");

        peliculas.add(peli1);
        peliculas.add(peli2);
        peliculas.add(peli3);

        clientes.add(cli1);
        clientes.add(cli2);

        Alquiler alqui;
        Scanner scanner = new Scanner(System.in);
        String seleccion="0";



        System.out.println("Alquilar pelicula -1 ");
        System.out.println("Alquileres vigentes -2 ");
        System.out.println("Devoluciones del dia -3 ");
        System.out.println("Ultimos alquileres de clientes -4 ");
        System.out.println("Mas alquiladas -5 ");
        System.out.println("Buscar por genero -6");
        System.out.println("Caracteristicas de la pelicula -7");
        System.out.println("Salir-8");



        while (seleccion != "8") {
            seleccion = scanner.next();

            switch (seleccion) {
                case "1":

                    alqui = alquilarPelicula(peliculas, clientes);
                    if (alqui != null) {
                        alquileres.add(alqui);
                    }

                    break;
                case "2":

                    alquileresVigentes(alquileres);

                    break;
                case "3":

                    devolucionHoy(alquileres);

                    break;

                case "4":

                        Cliente cliente=buscarCliente(clientes);
                        System.out.println("ULTIMOS 10 ALQUILERES DE"+ cliente.getNombre());
                        cliente.alquileresCliente();

                    break;

                case "5":

                    masAlquiladas(peliculas);

                    break;

                case "6":

                    buscarPorGenero(peliculas);

                    break;

                case "7":

                    buscarPeli(peliculas);

                    break;

                default:
                    System.out.println("opcion incorrecta");
            }
        }
        /// devoluciones en el dia de la fecha

        SimpleDateFormat date1= new SimpleDateFormat();
/*
        void devolucionDia(SimpleDateFormat date1){
            for(int i=0; i < peliculas.size(); i++) {
                if (date1.compareTo(this.fechaDevolucion) == 0) {
                    System.out.println(peliculas.get(i));
                }
            }
        }*/

    }

    public static Cliente crearCliente(){
        Cliente cliente= new Cliente();
        Scanner scanner = new Scanner(System.in);
        String texto;
        System.out.println("Ingrese Nombre:");
        texto = scanner.nextLine();
        cliente.setNombre(texto);
        System.out.println("Ingrese Telefono:");
        texto = scanner.nextLine();
        cliente.setTelefono(texto);
        System.out.println("Ingrese Dirección:");
        texto = scanner.nextLine();
        cliente.setDireccion(texto);
        return cliente;
    }

    public static Alquiler alquilarPelicula(ArrayList<Pelicula> peliculas,ArrayList<Cliente> clientes) {
       Alquiler alquiler = null;
        LocalDate entrega = LocalDate.now();
        LocalDate devo;
        Pelicula peli=buscarPelicula(peliculas);
        if(peli.getCopias() > 0) {
            alquiler = new Alquiler();
            alquiler.setPelicula(peli);
            Cliente client = buscarCliente(clientes);
            if (client == null) {
                client = crearCliente();
                clientes.add(client);
            }
            alquiler.setCliente(client);

            devo = fechaDevo();
            alquiler.setFechaRetiro(entrega);
            alquiler.setFechaDevolucion(devo);

            client.agregarAlquiler(alquiler);
            peli.setCopias(peli.getCopias()-1);
            peli.setAlquiler(peli.getAlquiler()+1);

        }else {
            System.out.println("Peli no disponible");
        }


        return alquiler;
    }

    public static LocalDate fechaDevo(){
        LocalDate date;
        int dia;
        int mes;
        int anio;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese dia");
        dia = scanner.nextInt();
        System.out.println("Ingrese mes");
        mes = scanner.nextInt();
        System.out.println("Ingrese Año");
        anio = scanner.nextInt();
        date=LocalDate.of(anio,mes,dia);

        return date;

    }

    public static Pelicula buscarPelicula(ArrayList<Pelicula> peliculas){
        System.out.println(peliculas);
        Pelicula peli= null;
        int i=0;
        Scanner scanner = new Scanner(System.in);
        String texto;
        while(peli == null) {
            System.out.println("Ingrese pelicula:");
            texto = scanner.nextLine();
            i = 0;
            while (i < peliculas.size() && peli == null) {
                if (texto.compareTo(peliculas.get(i).getTitulo()) == 0) {
                    peli = peliculas.get(i);
                } else {
                    i++;
                }
            }
            if(peli == null)
                System.out.println("no se encontro la pinche peli");
        }
        return peli;
    }

    public static Cliente buscarCliente(ArrayList<Cliente> clientes){

        Cliente client= null;
        int i=0;
        Scanner scanner = new Scanner(System.in);
        String texto;

        System.out.println("Ingrese Cliente:");
        texto = scanner.nextLine();

            while (i < clientes.size() && client == null) {
                if (texto.compareTo(clientes.get(i).getNombre()) == 0) {
                    client = clientes.get(i);
                } else {
                    i++;
                }
            }
            if(client == null)
                System.out.println("El cliente no se encontro");

            return client;
        }

        public static void alquileresVigentes(ArrayList<Alquiler> alquileres) {
            LocalDate hoy = LocalDate.now();
            for (int i = 0; i < alquileres.size(); i++) {
                if (alquileres.get(i).getFechaDevolucion().isAfter(hoy)) {
                    System.out.println(alquileres.get(i));
                }
            }
        }

        public static void devolucionHoy(ArrayList<Alquiler> alquileres) {
            LocalDate hoy = LocalDate.now();
            for (int i = 0; i < alquileres.size(); i++) {
                if (alquileres.get(i).getFechaDevolucion().isEqual(hoy)) {
                    System.out.println(alquileres.get(i));
                }
            }
        }

    public static void masAlquiladas(ArrayList<Pelicula> peliculas){
        Collections.sort(peliculas, Collections.reverseOrder());
        for (int i=0; i<peliculas.size(); i++) {
            System.out.println(peliculas.get(i));
        }
    }

    public static void titulos(ArrayList<Pelicula> peliculas){
        Collections.sort(peliculas, Collections.reverseOrder());
        for (int i=0; i<peliculas.size(); i++) {
            System.out.println(peliculas.get(i));
        }
    }


    public static void buscarPorGenero(ArrayList<Pelicula> peliculas){
        Scanner scanner = new Scanner(System.in);
        String genero;
        System.out.println("Ingresar un genero");
        genero = scanner.nextLine();

        Collections.sort(peliculas, Collections.reverseOrder());
        for (int i=0; i<peliculas.size(); i++) {
            if(genero.compareTo(peliculas.get(i).getGenero())==0)
                System.out.println(peliculas.get(i));
        }

    }

    public static void buscarPeli(ArrayList<Pelicula> peliculas){
        Scanner scanner = new Scanner(System.in);
        String titulo;
        System.out.println("Ingresar peli");
        titulo = scanner.nextLine();

        Collections.sort(peliculas, Collections.reverseOrder());
        for (int i=0; i<peliculas.size(); i++) {
            if(titulo.compareTo(peliculas.get(i).getTitulo())==0)
                System.out.println(peliculas.get(i));
        }

    }






}
