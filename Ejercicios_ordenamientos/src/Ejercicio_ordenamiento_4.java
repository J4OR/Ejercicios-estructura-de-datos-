// 4. Registro Alfabético de Estudiantes
// Algoritmo obligatorio: Ordenamiento por Inserción (Insertion Sort)

// Contexto: El profesor necesita pasar asistencia y requiere que la lista de nombres ingresada en el sistema se ordene 
// alfabéticamente de la A a la Z.
// Detalle del ejercicio: El programa debe preguntar cuántos alumnos hay en clase y solicitar sus nombres (cadenas de texto).
// Lógica de Texto: Se debe usar el método de Inserción adaptado para String.
// Requisito técnico: El estudiante debe investigar y aplicar el método nombre1.compareToIgnoreCase(nombre2). 
// Es vital explicar que si el resultado es mayor a 0, el primer nombre es alfabéticamente "mayor" que el segundo.
// Resultado esperado: La lista de asistencia impresa en orden alfabético perfecto.

import java.util.Scanner;

public class Ejercicio_ordenamiento_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de alumnos: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        String[] alumnos = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese el nombre del alumno " + (i + 1) + ": ");
            alumnos[i] = sc.nextLine();
        }
        insertionSort(alumnos);
        System.out.println("Lista de asistencia ordenada alfabéticamente:");
        for (String alumno : alumnos) {
            System.out.println(alumno);
        }
        sc.close();
    }

    //insertion sort
    public static void insertionSort(String[] arr) {

        int n = arr.length;

        for (int i = 1; i < n; i++) {

            String temp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(temp) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = temp;
        }
    }
}
