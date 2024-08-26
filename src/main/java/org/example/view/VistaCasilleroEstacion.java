package org.example.view;

import org.example.model.Casilleros.Casillero;
import org.example.model.Casilleros.CasilleroEstacionTransporte;

import javax.swing.*;
import java.awt.*;

public class VistaCasilleroEstacion  extends VistaCasillero {

    public VistaCasilleroEstacion(Casillero casillero, int posicion) {
        super(casillero, posicion);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int Width = getWidth();
        int Height = getHeight() ;
        CasilleroEstacionTransporte casilleroEstacionTransporte = (CasilleroEstacionTransporte) casillero;

        if (casilleroEstacionTransporte.getColorPropietario() != null) {
            String color = casilleroEstacionTransporte.getColorPropietario();
            g.setColor(string_a_color.get(color));
            g.fillRect(0, 0, Width, Height*3/4);
        }
        g.drawImage(new ImageIcon(getClass().getResource("/transporte.png")).getImage(), 0, 0, Width, Height*4/5, null);        pintarFicha(g, Height, Width);
    }


}
