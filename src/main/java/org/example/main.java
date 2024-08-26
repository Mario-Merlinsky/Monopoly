package org.example;

import org.example.model.Configuracion;
import org.example.model.Juego;
import org.example.model.Jugador;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        try {
            Configuracion configuracion = new Configuracion();
            List<Jugador> jugadores = new ArrayList<>();

            int cantidadJugadores = configuracion.preguntarCantidadJugadores();
            for (int i = 1; i < cantidadJugadores+ 1; i+=1){
                System.out.println("Jugador " + i);
                jugadores.add(new Jugador(configuracion.preguntarNombre(),configuracion.preguntarColor()));
            }
            Juego juego = new Juego(configuracion, jugadores);
            JuegoController juegoController = new JuegoController(juego);

            while (!juego.terminado()){
                juegoController.jugarTurno();
            }
            System.out.println("Juego terminado!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}