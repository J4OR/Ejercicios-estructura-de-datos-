// Simula la cola de aviones esperando para aterrizar en un aeropuerto congestionado.

// La Clase Vuelo (Nodo): Debe contener numeroVuelo (String), aerolinea (String), combustibleRestante (int) y pasajeros (int).
// El Problema: Normalmente los vuelos se forman al final de la cola. Sin embargo, si un vuelo reporta menos de 10 unidades de combustible, debe ser movido inmediatamente al inicio de la lista (Cabeza).
// Reto: Implementar el método reportarEmergencia(String numeroVuelo) que busque un vuelo en la cola y lo mueva al principio.

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Torre torre = new Torre();
        int op = 0;
        while (op != 4) {
            System.out.println("====================================");
            System.out.println("        Inventario de alimentos");
            System.out.println("====================================");
            System.out.println("1. Agregar vuelo");
            System.out.println("2. Reportar emergencia");
            System.out.println("3. Mostrar cola de vuelos");
            System.out.println("4. Salir");
            System.out.println("====================================");
            System.out.println("Seleccione una opción: ");
            op = sc.nextInt();
            sc.nextLine(); 

            switch (op) {
                case 1:
                    
                     System.out.print("Número de vuelo: ");
                    String numeroVuelo = sc.nextLine();
                    System.out.print("Aerolínea: ");
                    String aerolinea = sc.nextLine();
                    System.out.print("Combustible restante: ");
                    int combustibleRestante = sc.nextInt();
                    System.out.print("Número de pasajeros: ");
                    int pasajeros = sc.nextInt();
                    sc.nextLine();
                    Vuelo nuevoVuelo = new Vuelo(numeroVuelo, aerolinea, combustibleRestante, pasajeros);
                    torre.agregarVuelo(nuevoVuelo);
                    System.out.println("Vuelo agregado: " + numeroVuelo);
                    break;
                case 2:
                    System.out.print("Número de vuelo a reportar emergencia: ");
                    String vueloEmergencia = sc.nextLine();
                    torre.reportarEmergencia(vueloEmergencia);
                    break;
                case 3:
                    torre.mostrarColaVuelos();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }
}
