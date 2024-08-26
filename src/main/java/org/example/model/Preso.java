package org.example.model;

import org.example.model.Administradores.AdministradorCarcel;
import org.example.model.Administradores.AdministradorTurnos;

import java.util.ArrayList;
import java.util.List;

public class Preso implements Estado {
    private AdministradorCarcel administradorCarcel;
    private Menu menu;
    private List<String> opciones;
    private List<Runnable> acciones;


    public Preso(AdministradorCarcel administradorCarcel){
        this.opciones = new ArrayList<>();
        this.acciones = new ArrayList<>();
        this.administradorCarcel = administradorCarcel;
        this.opciones.add("1. Terminar Turno");
        this.opciones.add("2. Pagar fianza");
    }

    public void mover(int posiciones, Jugador jugador){
        if (posiciones > administradorCarcel.getCondena(jugador)) {
           administradorCarcel.liberarJugador(jugador);
        }else {

            administradorCarcel.disminuirTurnos(jugador);
            if (jugador.estaPreso()){
                System.out.println("Estas en la carcel, no puedes moverte. Te quedan " + administradorCarcel.getCondena(jugador) + " turnos en la carcel");
            }
        }

    }

    public void mostrarOpciones(Jugador jugador) {
        this.acciones.add(() -> administradorCarcel.pagarFianza(jugador));
        this.menu = new Menu(this.opciones, this.acciones);
        while (jugador.estaPreso()) {
            int opcion = this.menu.SeleccionarOpcion();
            if (opcion == 1) {
                break;
            }
            this.menu.realizarAccion(opcion);
        }
        if (!jugador.estaPreso()){
            jugador.mostrarOpciones();
        }
    }
}
