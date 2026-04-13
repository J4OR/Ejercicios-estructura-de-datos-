// // 2. Carrusel de Imágenes (Galería Interactiva)
// Simula el comportamiento de una galería de fotos en una aplicación móvil.

// La Clase Fotografia (Nodo): Debe contener nombreArchivo(String), tamanoMB(double) y resolucion(String).
// El Problema: El usuario puede avanzar a la "Foto Siguiente" o retroceder a la "Foto Anterior". Si llega al final, no puede avanzar más (a menos que sea circular, pero por ahora manténlo lineal).
// Reto: Crea un método reproducirGaleria()que recorra toda la lista hacia adelante y luego toda la lista hacia atrás para mostrar todas las fotos.

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Galeria galeria = new Galeria();
        int op ;
        do {
            System.out.println("1. Agregar Foto");
            System.out.println("2. Reproducir Galería");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            op = sc.nextInt();
            sc.nextLine(); 

            switch (op) {
                case 1:
                    System.out.print("Ingrese el nombre del archivo: ");
                    String nombreArchivo = sc.nextLine();
                    System.out.print("Ingrese el tamaño en MB: ");
                    double tamanoMB = sc.nextDouble();
                    sc.nextLine(); 
                    System.out.print("Ingrese la resolución: ");
                    String resolucion = sc.nextLine();
                    galeria.agregarFoto(nombreArchivo, tamanoMB, resolucion);
                    break;
                case 2:
                    galeria.reproducirGaleria();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (op != 3);
        sc.close();
    }
}
