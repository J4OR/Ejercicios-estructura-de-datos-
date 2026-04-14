// El Problema: El planificador debe recorrer la lista circular en bucle. En cada turno, descuenta el quantum del tiempoRestante del proceso actual. Cuando tiempoRestante <= 0, el proceso termina y se elimina de la lista.
// Reto: Implementa el método ejecutar(int quantum) que simule el planificador. Imprime en cada turno cuál proceso se está ejecutando, cuánto tiempo le queda y si terminó. El ciclo debe terminar cuando la lista quede vacía. Al final, imprime el orden en que terminaron los procesos.

public class Planificador {
    Proceso cabeza;
    Proceso cola;

    public void agregarProceso(Proceso proceso) {
        if (cabeza == null) {
            cabeza = proceso;
            cola = proceso;
            proceso.siguiente = proceso; 
        } else {
            cola.siguiente = proceso; 
            proceso.siguiente = cabeza; 
            cola = proceso; 
        }
    }

    public void ejecutar(int quantum) {
        if (cabeza == null) {
            System.out.println("No hay procesos para ejecutar.");
            return;
        }

        Proceso actual = cabeza;
        while (cabeza != null) { 
            System.out.println("Ejecutando proceso: " + actual.nombre + " (PID: " + actual.pid + ")");
            actual.tiempoRestante -= quantum; 

            if (actual.tiempoRestante <= 0) { 
                System.out.println("Proceso " + actual.nombre + " ha terminado.");
                eliminarProceso(actual); 
            } else {
                System.out.println("Tiempo restante del proceso " + actual.nombre + ": " + actual.tiempoRestante);
                actual = actual.siguiente; 
            }
        }
    }

    private void eliminarProceso(Proceso proceso) {
        if (proceso == cabeza && proceso == cola) {
            cabeza = null;
            cola = null;
        } else if (proceso == cabeza) {
            cabeza = cabeza.siguiente;
            cola.siguiente = cabeza; 
        } else if (proceso == cola) { 
            Proceso actual = cabeza;
            while (actual.siguiente != cola) {
                actual = actual.siguiente; 
            }
            actual.siguiente = cabeza;
        }
    }
}