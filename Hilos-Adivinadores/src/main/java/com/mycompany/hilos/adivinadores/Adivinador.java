package com.mycompany.hilos.adivinadores;
import java.util.Random;

public class Adivinador extends Thread{
    private NumeroOculto numeroOculto;
    private int id;

    // Constructor que recibe el objeto compartido llamado NumeroOculto y también el identificador del hilo
    public Adivinador(NumeroOculto numeroOculto, int id) {
        this.numeroOculto = numeroOculto;
        this.id = id;
    }

    // Adivinar un número aleatorio hasta que alguno lo adivine
    @Override
    public void run() {
        Random rand = new Random();
        while (true) {
            int intento = rand.nextInt(101);
            int resultado = numeroOculto.propuestaNumero(intento);

            if (resultado == -1) {
                System.out.println("Hilo " + id + ": El juego ya ha terminado");
                break; // Termina el hilo si el número ya fue adivinado por otro hilo
            } else if (resultado == 1) {
                System.out.println("Hilo " + id + ": Adiviné el número era " + intento);
                break; // Termina el hilo si adivinó el número correcto
            } else {
                System.out.println("Hilo " + id + ": Intento con " + intento + " incorrecto");
            }
        }
    }
}
