package com.mycompany.hilosadivinadores;

import java.util.Random;

class HiloAdivinador implements Runnable {
    private final NumeroOculto numeroOculto;
    private final int maxNumero;
    private final String nombre;

    public HiloAdivinador(NumeroOculto numeroOculto, String nombre, int maxNumero) {
        this.numeroOculto = numeroOculto;
        this.maxNumero = maxNumero;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (!numeroOculto.isJuegoTerminado()) {
            int propuesta = random.nextInt(maxNumero + 1);
            System.out.println(nombre + " intenta con el número: " + propuesta);
            int resultado = numeroOculto.propuestaNumero(propuesta);

            if (resultado == 1) {
                System.out.println(nombre + " ha adivinado el número: " + propuesta);
                break;
            } else if (resultado == -1) {
                System.out.println(nombre + " se ha enterado de que el juego ha terminado.");
                break;
            }
        }
    }
}