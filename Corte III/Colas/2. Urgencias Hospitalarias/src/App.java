import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ColaPacientes cola = new ColaPacientes();
        Scanner scanner = new Scanner(System.in);

        // Datos de prueba
        cola.enqueue(new Paciente("1001", "Ana Torres",    32, "Dolor de pecho"));
        cola.enqueue(new Paciente("1002", "Luis Gomez",    45, "Fractura de brazo"));
        cola.enqueue(new Paciente("1003", "Maria Perez",   28, "Fiebre alta"));
        cola.enqueue(new Paciente("1004", "Carlos Ruiz",   60, "Dificultad respiratoria"));
        cola.enqueue(new Paciente("1005", "Sofia Herrera", 19, "Corte profundo"));

        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE TRIAJE (URGENCIAS) ---");
            System.out.println("1. Ver cola de pacientes");
            System.out.println("2. Registrar nuevo paciente (Enqueue)");
            System.out.println("3. Llamar siguiente paciente (Dequeue)");
            System.out.println("4. Atender todos y generar reporte");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    cola.imprimir();
                    break;
                case 2:
                    System.out.print("Cedula: ");          
                    String cedula = scanner.nextLine();
                    System.out.print("Nombre completo: "); 
                    String nombre = scanner.nextLine();
                    System.out.print("Edad: ");            
                    int edad = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Sintoma principal: ");
                    String sintoma = scanner.nextLine();
                    cola.enqueue(new Paciente(cedula, nombre, edad, sintoma));
                    System.out.println("Paciente registrado.");
                    break;
                case 3:
                    Paciente p = cola.dequeue();
                    if (p != null) {
                        System.out.println("Atendiendo a: " + p.nombreCompleto +
                                           " | Sintoma: " + p.sintomaPrincipal);
                    }
                    break;
                case 4:
                    cola.atenderTodos();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 5);
        scanner.close();
    }
}
