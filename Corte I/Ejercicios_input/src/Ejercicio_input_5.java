// Ejercicio 5 — Calculadora de IMC
// Pide nombre, peso en kg y altura en metros. Calcula el IMC y clasifícalo.

// Fórmula: IMC = peso / (altura × altura)

// Clasificación:

// IMC < 18.5 → Bajo peso
// 18.5 ≤ IMC < 25 → Normal
// 25 ≤ IMC < 30 → Sobrepeso
// IMC ≥ 30 → Obesidad
// Datos de entrada: String nombre, double peso, double altura

import java.util.Scanner;

public class Ejercicio_input_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nombre:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese su peso en kg:");
        double peso = sc.nextDouble();
        System.out.println("Ingrese su altura en metros:");
        double altura = sc.nextDouble();
        
        double imc = peso / (altura * altura);
        String clasificacion;

        if (imc < 18.5) {
            clasificacion = "Bajo peso";
        } else if (imc < 25) {
            clasificacion = "Normal";
        } else if (imc < 30) {
            clasificacion = "Sobrepeso";
        } else {
            clasificacion = "Obesidad";
        }
        System.out.println("=== Calculadora de IMC ===");
        System.out.println("Nombre       : " + nombre);
        System.out.println("Peso         : " + peso + " kg");
        System.out.println("Altura       : " + altura + " m");
        System.out.println("IMC          : " + imc);
        System.out.println("Clasificación: " + clasificacion);

        sc.close();

    }
}
