// 2. Organización de Biblioteca Dinámica
// Algoritmo obligatorio: Ordenamiento por Inserción (Insertion Sort)

// Contexto: Un bibliotecario recibe una caja de libros y los va colocando uno a uno en el estante en su posición correcta.
// Detalle del ejercicio: El usuario debe ingresar la cantidad de libros y luego el código ISBN (número entero) de cada uno.
// Lógica de Inserción: A medida que el usuario ingresa un número, o una vez llenado el arreglo, el algoritmo debe simular
// el proceso de "insertar" el elemento comparándolo con los que ya están a su izquierda.
// Visualización Paso a Paso: En cada ciclo del ordenamiento, el programa debe imprimir cómo va quedando el 
// arreglo (ej: [10, 25, 5, 30] -> [5, 10, 25, 30]). Esto permite al estudiante ver cómo los elementos se desplazan para abrir 
// espacio al nuevo valor.

import java.util.Scanner;

public class Ejercicio_ordenamiento_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de libros: ");
        int n = sc.nextInt();

        int[] libros = new int[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nIngrese el código ISBN del libro " + (i + 1) + ": ");
            int key = sc.nextInt();

            libros[n - 1 - i] = key;
            selectionSort(libros);

            System.out.print("Paso " + (i + 1) + ": [");
            for (int j = 0; j < n; j++) {
                System.out.print(libros[j] + " ");
            }
            System.out.print("]");
            System.out.println();
        }

        System.out.print("\nLibros ordenados: [ ");
        for (int i = 0; i < n; i++) {
            System.out.print(libros[i]);
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        sc.close();
    }
    
    // selection sort
    public static void selectionSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int indiceMinimo = i;

            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }

            // Intercambio
            int temp = arr[indiceMinimo];
            arr[indiceMinimo] = arr[i];
            arr[i] = temp;
        }
    }
}
