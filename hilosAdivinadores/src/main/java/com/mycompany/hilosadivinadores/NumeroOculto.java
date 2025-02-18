package com.mycompany.hilosadivinadores;

import java.util.Random;

class NumeroOculto {
    private final int numeroOculto;
    private boolean juegoTerminado = false;

    public NumeroOculto(int maxNumero) {
        Random random = new Random();
        this.numeroOculto = random.nextInt(maxNumero + 1);
        System.out.println("El número oculto es: " + this.numeroOculto);
    }
    public synchronized int procesarPropuesta(int num, String nombre) {
        if (juegoTerminado) {
            System.out.println(nombre + " se ha enterado de que el juego ha terminado.");
            return -1;
        }
        if (num == numeroOculto) {
            juegoTerminado = true;
            System.out.println(nombre + " ha adivinado el número: " + num);
            return 1;
        }
        return 0;
    }

    public synchronized boolean isJuegoTerminado() {
        return juegoTerminado;
    }
}
