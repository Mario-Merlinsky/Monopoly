package org.example.model.Casilleros;

import org.example.model.Jugador;

import java.util.HashSet;

    public class CasilleroPaso extends Casillero {

        public CasilleroPaso() {
            this.color = "Rosa";
            this.fichas = new HashSet<>();

        }

        public void pisar(Jugador jugador){
            System.out.println("Avanzas hasta un casillero de paso");
        }
    }

