package org.example.model.Casilleros;

import org.example.model.Administradores.AdministradorPropiedades;
import org.example.model.EstacionTransporte;
import org.example.model.Jugador;

import java.util.HashSet;

public class CasilleroEstacionTransporte extends Casillero {
    EstacionTransporte estacionTransporte;
    AdministradorPropiedades administradorPropiedades;


    public CasilleroEstacionTransporte(EstacionTransporte estacionTransporte, AdministradorPropiedades administradorPropiedades) {
        this.administradorPropiedades = administradorPropiedades;
        this.estacionTransporte = estacionTransporte;
        this.color = "Celeste";
        this.fichas = new HashSet<>();
    }

    public void pisar(Jugador jugador) {
        System.out.println("Avanzas hasta una casilla de estacion de transporte");

        if (estacionTransporte.getPropietario() == null) {
            if (estacionTransporte.quiereComprar()) {
                administradorPropiedades.comprar(this.estacionTransporte, jugador);
            }
        }else {
                if (jugador.getCantidadTransporte() > 0){
                    System.out.println("Tienes al menos una estacion de transporte, no pagas renta");
                    return;
                }
                administradorPropiedades.pagarAlquier(this.estacionTransporte, jugador);
        }
    }

    public String getColorPropietario(){
        return estacionTransporte.getColorPropietario();
    }
}
