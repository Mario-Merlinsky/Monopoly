package org.example.model.Casilleros;

import org.example.model.Banco;
import org.example.model.Jugador;

import java.util.HashSet;

public class CasilleroMulta extends Casillero{
    private int montoMulta;
    private Banco banco;


    public CasilleroMulta(int montoMulta, Banco banco){
        this.montoMulta = montoMulta;
        this.banco = banco;
        this.color = "Naranja";
        this.fichas = new HashSet<>();

    }

    public void pisar(Jugador jugador){
        System.out.println("Avanzas hasta un casillero de multa");
        this.banco.recibirDeuda(jugador, this.montoMulta);
        System.out.println("Pagas: " + this.montoMulta + ". Tu dinero ahora es: "+ jugador.getDinero());
    }
}