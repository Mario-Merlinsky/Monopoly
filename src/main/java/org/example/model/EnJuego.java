package org.example.model;
import org.example.model.Casilleros.Casillero;

import java.util.ArrayList;
import java.util.List;

public class EnJuego implements Estado {
    private Tablero tablero;
    private static EnJuego enJuego;
    private List<String> opciones = new ArrayList<>();
    private Menu menu;


    private EnJuego(Tablero tablero) {
        this.tablero = tablero;
        opciones.add("1. Terminar Turno");
        opciones.add("2. Construir Propiedad");
        opciones.add("3. Vender construccion");
        opciones.add("4. Hipotecar propiedad");
        opciones.add("5. Deshipotecar propiedad");
    }

    public static EnJuego crearEnJuego(Tablero tablero){
        if (enJuego == null) {
            enJuego = new EnJuego(tablero);
        }
        return enJuego;
    }

    public void mover(int posiciones, Jugador jugador) {
        int posicionAnterior = jugador.getPosicion();
        Casillero casillaAnterior = this.tablero.getCasillero(posicionAnterior );
        casillaAnterior.sacarFicha(jugador.getColor());
        if (posicionAnterior + posiciones > tablero.getCantCasilleros()) {
            Casillero casilla = this.tablero.getCasillero(0);
            casilla.pisar(jugador);
        }
        jugador.setPosicion((posicionAnterior + posiciones) % tablero.getCantCasilleros());
        Casillero casilla = this.tablero.getCasillero(jugador.getPosicion());
        casilla.setFicha(jugador.getColor());
        casilla.pisar(jugador);
    }

    public void mostrarOpciones(Jugador jugador){
        List<Runnable >acciones = new ArrayList<>();
        acciones.add(jugador::construir);
        acciones.add(jugador::venderPropiedad);
        acciones.add(jugador::hipotecar);
        acciones.add(jugador::deshipotecar);
        menu = new Menu(opciones, acciones);
        while (true) {
            int opcion = menu.SeleccionarOpcion();
            if (opcion == 1) {
                break;
            }
            menu.realizarAccion(opcion);
        }
    }


}
