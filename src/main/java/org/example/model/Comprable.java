package org.example.model;

import java.util.Scanner;

public abstract class Comprable {
    protected int valor;
    protected Jugador propietario;
    protected int renta;
    protected boolean hipotecada = false;


    public boolean quiereComprar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Desea comprar la propiedad? (S/N).  Valor: " + valor);
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("S")){
            return true;
        } else if (respuesta.equalsIgnoreCase("N")){
            return false;
        } else {
            System.out.println("Respuesta no valida");
            return quiereComprar();
        }
    }

    public String getColorPropietario(){
        if (propietario == null){
            return null;
        }
        return propietario.getColor();
    }

    public boolean isHipotecada() {
        return hipotecada;
    }

    public void hipotecar(){
        this.hipotecada = true;
    }

    public boolean esPropiedad(){
        return this instanceof Propiedad;
    }

    public void comprar(Jugador jugador) {
        this.propietario = jugador;
    }

    public int getValor() {
        return valor;
    }

    public int getRenta() {
        return renta;
    }

    public Jugador getPropietario() {
        return propietario;
    }

    public boolean propietarioPreso(){
        return propietario.estaPreso();
    }

    public void setRenta(int renta){
        this.renta=renta;
    }

    public void setValor(int costoPropiedad){
        this.valor = costoPropiedad;
    }

    public void setPropietario(Jugador jugador){
        this.propietario = jugador;
    }

}
