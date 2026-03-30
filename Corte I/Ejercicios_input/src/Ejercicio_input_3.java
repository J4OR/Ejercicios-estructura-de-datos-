// Ejercicio 3 — Promedio de notas
// Pide al usuario su nombre y 4 notas de un curso. Calcula el promedio y determina si aprobó (promedio >= 3.0).

// Datos de entrada:

// String nombre

import java.util.Scanner;

public class Ejercicio_input_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nombre:");
        String nombre = sc.nextLine();
        System.out.println("Ingresa la nota 1:");
        double nota1 = sc.nextDouble();
        System.out.println("Ingresa la nota 2:");
        double nota2 = sc.nextDouble();
        System.out.println("Ingresa la nota 3:");
        double nota3 = sc.nextDouble();
        System.out.println("Ingresa la nota 4:");
        double nota4 = sc.nextDouble();
        double promedio = (nota1 + nota2 + nota3 + nota4) / 4;
    
        System.out.println("=== Promedio de Notas ===");
        System.out.println("Nombre  : " + nombre);
        System.out.println("Promedio: " + promedio);
        System.out.println("Estado: " + (promedio >= 3.0 ? "Aprobado" : "Reprobado"));

        sc.close();
    }    
}
