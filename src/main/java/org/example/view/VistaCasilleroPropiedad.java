package org.example.view;

import org.example.model.Casilleros.Casillero;
import org.example.model.Casilleros.CasilleroPropiedad;

import javax.swing.*;
import java.awt.*;

public class VistaCasilleroPropiedad extends VistaCasillero{

    public VistaCasilleroPropiedad(Casillero casillero, int posicion) {
        super(casillero, posicion);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        int Width = getWidth();
        int Height = getHeight() ;
        g.setColor(string_a_color.get(casillero.getColor()));
        g.fillRect(0, 0, Width, Height);


        CasilleroPropiedad casilleroPropiedad = (CasilleroPropiedad) casillero;
        Color color = casilleroPropiedad.getColorPropiedad();
        g.setColor(color);
        g.fillRect(0, 0, Width, Height/4);

        g.setColor(Color.white);
        g.fillRect(0, Height/4, Width, (Height * 3)/ 4);
        if (casilleroPropiedad.getColorPropietario() != null) {
            String colorPropietario = casilleroPropiedad.getColorPropietario();
            g.setColor(string_a_color.get(colorPropietario));
            g.fillRect(0, Height / 4, Width, Height * 2 / 4);
        }
        for (int i = 0; i < casilleroPropiedad.getCantCasasPropiedad(); i++) {
            g.drawImage(new ImageIcon("src/main/resources/casa.png").getImage(), (i + 1) * Width / 6, Height / 2, Width / 8, Height / 5, null);
            g.drawImage(new ImageIcon(getClass().getResource("/casa.png")).getImage(), (i + 1) * Width / 6, Height / 2, Width / 8, Height / 5, null);        pintarFicha(g, Height, Width);

        }
        if (casilleroPropiedad.getCantHotelesPropiedad() == 1) {
            g.drawImage(new ImageIcon(getClass().getResource("/hotel.png")).getImage(), Width / 4, Height / 2, Width / 2, Height / 2, null);        pintarFicha(g, Height, Width);

        }
        if (casilleroPropiedad.propiedadHipotecada()){
            g.drawImage(new ImageIcon(getClass().getResource("/hipotecada.png")).getImage(), 0, Height * 3/4, Width, Height /4, null);        pintarFicha(g, Height, Width);

        }
        pintarNumeroDeCelda(g, Width, Height);
        pintarFicha(g, Height, Width);
    }


    private void pintarNumeroDeCelda(Graphics g, int Width, int Height) {
        g.setColor(Color.BLACK);
        FontMetrics fm = g.getFontMetrics();
        String pos=posicion.toString();
        int x = (Width - fm.stringWidth(pos)) / 2;
        int y = (Height - fm.getHeight()) / 2 + fm.getAscent();
        g.drawString(pos, x, y);
    }

}
