// 3. Planificador de CPU (Algoritmo Round Robin)
// Los sistemas operativos usan el algoritmo Round Robin para repartir el tiempo del procesador entre varios procesos de forma justa: cada proceso recibe un pequeño intervalo de tiempo llamado quantum. Si no termina, espera su siguiente turno.

// La Clase Proceso (Nodo): Debe contener nombre (String), pid (int), tiempoRestante (int) y prioridad (int - del 1 al 3).
// El Problema: El planificador debe recorrer la lista circular en bucle. En cada turno, descuenta el quantum del tiempoRestante del proceso actual. Cuando tiempoRestante <= 0, el proceso termina y se elimina de la lista.
// Reto: Implementa el método ejecutar(int quantum) que simule el planificador. Imprime en cada turno cuál proceso se está ejecutando, cuánto tiempo le queda y si terminó. El ciclo debe terminar cuando la lista quede vacía. Al final, imprime el orden en que terminaron los procesos.

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Planificador planificador = new Planificador();
        int op;
        do {
            System.out.println("1. Agregar proceso");
            System.out.println("2. Ejecutar planificador");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            op = sc.nextInt();
            sc.nextLine(); 

            switch (op) {
                case 1:
                    System.out.print("Nombre del proceso: ");
                    String nombre = sc.nextLine();
                    System.out.print("PID del proceso: ");
                    int pid = sc.nextInt();
                    System.out.print("Tiempo restante del proceso: ");
                    int tiempoRestante = sc.nextInt();
                    System.out.print("Prioridad del proceso (1-3): ");
                    int prioridad = sc.nextInt();
                    sc.nextLine();
                    Proceso nuevoProceso = new Proceso(nombre, pid, tiempoRestante, prioridad);
                    planificador.agregarProceso(nuevoProceso);
                    break;
                case 2:
                    System.out.print("Ingrese el quantum de tiempo: ");
                    int quantum = sc.nextInt();
                    planificador.ejecutar(quantum);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (op != 3);
        sc.close();
    }
}
