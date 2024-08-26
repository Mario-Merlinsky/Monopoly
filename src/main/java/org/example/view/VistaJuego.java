package org.example.view;
import org.example.model.Juego;
import org.example.model.Jugador;
import org.example.model.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

public class VistaJuego extends JFrame{

    private static VistaJuego vistaJuego;
    private VistaTablero vistaTablero;


    private VistaJuego(Juego juego) {
        setTitle("Monopoly");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        this.vistaTablero=new VistaTablero(juego.getTablero());
        add(vistaTablero,BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
   public static VistaJuego crearVistaJuego(Juego juego) {
       if (vistaJuego == null) {
           vistaJuego = new VistaJuego(juego);
       }
       return vistaJuego;
   }


    public void mostrarJuego(){
        setVisible(false);
        setVisible(true);
    }


}
