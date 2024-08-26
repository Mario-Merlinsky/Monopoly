package org.example.model;


import java.awt.*;

public class Propiedad extends Comprable {
    private int precioHipotecario;
    private int cantidadCasas;
    private int cantidadHoteles;
    private Color color;
    private Barrio barrio;
    private int posicion;
    private int valorCasa;
    private int valorHotel;


    public Propiedad(){
        this.cantidadCasas = 0;
        this.cantidadHoteles = 0;
    }

    public int getCantidadHoteles() {
        return cantidadHoteles;
    }

    public int getCantidadCasas() {
        return cantidadCasas;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getRenta() {
        return renta + ((renta / 2) * cantidadCasas) + renta * cantidadHoteles * 4;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void construirCasa(){
        this.cantidadCasas += 1;
    }

    public void construirHotel(){
        this.cantidadHoteles +=1;
        this.cantidadCasas = 0;
    }

    public void setPrecioHipotecario(int precioHipotecario){
        this.precioHipotecario=precioHipotecario;
    }

    public void setValorCasa(int valorCasa) {
        this.valorCasa = valorCasa;
    }

    public void setValorHotel(int valorHotel) {
        this.valorHotel = valorHotel;
    }

    public int getValorHotel() {
        return valorHotel;
    }

    public int getValorCasa() {
        return valorCasa;
    }

    public int getPrecioHipotecario() {
        return precioHipotecario;
    }

    public void demolerCasa(){
        this.cantidadCasas--;
    }

    public void demolerHotel(){
        this.cantidadHoteles--;
    }

    public void deshipotecar(){
        this.hipotecada = false;
    }

    @Override
    public void setPropietario(Jugador propietario) {
        this.propietario = propietario;
        this.barrio.verificarNuevoPropietario(propietario);
    }

    public void setCantidadHoteles(int i) {
        this.cantidadHoteles = i;
    }

    public void setCantidadCasas(int i) {
        this.cantidadCasas = i;
    }
}

