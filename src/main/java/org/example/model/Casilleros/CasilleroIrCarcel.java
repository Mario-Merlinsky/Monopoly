package org.example.model.Casilleros;


import org.example.model.Administradores.AdministradorCarcel;
import org.example.model.Jugador;
import java.util.HashSet;

public class CasilleroIrCarcel extends Casillero{
    AdministradorCarcel administradorCarcel;


    public CasilleroIrCarcel(AdministradorCarcel administradorCarcel){
        this.administradorCarcel=administradorCarcel;
        this.color = "Gris";
        this.fichas = new HashSet<>();
    }

    public void pisar(Jugador jugador){
        System.out.println("Avanzas hasta un casillero de ir a la carcel");
        administradorCarcel.apresarJugador(jugador);
    }
}


