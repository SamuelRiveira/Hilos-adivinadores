package com.mycompany.hilos.adivinadores;
import java.util.Random;

class Adivinador extends Thread {
    private final NumeroOculto numeroOculto;
    private final int idAdivinador;
    private final int maxNumero;

    // Constructor con tres parámetros
    public Adivinador(NumeroOculto numeroOculto, int idAdivinador, int maxNumero) {
        this.numeroOculto = numeroOculto;
        this.idAdivinador = idAdivinador;
        this.maxNumero = maxNumero;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (!numeroOculto.isJuegoTerminado()) {
            int propuesta = random.nextInt(maxNumero + 1);
            System.out.println("Adivinador " + idAdivinador + " intenta con el número: " + propuesta);
            int resultado = numeroOculto.propuestaNumero(propuesta);

            if (resultado == 1) {
                System.out.println("Adivinador " + idAdivinador + " ha adivinado el número: " + propuesta);
                break;
            } else if (resultado == -1) {
                System.out.println("Adivinador " + idAdivinador + " se ha enterado de que el juego ha terminado.");
                break;
            }
        }
    }
}
