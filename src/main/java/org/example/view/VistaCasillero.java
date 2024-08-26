package org.example.view;

import javax.swing.*;
import javax.swing.border.Border;

import org.example.model.Casilleros.Casillero;

import java.awt.*;
import java.util.HashMap;

public abstract class VistaCasillero extends JPanel {

    protected Casillero casillero;

    protected Integer posicion;

    protected HashMap<String,Color> string_a_color=new HashMap<String,Color>(){{
        put("Marron",new Color(139,69,19));
        put("Magenta",Color.MAGENTA);
        put("Gris",Color.GRAY);
        put("Verde Agua",new Color(94, 131, 131));
        put("Naranja",Color.ORANGE);
        put("Rosa",Color.PINK);
        put("Celeste",new Color(135,206, 235));
        put("amarillo",Color.YELLOW);
        put("rojo",Color.RED);
        put("verde",Color.GREEN);
        put("azul",Color.BLUE);
        put("Blanco",Color.WHITE);
    }};


    public VistaCasillero(Casillero casillero, Integer posicion){
        this.casillero=casillero;
        this.posicion=posicion+1;
        setPreferredSize(new Dimension(100,100));
        Border border=BorderFactory.createLineBorder(Color.BLACK,1);
        setBorder(border);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        int Width = getWidth();
        int Height = getHeight() ;
        g.setColor(string_a_color.get(casillero.getColor()));
        g.fillRect(0, 0, Width, Height);

    }


    protected void pintarFicha(Graphics g, int Height, int Width) {
        int fichaY = Height * 9/10;
        int fichaX = Width / 5;
        for (String ficha : casillero.getFichas()) {
            int radio = Math.min(getWidth(), getHeight()) / 8;
            int centroX = fichaX;
            int centroY = fichaY;
            g.setColor(string_a_color.get(ficha));
            g.fillOval(centroX - radio, centroY - radio, radio, radio);

            fichaX = fichaX + getWidth() / 5;
        }
    }

}

