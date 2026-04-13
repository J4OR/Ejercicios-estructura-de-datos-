// 3. Navegación de Pestañas de Navegador
// Imagina un navegador donde puedes moverte entre pestañas abiertas.

// La Clase Pestana (Nodo): Debe contener tituloPagina (String), url (String) y horaApertura (String).
// El Problema: Las pestañas se abren una tras otra. A veces el usuario quiere cerrar la pestaña actual y el foco debe pasar a la pestaña anterior.
// Reto: Implementar el método cerrarPestanaActual(String url) que busque la pestaña por URL, la elimine de la lista y reconecte el nodo anterior con el siguiente correctamente (¡Cuidado con la Cabeza y la Cola!).

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Navegador navegador = new Navegador();
        int op ;
        do {
            System.out.println("\n--- Navegador de Pestañas ---");
            System.out.println("1. Abrir Pestaña");
            System.out.println("2. Cerrar Pestaña Actual");     
            System.out.println("3. mostrar Pestañas");
            System.out.println("4. Salir");
            System.out.println("---------------------------");
            System.out.print("Seleccione una opción: ");
            op = sc.nextInt();
            sc.nextLine();
            System.out.println("");
            switch (op) {
                case 1:
                    System.out.print("Ingrese el título de la página: ");
                    String tituloPagina = sc.nextLine();
                    System.out.print("Ingrese la URL: ");
                    String url = sc.nextLine();
                    System.out.print("Ingrese la hora de apertura: ");
                    String horaApertura = sc.nextLine();
                    Pestana pestana = new Pestana(tituloPagina, url, horaApertura);
                    navegador.abrirPestana(pestana);
                    break;
                case 2:
                    System.out.print("Ingrese la URL de la pestaña a cerrar: ");
                    String urlCerrar = sc.nextLine();
                    navegador.cerrarPestanaActual(urlCerrar);
                    break;
                case 3:
                    navegador.mostrarPestanas();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

        }while (op != 4);

            sc.close();
    } 
}   

