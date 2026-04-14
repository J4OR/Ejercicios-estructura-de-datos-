// 2. Carrusel de Anuncios (Pantalla Digital)
// Una tienda tiene una pantalla que muestra anuncios en rotación continua. Cuando termina el último anuncio, vuelve automáticamente al primero.

// La Clase Anuncio (Nodo): Debe contener titulo (String), duracionSegundos (int), vecesRepetido (int) y categoria (String - ej: "Oferta", "Marca", "Evento").
// El Problema: La pantalla necesita saber cuánto tiempo total lleva encendida y cuál es el anuncio que más veces se ha repetido.
// Reto: Implementa el método reproducir(int ciclos) que simule ciclos pasadas completas por todos los anuncios, incrementando vecesRepetido en cada paso e imprimiendo qué anuncio está en pantalla. Al finalizar, muestra el anuncio más repetido y el tiempo total acumulado en pantalla.
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Scanner sc = new Scanner(System.in);
        int opcion;
        Reproductor reproductor = new Reproductor();

        do {
            System.out.println("\n==============================================");
            System.out.println("   Carrusel de Anuncios — Menú Principal");
            System.out.println("==============================================");
            System.out.println("1. agregarAnuncio");
            System.out.println("2. reproducir");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();

            System.out.println();

            switch (opcion) {
                case 1:
                        System.out.print("Ingrese el título del anuncio: ");
                        String titulo = sc.next();
                        System.out.print("Ingrese la duración del anuncio en segundos: ");
                        int duracionSegundos = sc.nextInt();
                        System.out.print("Ingrese la categoría del anuncio (Oferta, Marca, Evento): ");
                        String categoria = sc.next();
                        Anuncio nuevoAnuncio = new Anuncio(titulo, duracionSegundos, categoria);
                        reproductor.agregarAnuncio(nuevoAnuncio);                    
                    break;

                case 2:
                    System.out.print("Ingrese el número de ciclos para reproducir: ");
                    int ciclos = sc.nextInt();
                    reproductor.reproducir(ciclos);
                    break;
                
                case 0:
                    System.out.println("¡Saliendo del carrusel de anuncios!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 3);
        sc.close();
    }
}
