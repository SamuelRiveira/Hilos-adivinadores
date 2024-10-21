/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adivinarnumero;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author alumno
 */
public class NumeroOculto {
    private final int numeroOculto;
    private final AtomicBoolean juegoTerminado;

    public NumeroOculto() {
        Random random = new Random();
        this.numeroOculto = random.nextInt(101); // Número entre 0 y 100
        this.juegoTerminado = new AtomicBoolean(false);
    }

    public int propuestaNumero(int num) {
        if (juegoTerminado.get()) {
            return -1; // El juego ya ha terminado
        }

        if (num == numeroOculto) {
            juegoTerminado.set(true);
            return 1; // Número correcto
        }

        return 0; // Número incorrecto, pero el juego continúa
    }

    public boolean isJuegoTerminado() {
        return juegoTerminado.get();
    }

    public int getNumeroOculto() {
        return numeroOculto;
    }
}
