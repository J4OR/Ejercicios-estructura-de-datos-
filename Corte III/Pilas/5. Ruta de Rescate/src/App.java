// Un equipo de rescatistas entra en una cueva inexplorada. Para no perderse, van dejando "Estaciones de Seguridad" representadas por una baliza que registra los datos del entorno.

// La Clase Estacion (Nodo): Debe contener nombrePunto (String), profundidad (int) y nivelOxigeno (double).
// El Problema: Para salir de la cueva, el equipo debe seguir las estaciones en el orden inverso al que fueron colocadas (de la más profunda a la entrada).
// Reto: Implementa el método retrocederASuperficie(). Este debe mostrar el nombre de cada estación a medida que se desapila. Importante: Si en alguna estación el nivelOxigeno es inferior al 18%, el sistema debe imprimir una alerta de "Uso de Tanque de Emergencia Requerido" al pasar por ese punto.

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        PilaEstaciones cueva = new PilaEstaciones();

        Scanner scanner = new Scanner(System.in);

        // Datos de prueba
        cueva.push(new Estacion("Entrada Norte", 10, 21.0));
        cueva.push(new Estacion("Galería Oscura", 30, 19.5));
        cueva.push(new Estacion("Pozo Profundo", 50, 16.2));
        cueva.push(new Estacion("Cámara Rocosa", 70, 14.8));

        int opcion;

        do {

            System.out.println("\n--- SISTEMA DE RESCATE EN CUEVA ---");
            System.out.println("1. Ver estaciones");
            System.out.println("2. Agregar estación");
            System.out.println("3. Retirar estación");
            System.out.println("4. Retroceder a superficie");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    cueva.imprimir();
                    break;

                case 2:

                    System.out.print("Nombre del punto: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Profundidad: ");
                    int profundidad = scanner.nextInt();

                    System.out.print("Nivel de oxígeno: ");
                    double oxigeno = scanner.nextDouble();

                    cueva.push(new Estacion(nombre,profundidad, oxigeno));

                    System.out.println("Estación agregada.");
                    break;

                case 3:

                    Estacion eliminada = cueva.pop();

                    if (eliminada != null) {
                        System.out.println("Estación retirada: " + eliminada);
                    }

                    break;

                case 4:

                    cueva.retrocederASuperficie();
                    break;

                case 5:

                    System.out.println("Saliendo del sistema...");
                    break;

                default:

                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}

