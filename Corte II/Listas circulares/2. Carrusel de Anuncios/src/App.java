// 2. Carrusel de Anuncios (Pantalla Digital)
// Una tienda tiene una pantalla que muestra anuncios en rotación continua. Cuando termina el último anuncio, vuelve automáticamente al primero.

// La Clase Anuncio (Nodo): Debe contener titulo (String), duracionSegundos (int), vecesRepetido (int) y categoria (String - ej: "Oferta", "Marca", "Evento").
// El Problema: La pantalla necesita saber cuánto tiempo total lleva encendida y cuál es el anuncio que más veces se ha repetido.
// Reto: Implementa el método reproducir(int ciclos) que simule ciclos pasadas completas por todos los anuncios, incrementando vecesRepetido en cada paso e imprimiendo qué anuncio está en pantalla. Al finalizar, muestra el anuncio más repetido y el tiempo total acumulado en pantalla.
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Reproductor reproductor = new Reproductor();
        int op;

        do {
            System.out.println("1. Agregar anuncio");
            System.out.println("2. Reproducir anuncios");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            op = sc.nextInt();
            sc.nextLine(); 

            switch (op) {
                case 1:
                    System.out.print("Ingrese el título del anuncio: ");
                    String titulo = sc.nextLine();
                    System.out.print("Ingrese la duración en segundos: ");
                    int duracion = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Ingrese la categoría del anuncio: ");
                    String categoria = sc.nextLine();
                    Anuncio nuevoAnuncio = new Anuncio(titulo, duracion, categoria);
                    reproductor.agregarAnuncio(nuevoAnuncio);
                    break;
                case 2:
                    System.out.print("Ingrese el número de ciclos a reproducir: ");
                    int ciclos = sc.nextInt();
                    reproductor.reproducir(ciclos);
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
