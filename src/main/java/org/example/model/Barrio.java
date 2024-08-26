package org.example.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Barrio {

    private final List<Propiedad> propiedades;
    private int cantidadPropiedades;
    private Jugador propietario;
    private Color color;
    private int costoCasa;
    private int costoHotel;
    private int costoPropiedad;


    public Barrio(int numeroDeBarrio, int costoPropiedad) {
        Random random = new Random();

        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        this.color= new Color(red, green, blue);

        this.propiedades = new ArrayList<>();
        this.propietario = null;
        cantidadPropiedades = 0;
        this.costoPropiedad = costoPropiedad + (numeroDeBarrio - 1) * (costoPropiedad/5);
        this.costoCasa = costoPropiedad / 5;
        this.costoHotel = costoPropiedad;
    }

    public void agregarPropiedad(Propiedad propiedad){
        this.propiedades.addLast(propiedad);
        propiedad.setColor(this.color);
        propiedad.setValor(this.costoPropiedad);
        propiedad.setPrecioHipotecario(this.costoPropiedad / 2);
        propiedad.setRenta(this.costoPropiedad / 10);
        propiedad.setValorCasa(this.costoCasa);
        propiedad.setValorHotel(this.costoHotel);
        propiedad.setBarrio(this);
        cantidadPropiedades++;
    }

    public void verificarNuevoPropietario(Jugador jugador){
        for (Propiedad propiedad :propiedades){
            if (propiedad.getPropietario() != jugador){
                return;
            }
        }
        this.propietario = jugador;
    }

    public int getCantidadPropiedades(){
        return cantidadPropiedades;
    }

    public Jugador getPropietario() {return propietario;}

    public int getCostoCasa() {
        return costoCasa;
    }

    public int getCostoHotel() {
       return costoHotel;
    }

}
