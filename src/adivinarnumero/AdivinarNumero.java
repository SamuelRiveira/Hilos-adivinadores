/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adivinarnumero;

/**
 *
 * @author alumno
 */
public class AdivinarNumero {
    public static void main(String[] args) {
        NumeroOculto numeroOculto = new NumeroOculto();
        JugadorVista vista = new JugadorVista();

        System.out.println("El número oculto es (para depuración): " + numeroOculto.getNumeroOculto());

        // Crear y comenzar los 10 hilos (jugadores)
        for (int i = 0; i < 10; i++) {
            JugadorControlador jugadorControlador = new JugadorControlador(numeroOculto, vista, i);
            jugadorControlador.start();
        }
    }
}
