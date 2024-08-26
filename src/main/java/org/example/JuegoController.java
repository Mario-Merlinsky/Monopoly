package org.example;
import org.example.model.Juego;
import java.util.Random;



public class JuegoController {
    private Juego juego;


    public JuegoController(Juego juego){
        this.juego = juego;

    }

    public void jugarTurno() {
        System.out.println("Turno de: " + juego.getJugadorActual().getNombre());
        System.out.println("Lanzando dado");
        Random dado = new Random();
        int resultado = (dado.nextInt(6) + 1);
        System.out.println("Sacaste " + resultado);
        this.juego.jugar(resultado);
    }
}
