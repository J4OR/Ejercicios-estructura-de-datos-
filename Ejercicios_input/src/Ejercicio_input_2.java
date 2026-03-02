// Ejercicio 2 — Conversor de temperatura
// Pide al usuario una temperatura en Celsius y conviértela a Fahrenheit y Kelvin.

// Fórmulas:

// F = (C × 9/5) + 32
// K = C + 273.15
// Dato de entrada: double temperatura en Celsius

import java.util.Scanner;

public class Ejercicio_input_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa la temperatura en Celsius:");
        double c = sc.nextDouble();
        
        double f = (c*9/5) +32;
        double k = c + 273.15;

        System.out.println("=== Conversor de Temperatura ===");
        System.out.println(c + "°C = " + f + " °F");
        System.out.println(c + "°C = " + k + " K");

        sc.close(); 
    }
    
}
