// Ejercicio 8 — Copia real vs referencia
// Pide al usuario 3 calificaciones para llenar notas[]. 
// Crea una copia real en notasRespaldo[] copiando elemento 
// por elemento. Modifica notas[0] con un valor que el usuario ingrese. 
// Muestra ambos arreglos y verifica que notasRespaldo no cambió.

// Datos de entrada: double × 3 notas, double nuevo valor para notas[0]

import java.util.Scanner;

public class Ejercicio_input_8 {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] notas = new double[3];
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Ingresa la nota " + (i + 1) + ":");
            notas[i] = sc.nextDouble();
        }
        double[] notasRespaldo = new double[notas.length];
        for (int i = 0; i < notas.length; i++) {
            notasRespaldo[i] = notas[i];
        }
        System.out.println("Ingrese el nuevo valor para notas[0]:");
        double nuevoValor = sc.nextDouble();
        notas[0] = nuevoValor;

        System.out.println("========== Arreglo Notas ==========");
        for (int i=0; i < notas.length; i++) {
            System.out.println("Notas [" + i + "]: " + notas[i] + " | Respaldo [" + i + "]: " + notasRespaldo[i]);
        }

        sc.close();
    } 
}
