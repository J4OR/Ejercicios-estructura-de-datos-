import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ColaPedidos cola = new ColaPedidos();
        Scanner scanner = new Scanner(System.in);

        // Datos de prueba — mezcla de vigentes y cancelados
        cola.enqueue(new Pedido("ORD-001", "Carlos Lopez",  85000.0,  false));
        cola.enqueue(new Pedido("ORD-002", "Diana Vargas", 120000.0,  true));   // cancelado
        cola.enqueue(new Pedido("ORD-003", "Miguel Torres", 47500.0,  false));
        cola.enqueue(new Pedido("ORD-004", "Sara Nieto",     9900.0,  true));   // cancelado
        cola.enqueue(new Pedido("ORD-005", "Jhon Castro",  210000.0,  false));
        cola.enqueue(new Pedido("ORD-006", "Paula Ramos",   33000.0,  false));

        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE PEDIDOS (BODEGA) ---");
            System.out.println("1. Ver cola de pedidos");
            System.out.println("2. Agregar pedido (Enqueue)");
            System.out.println("3. Procesar siguiente pedido (Dequeue)");
            System.out.println("4. Procesar todos los pedidos");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    cola.imprimir();
                    break;
                case 2:
                    System.out.print("Numero de pedido: ");  String num   = scanner.nextLine();
                    System.out.print("Cliente: ");           String cli   = scanner.nextLine();
                    System.out.print("Total a pagar: $");    double total = scanner.nextDouble(); scanner.nextLine();
                    System.out.print("Cancelado? (s/n): ");  boolean can  = scanner.nextLine().equalsIgnoreCase("s");
                    cola.enqueue(new Pedido(num, cli, total, can));
                    System.out.println("Pedido registrado en la cola.");
                    break;
                case 3:
                    Pedido p = cola.dequeue();
                    if (p != null) {
                        if (p.cancelado)
                            System.out.println("Pedido " + p.numeroPedido + " descartado (cancelado).");
                        else
                            System.out.printf("Pedido %s despachado a %s — $%.2f%n",
                                              p.numeroPedido, p.cliente, p.totalPagar);
                    }
                    break;
                case 4:
                    cola.procesarPedidos();
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
