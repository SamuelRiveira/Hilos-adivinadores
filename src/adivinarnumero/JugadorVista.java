/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adivinarnumero;

/**
 *
 * @author alumno
 */
public class JugadorVista {

    public void mostrarPropuesta(int idJugador, int propuesta, boolean correcto, boolean juegoTerminado) {
        if (juegoTerminado) {
            System.out.println("Jugador " + idJugador + " ha propuesto " + propuesta + ", pero el juego ya terminó.");
        } else if (correcto) {
            System.out.println("Jugador " + idJugador + " ha acertado el número: " + propuesta);
        } else {
            System.out.println("Jugador " + idJugador + " ha propuesto " + propuesta + ", pero no es el número correcto.");
        }
    }
}
