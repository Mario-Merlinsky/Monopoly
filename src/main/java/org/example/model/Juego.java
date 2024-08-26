package org.example.model;


import org.example.model.Administradores.*;

import org.example.model.Administradores.AdministradorTurnos;
import org.example.model.Casilleros.*;
import org.example.view.VistaJuego;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;


public class Juego {
    private VistaJuego vistaJuego;
    private Tablero tablero;
    private List<Jugador> jugadores;
    private AdministradorTurnos administradorTurnos;
    private AdministradorCarcel administradorCarcel;
    private AdministradorPropiedades administradorPropiedades;
    private Banco banco;
    private List<Propiedad> propiedades;
    private HashMap<String, Supplier<Casillero>> casilleros = new HashMap<>();


    public Juego(Configuracion configuracion, List<Jugador> jugadores){
        this.jugadores = jugadores;
        this.administradorTurnos = AdministradorTurnos.crearAdministradorTurnos(jugadores);
        this.administradorPropiedades=AdministradorPropiedades.crearAdministradorPropiedades();//propiedades);
        this.administradorCarcel=new AdministradorCarcel(configuracion.getTurnosPreso(),configuracion.getFianza());
        this.banco = new Banco();


        this.casilleros.put("Partida",() -> new CasilleroLlegadaPartida(configuracion.getMontoVuelta(), this.banco, jugadores));
        this.casilleros.put("Paso",() -> new CasilleroPaso());
        this.casilleros.put("Loteria",() -> new CasilleroLoteria(configuracion.getMontoLoteria(), this.banco));
        this.casilleros.put("Ir Carcel", () -> new CasilleroIrCarcel(administradorCarcel));
        this.casilleros.put("Carcel", () -> new CasilleroCarcel());
        this.casilleros.put("Multa", () -> new CasilleroMulta(configuracion.getMontoMulta(),this.banco));
        this.casilleros.put("Transporte", () -> new CasilleroEstacionTransporte(new EstacionTransporte(configuracion.getValorEstacionesTransporte(),
                configuracion.getValorRentaEstacionesTransporte()),administradorPropiedades));
        this.casilleros.put("Propiedad", () -> new CasilleroPropiedad(new Propiedad(),administradorPropiedades));
        this.tablero = new Tablero(configuracion, casilleros);
        this.propiedades = tablero.getPropiedades();


        EnJuego enjuego = EnJuego.crearEnJuego(this.tablero);
        for (Jugador jugador: jugadores) {
            jugador.setEstado(enjuego);
            banco.darDinero(jugador, configuracion.getMontoInicial());
        }

        this.administradorCarcel.setPosCarcel(this.tablero.getPosCarcel());
        this.administradorCarcel.setEnJuego(enjuego);
        this.vistaJuego = VistaJuego.crearVistaJuego(this);
    }

    public Jugador getJugadorActual() {
        return administradorTurnos.obtenerJugador();
    }

    public void jugar(int posiciones){
        Jugador jugador = this.getJugadorActual();

        jugador.mover(posiciones);
        this.vistaJuego.mostrarJuego();
        jugador.mostrarOpciones();
        administradorTurnos.siguienteTurno();
    }

    public Tablero getTablero(){
        return this.tablero;
    }

    public boolean terminado(){
        if (verificarQuebrados() == 1) {
            System.out.println("El ganador es: " + jugadores.getFirst().getNombre());
            return true;
        }
        int i;
        for (i = 0; i < jugadores.size(); i++){
            if (jugadores.get(i).getCantPropiedades() == this.propiedades.size());{
                for(Propiedad propiedad: propiedades){
                    if (propiedad.getCantidadHoteles() != 1){
                        return false;
                    }
                }
            }
        }
        System.out.println("El ganador es: " + jugadores.get(i).getNombre());
        return true;
    }

    public int verificarQuebrados() {
        for (Jugador jugador: jugadores) {
            if (jugador.getDinero() < 0) {
                tablero.removerPropiedades(jugador);
                administradorTurnos.quebrarJugador(jugador);
                jugadores.remove(jugador);
                tablero.quitarFicha(jugador);
                System.out.println(jugador.getNombre() + " ha quebrado, ya no participara del juego");
                break;
            }
        }
        return jugadores.size();
    }

}
