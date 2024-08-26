package org.example.model.Casilleros;

import org.example.model.Banco;
import org.example.model.Jugador;

import java.util.HashSet;
import java.util.List;

public class CasilleroLlegadaPartida extends Casillero {
    private Banco banco;
    private int montoVuelta;


    public CasilleroLlegadaPartida(int montoVuelta, Banco banco, List<Jugador> jugadores){
        this.montoVuelta = montoVuelta;
        this.banco = banco;
        this.color = "Magenta";
        this.fichas = new HashSet<>();
        for (Jugador jugador : jugadores) {
            this.fichas.add(jugador.getColor());
        }
    }

    public void pisar(Jugador jugador) {
        this.banco.darDinero(jugador, this.montoVuelta);
        System.out.println("Pasas por la salida, obtienes: " + this.montoVuelta + ". Tu dinero ahora es: "+ jugador.getDinero());
    }
}
