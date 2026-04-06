// Una planta química registra lecturas de sus tanques cada hora en una lista enlazada para auditoría.

// La Clase Lectura (Nodo): Debe contener idSensor(int), temperatura(double), presion(double) y hora(String).
// El Problema: Las lecturas se van agregando al inicio para que la más reciente sea siempre la primera que vea el supervisor.
// Reto: Implemente un método que busque y muestre la lectura con la temperatura más alta registrada en el historial.

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Sensor sensor = new Sensor();
        int op = 0;

        while (op!=3) {
            System.out.println("====================================");
            System.out.println("       Monitoreo Industrial");
            System.out.println("====================================");
            System.out.println("1. Agregar Lectura");
            System.out.println("2. Mostrar Lectura Más Alta");
            System.out.println("3. Salir");
            System.out.println("====================================");
            System.out.print("Seleccione una opción: ");
            op = sc.nextInt();
            sc.nextLine(); 

            switch (op) {
                case 1:
                    System.out.print("ID del Sensor: ");
                    int idSensor = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Temperatura: ");
                    double temperatura = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Presión: ");
                    double presion = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Hora (HH:mm): ");
                    String hora = sc.nextLine();
                    Lectura nuevaLectura = new Lectura(idSensor, temperatura, presion, hora);
                    sensor.agrgarLectura(nuevaLectura);
                    break;
                case 2:
                    System.out.println("\nBuscando lectura con la temperatura más alta...");
                    sensor.lecturaMasAlta();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
            
        
    }    
}
