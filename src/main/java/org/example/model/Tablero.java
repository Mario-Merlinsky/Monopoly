package org.example.model;

import org.example.model.Casilleros.*;

import java.util.*;
import java.util.function.Supplier;

import org.example.model.Casilleros.Casillero;
import org.example.model.Casilleros.CasilleroCarcel;

public class Tablero {

    private List<Casillero> casilleros;
    private int cantCasilleros;
    private int posCarcel;
    private int cantidadPropiedades;
    private List<Barrio> barrios;
    private List<Propiedad> propiedades;

    
    public Tablero(Configuracion config, HashMap<String, Supplier<Casillero>> casilleros){
        this.casilleros = new ArrayList<>();
        this.propiedades = new ArrayList<>();
        this.cantidadPropiedades = config.getCantidadPropiedad();

        paso(config,casilleros);
        loterias(config,casilleros);
        propiedades(config,casilleros);
        estaciones(config,casilleros);
        multas(config,casilleros);
        irCarcel(config,casilleros);
        this.casilleros.add(casilleros.get("Carcel").get());
        Collections.shuffle(this.casilleros, new Random());
        this.casilleros.addFirst(casilleros.get("Partida").get());

        this.cantCasilleros = this.casilleros.size();
        this.barrios = new ArrayList<>();

        int posicion = 0;
        for (Casillero casillero : this.casilleros) {
            if (casillero.getClass() == CasilleroCarcel.class){
                this.posCarcel = this.casilleros.indexOf(casillero);
            }
            casillero.setPosicion(posicion);
            if (casillero.getClass().equals(CasilleroPropiedad.class)){
                ((CasilleroPropiedad) casillero).setPosicionPropiedad(posicion);
                propiedades.add(((CasilleroPropiedad) casillero).getPropiedad());
            }
            posicion++;
        }
        armarBarrios(config.getCantidadIdealPorBarrio(), propiedades, config.getValorPropiedadMinimo());
    }

    public Casillero getCasillero(int i){
        return this.casilleros.get(i);
    }

    public int getCantCasilleros() {
        return cantCasilleros;
    }

    private void paso(Configuracion config, HashMap<String, Supplier<Casillero>> casilleros){
        for (int i = 0; i < config.getCantidadPaso(); i++) {
            this.casilleros.add(casilleros.get("Paso").get());
        }
    }

    private void loterias(Configuracion config, HashMap<String, Supplier<Casillero>> casilleros){
        for (int i = 0; i < config.getCantidadLoteria(); i++) {
            this.casilleros.add(casilleros.get("Loteria").get());
        }
    }

    private void multas(Configuracion config, HashMap<String, Supplier<Casillero>> casilleros){
        for (int i = 0; i < config.getCantidadMulta(); i++) {
            this.casilleros.add(casilleros.get("Multa").get());
        }
    }

    private void propiedades(Configuracion config, HashMap<String, Supplier<Casillero>> casilleros){
        for (int i = 0; i < config.getCantidadPropiedad(); i++) {
            this.casilleros.add(casilleros.get("Propiedad").get());
        }
    }

    private void estaciones(Configuracion config, HashMap<String, Supplier<Casillero>> casilleros){
        for (int i = 0; i < config.getCantidadEstacion(); i++) {
            this.casilleros.add(casilleros.get("Transporte").get());
        }
    }

    private void irCarcel(Configuracion config, HashMap<String, Supplier<Casillero>> casilleros){
        for (int i = 0; i < config.getCantidadIrCarcel(); i++) {
            this.casilleros.add(casilleros.get("Ir Carcel").get());
        }
    }

    public void quitarFicha(Jugador jugador){
        Casillero casillero = casilleros.get(jugador.getPosicion());
        casillero.sacarFicha(jugador.getColor());
    }

    public void armarBarrios(int cantidadIdealBarrio, List<Propiedad> propiedades, int precioMinimoPropiedad) {
        int cantPropiedadesRestantes = this.cantidadPropiedades;
        int numBarrio = 1;
        while((cantPropiedadesRestantes % cantidadIdealBarrio) == 0 || (cantPropiedadesRestantes / (cantidadIdealBarrio*2)) >= 1){
            if (cantPropiedadesRestantes == 0){
                break;
            }
            barrios.addLast(armarBarrioIdeal(propiedades, cantidadIdealBarrio, numBarrio, precioMinimoPropiedad));
            cantPropiedadesRestantes -= cantidadIdealBarrio;
            numBarrio++;
        }
        Barrio barrio1 = new Barrio(numBarrio, precioMinimoPropiedad);
        Barrio barrio2 = new Barrio(numBarrio +1,precioMinimoPropiedad);
        int cantBarrio1 = cantPropiedadesRestantes / 2;
        if (cantPropiedadesRestantes % 2 != 0){
            cantBarrio1++;
        }
        for (Propiedad propiedad: propiedades){
            if (propiedad.getColor() != null){
                continue;
            }
            if (barrio1.getCantidadPropiedades() != cantBarrio1) {
                barrio1.agregarPropiedad(propiedad);
                cantPropiedadesRestantes--;
            }else{
                barrio2.agregarPropiedad(propiedad);
                cantPropiedadesRestantes--;
            }
        }
        barrios.addLast(barrio1);
        barrios.addLast(barrio2);
    }

    private Barrio armarBarrioIdeal(List<Propiedad> propiedades, int cantidadIdealBarrio, int numBarrio,int precioMinimoPropiedad) {
        Barrio barrio = new Barrio(numBarrio,precioMinimoPropiedad);
        for (Propiedad propiedad : propiedades){
            if (cantidadIdealBarrio == 0){
                break;
            }
            if (propiedad.getColor() == null){
                barrio.agregarPropiedad(propiedad);
                cantidadIdealBarrio--;
            }
        }

        return barrio;
    }

    public int getPosCarcel() {
        return posCarcel;
    }

    public void removerPropiedades(Jugador jugador){
        for (Propiedad propiedad: jugador.getPropiedades()){
            propiedad.setCantidadHoteles(0);
            propiedad.setCantidadCasas(0);
            propiedad.deshipotecar();
            propiedad.setPropietario(null);
        }
        for (EstacionTransporte transporte: jugador.getTransporte()){
            transporte.setPropietario(null);
        }
    }

    public List<Propiedad> getPropiedades(){
        return this.propiedades;
    }
}




