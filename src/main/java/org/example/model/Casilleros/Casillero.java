package org.example.model.Casilleros;

import org.example.model.Jugador;

import java.util.HashSet;
import java.util.List;

public abstract class Casillero{
    protected String color;
    protected HashSet<String> fichas;
    protected int posicion;


    public abstract void pisar(Jugador jugador);

    public String getColor() {
        return color;
    }

    public HashSet<String> getFichas(){ return fichas;}

    public void setFicha(String ficha){
        fichas.add(ficha);
    }

    public void sacarFicha(String ficha){
        fichas.remove(ficha);
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion){
        this.posicion = posicion;
    }
}