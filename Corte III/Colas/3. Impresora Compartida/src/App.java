// 3. Impresora Compartida (Red de Oficina)
// En una oficina de arquitectura, varias computadoras comparten una única impresora de gran formato. Cada vez que alguien envía un documento, este se agrega al final de la cola de impresión. La impresora procesa los trabajos en el orden exacto en que fueron recibidos.

// La Clase Documento (Nodo): Debe contener nombreArchivo (String), usuario (String), numeroPaginas (int) y esColor (boolean).
// El Problema: Antes de imprimir, el jefe de oficina quiere saber cuántas páginas en total tiene la cola de impresión pendiente.
// Reto: Implementa un método calcularPaginasTotales() que recorra la cola y retorne la suma de numeroPaginas de todos los documentos en espera, sin alterar la cola.

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ColaImpresora cola = new ColaImpresora();
        Scanner scanner = new Scanner(System.in);

        // Datos de prueba
        cola.enqueue(new Documento("plano_piso1.dwg",   "arq_lopez",   12, true));
        cola.enqueue(new Documento("fachada_norte.pdf", "arq_mendoza",  8, true));
        cola.enqueue(new Documento("presupuesto.xlsx",  "admin",        3, false));
        cola.enqueue(new Documento("memoria_calc.docx", "ing_ramos",   20, false));
        cola.enqueue(new Documento("render_3d.png",     "arq_lopez",    1, true));

        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE IMPRESION (ARQUITECTURA) ---");
            System.out.println("1. Ver cola de impresion");
            System.out.println("2. Agregar documento (Enqueue)");
            System.out.println("3. Imprimir siguiente (Dequeue)");
            System.out.println("4. Calcular paginas totales pendientes");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    cola.imprimir();
                    break;
                case 2:
                    System.out.print("Nombre archivo: ");  
                    String arch  = scanner.nextLine();
                    System.out.print("Usuario: ");         
                    String usr   = scanner.nextLine();
                    System.out.print("N paginas: ");       
                    int pags  = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Es color? (s/n): "); 
                    boolean color = scanner.nextLine().equalsIgnoreCase("s");
                    cola.enqueue(new Documento(arch, usr, pags, color));
                    System.out.println("Documento agregado a la cola.");
                    break;
                case 3:
                    Documento d = cola.dequeue();
                    if (d != null) {
                        System.out.println("Imprimiendo: " + d.nombreArchivo +
                                           " (" + d.numeroPaginas + " pgs, usuario: " + d.usuario + ")");
                    }
                    break;
                case 4:
                    System.out.println("Paginas totales en espera: " + cola.calcularPaginasTotales());
                    System.out.println("(La cola no fue modificada)");
                    cola.imprimir();
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
