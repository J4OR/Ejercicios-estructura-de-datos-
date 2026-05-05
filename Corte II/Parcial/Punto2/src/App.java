import java.util.Scanner;

public class App {
   public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Editor editor = new Editor();
        int opcion;

        do{
            System.out.println("\n--- Editor de Capas ---");
            System.out.println("1. Agregar capa");
            System.out.println("2. Subir capa");
            System.out.println("3. Bajar capa");
            System.out.println("4. Alternar visibilidad");
            System.out.println("5. Eliminar capa activa");
            System.out.println("6. Mostrar capas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de la capa: ");
                    String nombre = sc.nextLine();
                    System.out.print("¿Visible? (true/false): ");
                    boolean visible = sc.nextBoolean();
                    sc.nextLine(); 
                    editor.agregarCapa(nombre, visible);
                    break;
                case 2:
                    editor.subirCapa();
                    break;
                case 3:
                    editor.bajarCapa();
                    break;
                case 4:
                    editor.toggleVisibilidad();
                    break;
                case 5:
                    editor.eliminarActiva();
                    break;
                case 6:
                    editor.mostrarCapas();
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
