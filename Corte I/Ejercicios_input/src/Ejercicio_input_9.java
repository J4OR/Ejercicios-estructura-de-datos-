// Ejercicio 9 — String inmutable
// Pide al usuario su nombre. Asigna alias = nombre. Pide un nuevo alias.
//  Muestra que nombre no cambió y explica la inmutabilidad de String con un mensaje en consola.

// Datos de entrada: String nombre, String nuevo alias
import java.util.Scanner;

public class Ejercicio_input_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nombre:");
        String nombre = sc.nextLine();
        String alias = nombre;
        System.out.println("Ingrese un nuevo alias:");
        String nuevoAlias = sc.nextLine();
        System.out.println("Nombre original: " + nombre);
        System.out.println("Alias original: " + alias);
        System.out.println("Nuevo alias: " + nuevoAlias);

        sc.close();
    }
}
