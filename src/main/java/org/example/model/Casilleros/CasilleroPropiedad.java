package org.example.model.Casilleros;

import org.example.model.Administradores.AdministradorPropiedades;
import org.example.model.Jugador;
import org.example.model.Propiedad;

import java.awt.*;
import java.util.HashSet;

public class CasilleroPropiedad extends Casillero{
    private Propiedad propiedad;
    private AdministradorPropiedades administradorPropiedades;


    public CasilleroPropiedad(Propiedad propiedad, AdministradorPropiedades administradorPropiedades){
        this.administradorPropiedades = administradorPropiedades;
        this.propiedad = propiedad;
        this.fichas = new HashSet<>();
        this.color = "Blanco";
    }

    public void pisar(Jugador jugador) {
        System.out.println("Avanzas hasta un casillero de propiedad");
        if (propiedad.getPropietario() == null) {
            if (propiedad.quiereComprar()) {
                administradorPropiedades.comprar(this.propiedad, jugador);
            }
        } else {
            if (propiedad.getPropietario() == jugador) {
                System.out.println("Es tu propiedad, no pagas");
            } else {
                administradorPropiedades.pagarAlquier(this.propiedad, jugador);
            }
        }
    }

    public boolean propiedadHipotecada(){
        return propiedad.isHipotecada();
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public String getColorPropietario() {
        return propiedad.getColorPropietario();
    }

    public Color getColorPropiedad(){
        return propiedad.getColor();
    }

    public int getCantCasasPropiedad(){
        return propiedad.getCantidadCasas();
    }

    public int getCantHotelesPropiedad(){
        return propiedad.getCantidadHoteles();
    }

    public void setPosicionPropiedad(int posicion) {
        propiedad.setPosicion(posicion);
    }

}
