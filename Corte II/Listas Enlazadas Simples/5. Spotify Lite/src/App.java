// Crea un reproductor de música simplificado que gestiona una lista de canciones.

// La Clase Cancion (Nodo): Debe contener titulo(String), artista(String), duracionSegundos(int) y genero(String).
// El Problema: El usuario puede agregar canciones "A continuación" (insertar después de la actual) o "Al final de la cola".
// Reto: Implementa un método que sume la duración de todas las canciones y muestre el tiempo total de la lista en formato MM:SS.

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Spotify spotify = new Spotify();
        int op = 0;
        while (op != 4) {
            System.out.println("====================================");
            System.out.println("         Spotify Lite");
            System.out.println("====================================");
            System.out.println("1. Agregar Canción A Continuación");
            System.out.println("2. Agregar Canción Al Final");
            System.out.println("3. Mostrar Canciones");
            System.out.println("4. Salir");
            System.out.println("====================================");
            System.out.print("Seleccione una opción: ");
            op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    System.out.print("Título de la Canción: ");
                    String titulo = sc.nextLine();
                    System.out.print("Artista: ");
                    String artista = sc.nextLine();
                    System.out.print("Duración en Segundos: ");
                    int duracionSegundos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Género: ");
                    String genero = sc.nextLine();
                    Cancion nuevaCancion = new Cancion(titulo, artista, duracionSegundos, genero);
                    spotify.agregarCancion(nuevaCancion);
                    break;
                case 2:
                    System.out.print("Título de la Canción: ");
                    String titulo2 = sc.nextLine();
                    System.out.print("Artista: ");
                    String artista2 = sc.nextLine();
                    System.out.print("Duración en Segundos: ");
                    int duracionSegundos2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Género: ");
                    String genero2 = sc.nextLine();
                    Cancion nuevaCancion2 = new Cancion(titulo2, artista2, duracionSegundos2, genero2);
                    spotify.agregarCancionAlFinal(nuevaCancion2);
                    break;
                case 3:
                    spotify.mostrarCanciones();
                    spotify.sumarDuracionTotal();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        sc.close();
    }
}
