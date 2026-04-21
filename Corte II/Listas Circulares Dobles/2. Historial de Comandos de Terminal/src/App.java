// 2. Historial de Comandos de Terminal
// Los terminales guardan un historial de comandos. Al presionar flecha arriba el usuario retrocede al comando anterior; flecha abajo avanza al más reciente. El historial es circular: después del más antiguo vuelve al más nuevo.

// La Clase Comando (Nodo): Debe contener texto (String), exitoso (boolean — si ejecutó sin errores) y directorio (String — el path desde donde se ejecutó).
// El Problema: El historial mantiene un puntero cursor al comando que se está consultando. Navegar con "arriba" mueve el cursor al anterior (anterior); "abajo" lo mueve al siguiente (siguiente). El usuario puede eliminar el comando actual (para borrar contraseñas escritas por error), y el cursor pasa automáticamente al siguiente.
// Reto: Implementa los métodos arriba(), abajo(), mostrarCursor() y eliminarActual(). Simula: agrega 5 comandos, navega 3 veces hacia arriba, elimina el comando actual, navega una vez hacia abajo y muestra el historial completo con el cursor marcado.

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Historial historial = new Historial();
        int opcion;
        do {
            System.out.println("1. Agregar comando");
            System.out.println("2. Navegar arriba");
            System.out.println("3. Navegar abajo");
            System.out.println("4. Eliminar comando actual");
            System.out.println("5. Mostrar historial");
            System.out.println("6. Mostrar ejemplo simulado");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el comando: ");
                    String texto = scanner.nextLine();
                    System.out.print("¿Fue exitoso? (true/false): ");
                    boolean exitoso = scanner.nextBoolean();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el directorio: ");
                    String directorio = scanner.nextLine();
                    historial.agregarComando(texto, exitoso, directorio);
                    break;
                case 2:
                    historial.arriba();
                    break;
                case 3:
                    historial.abajo();
                    break;
                case 4:
                    historial.eliminarActual();
                    break;
                case 5:
                    historial.mostrarHistorial();
                    break;
                case 6:
                    // Simulación del ejemplo
                    historial.agregarComando("ls -la", true, "/home/user");
                    historial.agregarComando("cd /var", true, "/home/user");
                    historial.agregarComando("cat secret.txt", false, "/home/user");
                    historial.agregarComando("rm secret.txt", true, "/home/user");
                    historial.agregarComando("echo 'Hello World'", true, "/home/user");
                    historial.arriba();
                    historial.arriba();
                    historial.arriba();
                    historial.eliminarActual();
                    historial.abajo();
                    historial.mostrarHistorial();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
        scanner.close();
    }

}
