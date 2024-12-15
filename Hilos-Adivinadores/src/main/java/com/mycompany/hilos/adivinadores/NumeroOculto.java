package com.mycompany.hilos.adivinadores;

import java.util.Random;

public class NumeroOculto {
    private int numeroOculto;
    private boolean adivinado = false;

   
    public NumeroOculto() {
        Random rand = new Random();
        this.numeroOculto = rand.nextInt(101);
        System.out.println("El número oculto ha sido generado.");
    }

    // Método sincronizado para que los hilos propongan números de forma al azar
    public synchronized int propuestaNumero(int num) {
        if (adivinado) {
            return -1; // El juego ya ha terminado
        }
        if (num == numeroOculto) {
            adivinado = true;
            return 1; // Número correcto
        }
        return 0; // Número incorrecto
    }
    
    public boolean isJuegoTerminado() {
        return adivinado;
    }
}
