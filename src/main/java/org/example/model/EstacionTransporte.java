package org.example.model;

public class EstacionTransporte extends Comprable {

    public EstacionTransporte(int valor, int renta){
        this.valor = valor;
        this.renta = renta;
    }

    public int getRenta() {
        return renta * propietario.getCantidadTransporte();
    }
}

