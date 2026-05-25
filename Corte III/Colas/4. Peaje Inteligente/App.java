import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ColaPeaje cola = new ColaPeaje();
        Scanner scanner = new Scanner(System.in);

        // Datos de prueba
        cola.enqueue(new Vehiculo("ABC-123", "Automovil",   5500.0,  false));
        cola.enqueue(new Vehiculo("AMB-001", "Ambulancia",  0.0,     true));
        cola.enqueue(new Vehiculo("XYZ-789", "Camion",     12000.0,  false));
        cola.enqueue(new Vehiculo("PLC-007", "Policia",     0.0,     true));
        cola.enqueue(new Vehiculo("DEF-456", "Motocicleta", 2800.0,  false));
        cola.enqueue(new Vehiculo("GHI-321", "Automovil",  5500.0,   false));

        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE PEAJE INTELIGENTE ---");
            System.out.println("1. Ver carril de vehiculos");
            System.out.println("2. Registrar vehiculo (Enqueue)");
            System.out.println("3. Cobrar siguiente (Dequeue)");
            System.out.println("4. Cerrar turno y ver total recaudado");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    cola.imprimir();
                    break;
                case 2:
                    System.out.print("Placa: ");          String placa = scanner.nextLine();
                    System.out.print("Tipo vehiculo: ");  String tipo  = scanner.nextLine();
                    System.out.print("Tarifa: $");        double tar   = scanner.nextDouble(); scanner.nextLine();
                    System.out.print("Exento? (s/n): ");  boolean ex   = scanner.nextLine().equalsIgnoreCase("s");
                    cola.enqueue(new Vehiculo(placa, tipo, tar, ex));
                    System.out.println("Vehiculo registrado.");
                    break;
                case 3:
                    Vehiculo v = cola.dequeue();
                    if (v != null) {
                        if (v.esExento)
                            System.out.println(v.placa + " pasa sin cobro (exento).");
                        else
                            System.out.printf("%s cobrado: $%.2f%n", v.placa, v.tarifa);
                    }
                    break;
                case 4:
                    cola.cerrarTurno();
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
