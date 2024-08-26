package org.example.model;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.example.view.VistaMenu;
public class Menu {
    private int cantidadOpciones;
    private Scanner scanner = new Scanner(System.in);
    private List<String> opciones;
    private HashMap<Integer, Runnable> acciones;


    public Menu(List<String> opciones, List<Runnable> funciones) {
        this.opciones = opciones;
        this.acciones = new HashMap<>();
        for (int i = 0; i < funciones.size(); i++) {
            acciones.put(i + 2, funciones.get(i));
        }
        this.cantidadOpciones = opciones.size();
    }

    public Integer SeleccionarOpcion(){
        VistaMenu vistaMenu = new VistaMenu(this);
        vistaMenu.mostrar();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSeleccione una opcion: ");
        String opcion = scanner.nextLine();
        if (verificarStr(opcion)){
            int m = Integer.parseInt(opcion);
            if (m < 1 || m > opciones.size()){
                System.out.println("Opcion no valida");
                return SeleccionarOpcion();
            }
            System.out.println("\nLa opcion seleccionada es: " + m);
            return m;
        }
        System.out.println("Opcion no valida");
        return SeleccionarOpcion();
    }

    public String getOpcion(int i) {
        return opciones.get(i);
    }

    public void realizarAccion(int opcion){
        Runnable accion = this.acciones.get(opcion);
        accion.run();
    }

    public int getCantidadOpciones() {
        return cantidadOpciones;
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

