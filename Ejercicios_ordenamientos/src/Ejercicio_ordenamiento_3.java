// 3. El Salto de Shell (Optimización de Datos)
// Algoritmo obligatorio: Ordenamiento Shell (Shell Sort)

// Contexto: Una empresa de logística maneja paquetes con diferentes pesos y necesita ordenarlos de forma más 
// eficiente que el método de burbuja o inserción simple.
// Detalle del ejercicio: Solicita al usuario el peso de N paquetes (se recomienda probar con al menos 10 para notar el efecto).
// Lógica de Shell: Implementa el algoritmo usando el salto (gap) inicial de N/2. El estudiante debe explicar en comentarios por qué este método es generalmente más rápido que la inserción simple 
// al trabajar con elementos que están muy lejos de su posición final.
// Resultado esperado: Mostrar el arreglo original y el arreglo final ordenado después de aplicar todas las fases de reducción de saltos.
// 4. Registro Alfabético de Estudiantes

import java.util.Scanner;

public class Ejercicio_ordenamiento_3 {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de paquetes: ");
        int n = sc.nextInt();

        int[] pesos = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el peso del paquete " + (i + 1) + ": ");
            pesos[i] = sc.nextInt();
        }

       
        System.out.print("\nPesos originales: [");
        for (int i = 0; i < n; i++) {
            System.out.print(pesos[i]);
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        // Ordenamiento Shell
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = pesos[i];
                int j;
                for (j = i; j >= gap && pesos[j - gap] > temp; j -= gap) {
                    pesos[j] = pesos[j - gap];
                }
                pesos[j] = temp;
            }
        }
        // Mostrar arreglo ordenado
        System.out.print("\nPesos ordenados: [");
        for (int i = 0; i < n; i++) {
            System.out.print(pesos[i]);
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        sc.close();
    }
}
