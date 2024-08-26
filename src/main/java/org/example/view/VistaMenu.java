package org.example.view;

import org.example.model.Menu;

public class VistaMenu {
    Menu menu;

    public VistaMenu (Menu menu){
        this.menu = menu;
    }

    public void mostrar(){
        System.out.println("Seleccione una opcion");
        for (int i = 0; i < this.menu.getCantidadOpciones(); i++) {
            System.out.println(this.menu.getOpcion(i));
        }
    }

}



