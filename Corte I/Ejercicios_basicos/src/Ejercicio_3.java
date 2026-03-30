// Ejercicio 3 — Sensor de temperatura
// Un sensor industrial registra temperaturas. El sistema recibe:

// Temperatura actual en Celsius (double)
// Nombre del sensor (String)
// Número de lectura (int)
// Si la temperatura supera el límite de 80°C, una variable boolean llamada enAlarma debe ser true.
// Imprime el estado del sensor con todos sus datos.

import java.util.Scanner;

public class Ejercicio_3 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        double temperaturaCelsius;
        String nombreSensor;
        int numeroLectura;
        boolean alarma;

        System.out.println("Ingrese el nombre del sensor: ");
        nombreSensor = sc.nextLine();
        System.out.println("Ingrese la temperatura en Celsius: ");
        temperaturaCelsius = sc.nextDouble();
        System.out.println("Ingrese el número de lectura: ");
        numeroLectura = sc.nextInt();
       
        if (temperaturaCelsius > 80) {
            alarma = true;
        } else {
            alarma = false;
        }

        System.out.println("Temperatura: " + temperaturaCelsius);
        System.out.println("Nombre del sensor: " + nombreSensor);
        System.out.println("Número de lectura: " + numeroLectura);
        System.out.println("¿Hay alarma?: " + alarma);
        sc.close();
    }
}
