package org.example.model.Administradores;

import org.example.model.Banco;
import org.example.model.EnJuego;
import org.example.model.Jugador;
import org.example.model.Preso;

import java.util.HashMap;

public class AdministradorCarcel {

    public HashMap<Jugador, Integer> encarcelados;
    private int turnosPenalizacion;
    private int posCarcel;
    private int fianza;
    private EnJuego enJuego;


    public AdministradorCarcel(int turnosPenalizacion,int fianza ){
        encarcelados = new HashMap<>();
        this.turnosPenalizacion = turnosPenalizacion;
        this.fianza=fianza;

    }

    public void apresarJugador(Jugador jugador){
        encarcelados.put(jugador,turnosPenalizacion);
        int posicionActual = jugador.getPosicion();
        jugador.mover(posCarcel - posicionActual);
        jugador.setEstado(new Preso(this));
    }

    public void liberarJugador(Jugador jugador){
        encarcelados.remove(jugador);
        jugador.setEstado(enJuego);
        System.out.println("Jugador liberado de la carcel");
    }

    public int getCondena(Jugador jugador){
        return this.encarcelados.get(jugador);
    }

    public void disminuirTurnos(Jugador jugador){
        int turnos = encarcelados.get(jugador) - 1;
        if(turnos == 0){
            liberarJugador(jugador);
        }
        else{
            encarcelados.put(jugador, turnos);
        }
    }

    public void setPosCarcel(int posCarcel){
        this.posCarcel=posCarcel;
    }

    public void pagarFianza(Jugador jugador){
            Banco banco=new Banco();
            if (banco.recibirDinero(jugador,fianza)) {
                System.out.println("Pagaste la fianza. Total de dinero restante: " + jugador.getDinero());
                liberarJugador(jugador);
            }else{
                System.out.println("No tienes dinero suficiente para pagar la fianza");
            }
    }

    public void setEnJuego(EnJuego enJuego) {
        this.enJuego = enJuego;
    }

}