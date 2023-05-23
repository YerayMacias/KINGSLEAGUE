package org.example.Modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class tJugadoresTest {

    @Test
    void main() {

    }

    /*******TEST PARA INSERTAR*********/
    Jugador jugador = new Jugador("koldo", "san juan",
            "87654321Z", Jugador.tPosicion.MC, Jugador.tTipoJugador.HABITUAL);
    @Test
    void testInsertar() throws Exception {
        assertEquals(1, tJugadores.insert(jugador));
    }

    /**********TEST PARA SELECCIONAR POR DNI**********/
    Jugador jugadorDni = new Jugador("87654321Z");
    @Test
    void testSeleccionarPorDni() throws Exception {
        assertEquals(jugadorDni.getDNI(), tJugadores.buscarPorDNI(jugadorDni).getDNI());
    }

    /*********TEST PARA BORRAR***********/

    Jugador jugadorBorrar = new Jugador("87654321Z");
    @Test
    void testBorrarPorDni() throws Exception {
        assertEquals(1, tJugadores.delete(jugadorBorrar));
    }

    /**********TEST PARA ACTUALIZAR***********/

    Jugador jugadorUpdate = new Jugador("jose", "juan carlos", "87654321Z", Jugador.tPosicion.DC, Jugador.tTipoJugador.WILDCARD);
    @Test
    void testActualizarPorDNI() throws Exception {
        assertEquals(1, tJugadores.update(jugadorUpdate));
    }

}