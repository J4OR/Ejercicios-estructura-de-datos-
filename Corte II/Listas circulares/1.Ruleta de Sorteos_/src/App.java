/* 1. Ruleta de Sorteos (Sistema de Rifa Digital)
Una empresa organiza una rifa y quiere un sistema que “gire” la rueda de participantes hasta detenerse en un ganador.

La Clase Participante (Nodo): Debe contener nombre (String), numeroBoleta (int) y ciudad (String).
El Problema: Los participantes se registran en orden de llegada formando un ciclo. Para realizar el sorteo, 
el sistema avanza un número aleatorio de posiciones desde la cabeza y el participante en el que se detiene es el ganador.
Reto: Implementa el método realizarSorteo(int pasos) que avance pasos posiciones desde la cabeza y muestre 
el nombre y número de boleta del participante seleccionado. Luego, elimina al ganador de la lista para que no 
pueda ganar de nuevo, y muestra la lista actualizada. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Proceso p = new Proceso("Proceso1", 1, 10, 2);
        System.out.println("Nombre: " + p.nombre);
    }
}
