package org.example.view;

import org.example.model.Casilleros.*;

import javax.swing.*;
import java.awt.*;

public class VistaCasilleroLoteria extends VistaCasillero {
    public VistaCasilleroLoteria(Casillero casillero, int posicion ) {
        super(casillero, posicion);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        int Width = getWidth();
        int Height = getHeight() ;

        g.drawImage(new ImageIcon(getClass().getResource("/loteria.png")).getImage(), 0, 0, Width, Height, null);        pintarFicha(g, Height, Width);
        pintarFicha(g, Height, Width);
    }
}
