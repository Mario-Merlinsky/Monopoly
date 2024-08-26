package org.example.view;

import org.example.model.Tablero;

import javax.swing.*;
import java.awt.*;

public class VistaTablero extends JPanel {
    private VistaCasilleroFactory vistaCasilleroFactory;
    private Tablero tablero;
    public VistaTablero(Tablero tablero){

        this.vistaCasilleroFactory = new VistaCasilleroFactory();
        this.tablero=tablero;
        mostrar();
    }


    public void mostrar() {
        int tam = (tablero.getCantCasilleros() / 4) + 1;

        setLayout(new GridLayout(tam, tam));


        int j = tablero.getCantCasilleros()-1;
        int k = 0;

        for (int fila = 0; fila < tam; fila++) {
            for (int columna = 0; columna < tam; columna++) {
                if (fila == 0) {
                    add( vistaCasilleroFactory.crearVistaCasillero(tablero.getCasillero(k), k));
                    k++;
                } else if (fila != tam - 1) {
                    if (columna == 0) {
                        add( vistaCasilleroFactory.crearVistaCasillero(tablero.getCasillero(j), j));
                        j--;
                    } else if (columna == tam - 1) {
                        add( vistaCasilleroFactory.crearVistaCasillero(tablero.getCasillero(k), k));
                        k++;
                    }
                    else {
                        add(new JPanel());
                    }
                } else if (fila == tam - 1) {
                    add( vistaCasilleroFactory.crearVistaCasillero(tablero.getCasillero(j), j));
                    j--;
                }
            }
        }
    }
}
