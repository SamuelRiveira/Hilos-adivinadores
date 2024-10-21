/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package adivinarnumero;

import java.util.Random;

public class JugadorControlador extends Thread {
    private final NumeroOculto numeroOculto;
    private final JugadorVista vista;
    private final int idJugador;

    // Constructor correcto
    public JugadorControlador(NumeroOculto numeroOculto, JugadorVista vista, int idJugador) {
        this.numeroOculto = numeroOculto;
        this.vista = vista;
        this.idJugador = idJugador;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (!numeroOculto.isJuegoTerminado()) {
            int propuesta = random.nextInt(101); // Proponer un número entre 0 y 100
            int resultado = numeroOculto.propuestaNumero(propuesta);

            if (resultado == 1) {
                vista.mostrarPropuesta(idJugador, propuesta, true, false);
                break;
            } else if (resultado == -1) {
                vista.mostrarPropuesta(idJugador, propuesta, false, true);
                break;
            } else {
                vista.mostrarPropuesta(idJugador, propuesta, false, false);
            }

            // Simular un pequeño retraso entre intentos
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
