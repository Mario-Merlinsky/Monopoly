package org.example.model;

public interface Estado {
    public abstract void mover(int posiciones, Jugador jugador);

    public abstract void mostrarOpciones(Jugador jugador);

}
