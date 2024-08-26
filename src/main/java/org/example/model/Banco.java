package org.example.model;

public class Banco {
    public void darDinero(Jugador jugador, int dinero){
        jugador.setDinero(jugador.getDinero() + dinero);
    }

    public boolean recibirDinero(Jugador jugador, int dinero) {
        if (jugador.getDinero() >= dinero) {
            jugador.setDinero(jugador.getDinero() - dinero);
            return true;
        }
        return false;
    }

    public void recibirDeuda(Jugador jugador, int dinero) {
        jugador.setDinero(jugador.getDinero() - dinero);
    }
}