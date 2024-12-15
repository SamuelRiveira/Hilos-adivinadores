package com.mycompany.hilos.adivinadores;

import java.util.Random;

public class HilosAdivinadores {

    public static void main(String[] args) {
        NumeroOculto numeroOculto = new NumeroOculto();

        // Crear y ejecutar los hilos adivinadores, en este caso serán 10
        for (int i = 1; i <= 10; i++) {
            new Adivinador(numeroOculto, i, 100).start(); // Max número es 100
        }
    }
}
