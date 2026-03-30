// 5. El Inspector de Eficiencia (Duelo de Métodos)
// Algoritmos obligatorios: Selección vs Inserción

// Contexto: Un analista de sistemas quiere saber cuál algoritmo es más "pesado" en términos de operaciones para un caso específico.
// Detalle del ejercicio: El usuario debe ingresar 6 números enteros desordenados. 
// El programa aplicará AMBOS métodos al mismo conjunto de datos (puedes usar una copia del arreglo original).
// Lógica de Conteo:
// En Selección: Cuenta cada vez que ocurre un swap (intercambio físico de posiciones).
// En Inserción: Cuenta cada vez que un elemento se "mueve" hacia la izquierda dentro del bucle interno.
// Resultado esperado: El programa debe imprimir cuántos intercambios hizo Selección y cuántos movimientos hizo Inserción. 
// El estudiante debe concluir cuál fue más eficiente para esos datos ingresados por el teclado.

import java.util.Scanner;

public class Ejercicio_ordenamiento_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese 6 numeros enteros desordenados:");

        int[] numeros = new int[6];
        int[] seleccion = new int[6];
        int[] insercion = new int[6];

        for (int i = 0; i < 6; i++) {
            numeros[i] = sc.nextInt();
            seleccion[i] = numeros[i];
            insercion[i] = numeros[i];
        }

        // Ordenamiento por Selección
        int swapsSeleccion = 0;
        for (int i = 0; i < seleccion.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < seleccion.length; j++) {
                if (seleccion[j] < seleccion[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = seleccion[i];
                seleccion[i] = seleccion[minIndex];
                seleccion[minIndex] = temp;
                swapsSeleccion++;
            }
        }
        // Ordenamiento por Inserción
        int movimientosInsercion = 0;
        for (int i = 1; i < insercion.length; i++) {
            int key = insercion[i];
            int j = i - 1;
            while (j >= 0 && insercion[j] > key) {
                insercion[j + 1] = insercion[j];
                j--;
                movimientosInsercion++;
            }
            insercion[j + 1] = key;
        }
        System.out.println("Cantidad de intercambios en Selección: " + swapsSeleccion);
        System.out.println("Cantidad de movimientos en Inserción: " + movimientosInsercion);

        if (swapsSeleccion < movimientosInsercion) {
            System.out.println("El método de Selección fue más eficiente para estos datos.");
        } else if (movimientosInsercion < swapsSeleccion) {
            System.out.println("El método de Inserción fue más eficiente para estos datos.");
        } else {
            System.out.println("Ambos métodos tuvieron la misma eficiencia para estos datos.");
        }
        
        sc.close();
    }
}
