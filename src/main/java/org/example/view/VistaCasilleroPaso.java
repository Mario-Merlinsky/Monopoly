package org.example.view;

import org.example.model.Casilleros.Casillero;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class VistaCasilleroPaso extends VistaCasillero {

    public VistaCasilleroPaso(Casillero casillero, int posicion) {
        super(casillero, posicion);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        int Width = getWidth();
        int Height = getHeight() ;
        g.drawImage(new ImageIcon(getClass().getResource("/paso.png")).getImage(), 0, 0, Width, Height, null);        pintarFicha(g, Height, Width);
        pintarFicha(g, Height, Width);
    }

}
