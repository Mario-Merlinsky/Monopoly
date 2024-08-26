package org.example.model.Administradores;

import org.example.model.Jugador;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AdministradorTurnos {
    private int turno;
    private List<Jugador> jugadores;
    private static AdministradorTurnos administradorTurnos;


    private AdministradorTurnos(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.sortearTurnos();
        this.turno = 0;
        System.out.println("El orden de turnos es: ");
        int i = 1;
        for (Jugador jugador : jugadores) {
            System.out.println(i + "." + jugador.getNombre());
            i += 1;
        }
    }

    public static AdministradorTurnos crearAdministradorTurnos(List<Jugador> jugadores){
        if (administradorTurnos == null) {
            administradorTurnos = new AdministradorTurnos(jugadores);
        }
        return administradorTurnos;
    }

    public void siguienteTurno() {
        this.turno += 1;
    }

    private void sortearTurnos() {
        Collections.shuffle(this.jugadores, new Random());
    }

    public Jugador obtenerJugador() {
        return this.jugadores.get(this.turno % this.jugadores.size());
    }

    public void quebrarJugador(Jugador jugador){
        this.jugadores.remove(jugador);
    }
}

