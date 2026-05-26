// 5. Fábrica de Pedidos (E-commerce)
// Una tienda en línea recibe pedidos de manera continua. Cada pedido ingresa a una cola central de procesamiento. El sistema de bodega toma los pedidos en orden de llegada para preparar el envío. Si un pedido ya fue cancelado por el cliente, debe ser descartado automáticamente al momento de ser procesado.

// La Clase Pedido (Nodo): Debe contener numeroPedido (String), cliente (String), totalPagar (double) y cancelado (boolean).
// El Problema: La bodega necesita procesar solo los pedidos vigentes. Los cancelados deben ser eliminados sin ser despachados, pero registrados en un conteo.
// Reto: Implementa un método procesarPedidos() que recorra y vacíe la cola. Para cada pedido: si cancelado = true, lo descarta e incrementa un contador de cancelados; si cancelado = false, lo "despacha" imprimiendo sus datos. Al finalizar, muestra el total despachado y el total cancelado.

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ColaPedidos cola = new ColaPedidos();
        Scanner scanner = new Scanner(System.in);

        cola.enqueue(new Pedido("ORD-001", "Carlos Lopez",  85000.0,  false));
        cola.enqueue(new Pedido("ORD-002", "Diana Vargas", 120000.0,  true));  
        cola.enqueue(new Pedido("ORD-003", "Miguel Torres", 47500.0,  false));
        cola.enqueue(new Pedido("ORD-004", "Sara Nieto",     9900.0,  true));   
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
                    System.out.print("Numero de pedido: ");  
                    String num   = scanner.nextLine();
                    System.out.print("Cliente: ");           
                    String cli   = scanner.nextLine();
                    System.out.print("Total a pagar: $");    
                    double total = scanner.nextDouble(); scanner.nextLine();
                    System.out.print("Cancelado? (s/n): ");  
                    boolean can  = scanner.nextLine().equalsIgnoreCase("s");
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
