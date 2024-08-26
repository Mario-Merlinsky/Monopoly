package org.example.model.Casilleros;

import org.example.model.Jugador;

import java.util.ArrayList;
import java.util.HashSet;

public class CasilleroCarcel extends Casillero {
    public CasilleroCarcel() {
        this.color = "Verde Agua";
        this.fichas = new HashSet<>();
    }

    public void pisar(Jugador jugador) {
        System.out.println("Avanzas a la carcel");

    }
}
