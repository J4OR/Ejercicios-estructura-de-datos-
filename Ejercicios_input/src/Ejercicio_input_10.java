// Ejercicio 10 — Intercambio de valores
// Pide dos números enteros x e y. Intercambia sus valores usando una variable auxiliar temp.
//  Muestra los valores antes y después del intercambio.

// Datos de entrada: int x, int y

import java.util.Scanner;
public class Ejercicio_input_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el primer número:");
        int x = sc.nextInt();
        System.out.println("Ingrese el segundo número:");
        int y = sc.nextInt();
        System.out.println("Valores antes del intercambio: x = " + x + ", y = " + y);
        int temp = x;
        x = y;
        y = temp;
        System.out.println("Valores después del intercambio: x = " + x + ", y = " + y);
        sc.close();
    }
}
