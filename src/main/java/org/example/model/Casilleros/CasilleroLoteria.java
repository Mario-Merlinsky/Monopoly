package org.example.model.Casilleros;

import org.example.model.Banco;
import org.example.model.Jugador;

import java.util.HashSet;

public class CasilleroLoteria extends Casillero {
    private int montoLoteria;
    private Banco banco;


    public CasilleroLoteria(int montoLoteria, Banco banco){
        this.montoLoteria = montoLoteria;
        this.banco = banco;
        this.color = "Marron";
        this.fichas = new HashSet<>();

    }

    public void pisar(Jugador jugador) {
        System.out.println("Avanzas hasta un casillero de loteria");
        this.banco.darDinero(jugador, this.montoLoteria);
        System.out.println("Obtienes: " + this.montoLoteria + ". Tu dinero ahora es: "+ jugador.getDinero());
    }
}
