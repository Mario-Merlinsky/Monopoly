package org.example.view;

import org.example.model.Casilleros.Casillero;
import org.example.model.Casilleros.*;

public class VistaCasilleroFactory {

    public VistaCasillero crearVistaCasillero(Casillero casillero, int posicion) {
        if (casillero.getClass() == CasilleroPropiedad.class) {
            return new VistaCasilleroPropiedad(casillero, posicion);
        }
        if (casillero.getClass() == CasilleroEstacionTransporte.class) {
            return new VistaCasilleroEstacion(casillero, posicion);
        }
        if (casillero.getClass() == CasilleroLoteria.class) {
            return new VistaCasilleroLoteria(casillero, posicion);
        }
        if (casillero.getClass() == CasilleroCarcel.class) {
            return new VistaCasilleroCarcel(casillero, posicion);
        }
        if (casillero.getClass() == CasilleroLlegadaPartida.class) {
            return new VistaCasilleroLlegadaPartida(casillero, posicion);
        }
        if (casillero.getClass() == CasilleroIrCarcel.class) {
            return new VistaCasilleroIrCarcel(casillero, posicion);
        }
        if (casillero.getClass() == CasilleroMulta.class) {
            return new VistaCasilleroMulta(casillero, posicion);
        } else {
            return new VistaCasilleroPaso(casillero, posicion);
        }
    }
}
