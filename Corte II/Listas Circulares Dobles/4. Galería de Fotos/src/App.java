// 4. Galería de Fotos
// Una app de galería muestra las fotos de un álbum de una en una. El usuario puede pasar a la foto siguiente, volver a la anterior, y marcar cualquier foto como favorita. Al eliminar una foto, la galería continúa desde la siguiente sin interrupciones.

// La Clase Foto (Nodo): Debe contener titulo (String), fecha (String) y esFavorita (boolean).
// El Problema: La galería mantiene un puntero actual a la foto que se está viendo. Navegar con "siguiente" o "anterior" mueve ese puntero. Marcar como favorita simplemente alterna el campo esFavorita de la foto actual. Eliminar la foto actual desconecta el nodo en O(1) y mueve actual a la siguiente.
// Reto: Implementa los métodos siguiente(), anterior(), toggleFavorita(), eliminarActual() y mostrarGaleria(). mostrarGaleria() recorre todas las fotos marcando con [★] las favoritas y con [▶] la foto actual. Simula: carga 5 fotos, avanza dos veces, marca la actual como favorita, retrocede una, elimina esa foto y muestra el estado final de la galería.

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Galeria galeria = new Galeria();
        int opcion;

        do {
            System.out.println("\n----Galería de Fotos------");
            System.out.println("1. Agregar Foto");
            System.out.println("2. Siguiente Foto");
            System.out.println("3. Foto Anterior");
            System.out.println("4. Marcar/Desmarcar Favorita");
            System.out.println("5. Eliminar Foto Actual");
            System.out.println("6. Mostrar Galería");
            System.out.println("7. Simulación Completa");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Título de la foto: ");
                    String titulo = sc.nextLine();
                    System.out.print("Fecha de la foto: ");
                    String fecha = sc.nextLine();
                    galeria.agregarFoto(titulo, fecha);
                    System.out.println("Foto agregada.");
                    break;
                case 2:
                    System.out.println();
                    galeria.siguiente();
                    break;
                case 3:
                    System.out.println();
                    galeria.anterior();
                    break;
                case 4:
                    System.out.println();
                    galeria.toggleFavorita();
                    break;
                case 5:
                    System.out.println();
                    galeria.eliminarActual();
                    break;
                case 6:
                    System.out.println();
                    galeria.mostrarGaleria();
                    break;
                case 7:
                    // Simulación Completa
                    galeria.agregarFoto("Foto1", "2024-01-01");
                    galeria.agregarFoto("Foto2", "2024-01-02");
                    galeria.agregarFoto("Foto3", "2024-01-03");
                    galeria.agregarFoto("Foto4", "2024-01-04");
                    galeria.agregarFoto("Foto5", "2024-01-05");

                    galeria.siguiente();
                    galeria.siguiente();
                    galeria.toggleFavorita();
                    galeria.anterior();
                    galeria.eliminarActual();
                    galeria.mostrarGaleria();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
        sc.close();
    }
}
