// Diseña un sistema para gestionar los vagones de un tren de carga internacional.

// La Clase Vagon (Nodo): Debe contener contenido (String), pesoToneladas (double), origen (String) y destino (String).
// El Problema: El tren sale de una estación y se le van enganchando vagones al final.
// Reto: Implementa un método que recorra el tren y calcule el peso total de toda la carga transportada.

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Tren tren = new Tren();
        int op = 0;

        while (op!=3) {
            System.out.println("====================================");
            System.out.println("           Tren de Carga");
            System.out.println("====================================");
            System.out.println("1. Agregar Vagon");
            System.out.println("2. Calcular Peso Total");
            System.out.println("3. Salir");
            System.out.println("====================================");
            System.out.print("Seleccione una opción: ");
            op = sc.nextInt();
            sc.nextLine(); 

            switch (op) {
                case 1:
                    System.out.println("\n>>>>>> Agregar Vagon <<<<<");
                    System.out.println();
                    System.out.print("Contenido del vagon: ");
                    String contenido = sc.nextLine();
                    System.out.print("Peso del vagon (toneladas): ");
                    double peso = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Origen del vagon: ");
                    String origen = sc.nextLine();
                    System.out.print("Destino del vagon: ");
                    String destino = sc.nextLine();
                    Vagon nuevoVagon = new Vagon(contenido, peso, origen, destino);
                    tren.agregarVagon(nuevoVagon);
                    break;
                case 2:
                    double pesoTotal = tren.calcularPesoTotal();
                    System.out.println("Peso total del tren: " + pesoTotal + " toneladas");
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        sc.close();
    }
}
