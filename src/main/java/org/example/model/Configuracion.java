package org.example.model;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Configuracion {
    private HashSet<String> coloresDisponibles = new HashSet<>();
    private int montoInicial;
    private int montoVuelta;
    private int turnosPreso;
    private int montoMulta;
    private int montoLoteria;
    private int cantidadPaso;
    private int cantidadLoteria;
    private int cantidadMulta;
    private int cantidadPropiedad;
    private int cantidadEstacion;
    private int cantidadIrCarcel;
    private int cantidadIdealPorBarrio;
    private int fianza;
    private int valorPropiedadMinimo;
    private int valorEstacionesTransporte;
    private int valorRentaEstacionesTransporte;



    public Configuracion() throws IOException {
        //Todos estos parametros son configurables, la cantidad de casilleros total + 1 (el casillero de llegada y partida)
        //debe ser divisible por 4 para poder ser representado de forma correcta en el tablero
        this.montoInicial = 1000;
        this.montoVuelta = 20;
        this.turnosPreso = 3;
        this.montoMulta = 20;
        this.montoLoteria = 20;
        this.cantidadIdealPorBarrio = 3;
        this.valorPropiedadMinimo = 50;
        this.valorEstacionesTransporte = 50;
        this.valorRentaEstacionesTransporte = 10;

        this.cantidadPaso = 14;
        this.cantidadLoteria = 2;
        this.cantidadMulta = 5;
        this.cantidadEstacion = 4;
        this.cantidadPropiedad = 7;
        this.cantidadIrCarcel = 2;

        this.fianza = 50;


        this.coloresDisponibles.add("rojo");
        this.coloresDisponibles.add("azul");
        this.coloresDisponibles.add("verde");
        this.coloresDisponibles.add("amarillo");
    }

    public String preguntarNombre(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre del jugador: ");
        String respuesta = scanner.nextLine();
        return respuesta;
    }

    public String preguntarColor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione un color de los disponibles: ");
        String color = scanner.nextLine().toLowerCase();

        if (coloresDisponibles.contains(color)){
            coloresDisponibles.remove(color);
            return color;
        }
        System.out.println("Color no disponible");
        return preguntarColor();
    }

    public int preguntarCantidadJugadores(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese cantidad de jugadores (2-4): ");
        String respuesta = scanner.nextLine();
        if (respuesta.matches("[2-4]")){
            return Integer.parseInt(respuesta);
        }
        System.out.println("Cantidad no valida");
        return preguntarCantidadJugadores();
    }

    public int getMontoInicial() {
        return montoInicial;
    }

    public int getMontoVuelta() {
        return montoVuelta;
    }

    public int getTurnosPreso() {
        return turnosPreso;
    }

    public int getMontoMulta() {
        return montoMulta;
    }

    public int getMontoLoteria() {
        return montoLoteria;
    }

    public int getCantidadLoteria() {
        return cantidadLoteria;
    }

    public int getCantidadMulta() {
        return cantidadMulta;
    }

    public int getCantidadPropiedad() {
        return cantidadPropiedad;
    }

    public int getCantidadEstacion() {
        return cantidadEstacion;
    }

    public int getCantidadIrCarcel() {
        return cantidadIrCarcel;
    }


    public int getCantidadIdealPorBarrio() {
        return cantidadIdealPorBarrio;
    }

    public int getFianza() {
        return fianza;
    }

    public int getCantidadPaso() {
        return cantidadPaso;
    }

    public int getValorPropiedadMinimo() {
        return valorPropiedadMinimo;
    }

    public int getValorRentaEstacionesTransporte() {
        return valorRentaEstacionesTransporte;
    }

    public int getValorEstacionesTransporte() {
        return valorEstacionesTransporte;
    }
}
