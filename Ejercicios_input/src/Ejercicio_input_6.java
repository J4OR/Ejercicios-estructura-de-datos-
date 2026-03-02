// Ejercicio 6 — Demostración por valor
// Pide al usuario dos números enteros a y b. Asigna b = a, 
// luego pide un nuevo valor para b. Imprime a y b después del cambio 
// y explica con un mensaje en consola por qué a no cambió.

// Datos de entrada: int a, int b (dos veces)

import java.util.Scanner;

public class Ejercicio_input_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor de a:");
        int a = sc.nextInt();
        System.out.println("Ingrese el valor de b:");
        int b = sc.nextInt();
        b = a;
        System.out.println("Ingrese un nuevo valor para b:");
        b = sc.nextInt();
        System.out.println("=== Demostración por valor ===");
        System.out.println(" ");
        System.out.println("Valor de a: " + a);
        System.out.println("Valor de b: " + b);
        System.out.println("");
        System.out.println("Explicacion:");
        System.out.println("los tipos de datos primitivos como int se pasan por valor, lo que significa que cuando asignamos b = a, se copia el valor de a en b. Por lo tanto, cuando cambiamos el valor de b, no afecta a a, ya que son variables independientes con sus propios valores almacenados.");
    
        sc.close();
    }
}
