// 1. Sistema de Control de Versiones (Undo/Redo)
// Diseña un editor de texto muy simple que guarde el historial de cambios.

// La Clase Cambio (Nodo): Debe contener texto (String) y tipoOperacion (String - ej: "Escribir", "Borrar").
// El Problema: Cada vez que el usuario escribe algo, se agrega un nodo al final. El usuario puede deshacer (retroceder al nodo anterior) y rehacer (avanzar al nodo siguiente).
// Reto: Implementa métodos deshacer() y rehacer() que muevan un puntero actual a través de la lista doble.

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Historial historial = new Historial();
        Cambio cambioActual = null;
        int op=0;

        while (op!=4) {
            System.out.println("\n==============================================");
            System.out.println("   Historial de Cambios — Menú Principal");
            System.out.println("==============================================");
            System.out.println("  [1] Agregar Cambio");
            System.out.println("  [2] Deshacer Cambio");
            System.out.println("  [3] Rehacer Cambio");
            System.out.println();
            System.out.println("  [0] Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opción: ");
            op = sc.nextInt();
            sc.nextLine(); 

            switch (op) {
                case 1:
                    System.out.print("Introduce el texto del cambio: ");
                    String texto = sc.nextLine();
                    System.out.print("Introduce el tipo de operación: ");
                    String tipoOperacion = sc.nextLine();
                    Cambio cambio = new Cambio(texto, tipoOperacion);
                    historial.agregarCambio(cambio);
                    cambioActual = cambio;
                    break;
                case 2:
                    System.out.println("El cambio actual es: " + cambioActual.texto);
                    break;
                case 3:
                    cambioActual = historial.rehacer(cambioActual);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción válida.");
            }
        }
        sc.close();
    }
}
