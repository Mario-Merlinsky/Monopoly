package org.example.model.Administradores;


import org.example.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AdministradorPropiedades {
    private static AdministradorPropiedades administradorPropiedades;
    HashMap<Jugador, List<Propiedad>> propiedades;
    private Banco banco;


    private AdministradorPropiedades() {
        super();
        this.propiedades = new HashMap<>();
        this.banco = new Banco();
    }

    public static AdministradorPropiedades crearAdministradorPropiedades() {
        if (administradorPropiedades == null) {
            administradorPropiedades = new AdministradorPropiedades();
        }
        return administradorPropiedades;
    }

    public void comprar(Comprable comprable, Jugador jugador) {
        if (banco.recibirDinero(jugador,comprable.getValor())){
            comprable.comprar(jugador);
            if (!comprable.esPropiedad()) {
                jugador.agregarCantidadDeTransportes((EstacionTransporte) comprable);
            }else {
                jugador.agregarPropiedad((Propiedad) comprable);
                if (!propiedades.containsKey(jugador)){
                    propiedades.put(jugador, new ArrayList<>());
                }
                this.propiedades.get(jugador).add((Propiedad) comprable);
                ((Propiedad) comprable).getBarrio().verificarNuevoPropietario(jugador);
            }
            System.out.println("Compraste la propíedad. Pagaste: " + comprable.getValor() + ". Total de dinero restante: " + jugador.getDinero());
        }else{
            System.out.println("Dinero insuficiente");
        }
    }

    public void pagarAlquier(Comprable comprable,Jugador jugador){
        int monto = 0;
        if (comprable.propietarioPreso()){
            System.out.println("El propietario de la propiedad esta en la carcel, no se cobra renta.");
        } else if(comprable.isHipotecada()){
            System.out.println("La propiedad esta hipotecada, no pagas renta");

        }else if (comprable.getPropietario() != jugador){
            System.out.println("Caiste en una propiedad ajena. Le Pagas la renta a " + comprable.getPropietario().getNombre() + ". Costo: " + comprable.getRenta());
            monto = comprable.getRenta();
            banco.recibirDeuda(jugador, monto);
            banco.darDinero(comprable.getPropietario(), monto);
            System.out.println("Dinero restante: " + jugador.getDinero());
        }else{
            System.out.println("Caiste en tu propiedad. No pagas renta.");
        }
    }

    public void construir(Propiedad propiedadActual, Jugador jugador){

        if (propiedadActual.getBarrio().getPropietario() != jugador){
            System.out.println("Todavia no eres dueño de ese barrio");
            return;
        }
        if (propiedadActual.getCantidadHoteles() == 1){
            System.out.println("No puedes construir, ya tienes un hotel");
            return;
        }
        int cantidadCasasMinimo = 4;
        for (Propiedad propiedad : propiedades.get(jugador)){

            if(propiedad.getBarrio() == propiedadActual.getBarrio()){
                if(propiedad.isHipotecada()){
                    System.out.println("No puedes construir, hay una propiedad del barrio hipotecada");
                    return;
                }
                if (propiedad.getCantidadCasas() < cantidadCasasMinimo && propiedad.getCantidadHoteles() == 0){
                    cantidadCasasMinimo = propiedad.getCantidadCasas();
                }
            }
        }
        if (cantidadCasasMinimo == 4){
            if (banco.recibirDinero(jugador,propiedadActual.getValorCasa())){
                propiedadActual.construirHotel();
                System.out.println("Construiste un hotel en la propiedad. Costo: " + propiedadActual.getBarrio().getCostoHotel() + ". Dinero restante: " + jugador.getDinero());

            }else {
                System.out.println("Dinero insuficiente");
            }
            return;

        }
        if (propiedadActual.getCantidadCasas() == cantidadCasasMinimo ){
            if (banco.recibirDinero(jugador, propiedadActual.getValorCasa())){
                propiedadActual.construirCasa();
                System.out.println("Construiste una casa en la propiedad. Costo: " + propiedadActual.getBarrio().getCostoCasa() + ". Dinero restante: " + jugador.getDinero());
            }else{
                System.out.println("Dinero insuficiente");
            }
        }else {
            System.out.println("No puedes construir en esa propiedad, debes construir en otras primero");
        }
    }

    public void hipotecar(Propiedad propiedad, Jugador jugador){
        if (propiedad.getCantidadCasas() > 0 || propiedad.getCantidadHoteles() > 0){
            System.out.println("No puedes hipotecar la propiedad, tiene construcciones");
            return;
        }
        propiedad.hipotecar();
        banco.darDinero(jugador, propiedad.getPrecioHipotecario());
        System.out.println("Hipotecaste la propiedad. Recibiste: " + propiedad.getPrecioHipotecario() + ". Dinero restante: " + jugador.getDinero());
    }

    public void deshipotecar(Propiedad propiedad, Jugador jugador){
        if (banco.recibirDinero(jugador, propiedad.getPrecioHipotecario())){
            propiedad.deshipotecar();
            System.out.println("Deshipotecaste la propiedad. Pagaste: " + propiedad.getPrecioHipotecario() + ". Dinero restante: " + jugador.getDinero());
        }else{
            System.out.println("Dinero insuficiente");
        }
    }

    public void vender(Propiedad propiedad, Jugador jugador){
        if(propiedad.getCantidadHoteles() == 0){
            if(propiedad.getCantidadCasas() >= 1){
                banco.darDinero(jugador, propiedad.getValorCasa()/2);
                propiedad.demolerCasa();
                System.out.println("Vendiste una casa. Dinero actual: " + jugador.getDinero() + ". Casas restantes: " + propiedad.getCantidadCasas());
            }else{
                System.out.println("No tienes suficientes casas para vender");
            }
        }else{
            banco.darDinero(jugador, (propiedad.getValorHotel()/2) * 5);
            propiedad.demolerHotel();
            System.out.println("Vendiste un hotel por lo que no tienes ninguna construccion. Dinero actual: " + jugador.getDinero());
        }
    }


}







