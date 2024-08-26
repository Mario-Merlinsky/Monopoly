package org.example.model;

import org.example.model.Administradores.AdministradorPropiedades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;



public class Jugador {

    private String color;
    private String nombre;
    private Integer dinero;
    private Integer posicion;
    private Estado estado;
    private HashMap<Integer, Propiedad> propiedades;
    private List<EstacionTransporte> transporte;



    public Jugador (String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
        this.dinero = 0;
        this.posicion = 0;
        this.propiedades = new HashMap<Integer, Propiedad>();
        this.transporte = new ArrayList<>();
    }

    public void mover(int posiciones){
        this.estado.mover(posiciones, this);
    }

    public void mostrarOpciones(){
        this.estado.mostrarOpciones(this);
    }

    public void agregarPropiedad(Propiedad propiedad){

        this.propiedades.put(propiedad.getPosicion() + 1, propiedad);
    }

    public void agregarCantidadDeTransportes(EstacionTransporte estacion) {
        this.transporte.add(estacion);
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getDinero() {
        return dinero;
    }

    public String getColor(){
        return this.color;
    }

    public Integer getPosicion() { return this.posicion; }

    public boolean estaPreso(){
        return this.estado instanceof Preso;
    }

    public List<Propiedad> getPropiedades() {
        return new ArrayList<>(propiedades.values());
    }

    public List<EstacionTransporte> getTransporte() {
        return transporte;
    }

    public int getCantPropiedades() {
        return propiedades.size();
    }

    public Integer getCantidadTransporte() {
        return transporte.size();
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public void setDinero(Integer dinero) {
        this.dinero = dinero;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void construir() {
        realizarAccion("construir");
    }

    public void hipotecar(){
        realizarAccion("hipotecar");
    }

    public void deshipotecar(){
        realizarAccion("deshipotecar");
    }

    public void venderPropiedad(){
        realizarAccion("vender");
    }

    private void realizarAccion(String accion) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elija la posicion de la propiedad sobre la que quiere " + accion + ": ");
        String respuesta = scanner.nextLine();
        if (verificarStr(respuesta)) {
            int posicion = Integer.parseInt(respuesta);
            if (propiedades.containsKey(posicion)) {
                Propiedad propiedad = propiedades.get(posicion);
                AdministradorPropiedades administradorPropiedades = AdministradorPropiedades.crearAdministradorPropiedades();
                switch (accion) {
                    case "construir":
                        if (!propiedad.isHipotecada()) {
                            administradorPropiedades.construir(propiedad, this);
                        } else {
                            System.out.println("La propiedad esta hipotecada, no se puede construir");
                        }
                        break;
                    case "hipotecar":
                        if (!propiedad.isHipotecada()) {
                            administradorPropiedades.hipotecar(propiedad, this);
                        } else {
                            System.out.println("La propiedad ya esta hipotecada");
                        }
                        break;
                    case "deshipotecar":
                        if (propiedad.isHipotecada()) {
                            administradorPropiedades.deshipotecar(propiedad, this);
                        } else {
                            System.out.println("La propiedad no esta hipotecada");
                        }
                        break;
                    case "vender":
                        if (!propiedad.isHipotecada()) {
                            administradorPropiedades.vender(propiedad, this);
                        } else {
                            System.out.println("No puede vender construcciones, la propiedad esta hipotecada");
                        }
                        break;
                }
            } else {
                System.out.println("No posee una propiedad en esa posicion o la posicion es invalida");
            }
        } else {
            System.out.println("Respuesta no valida");
            realizarAccion(accion);
        }
    }

    private boolean verificarStr(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}




