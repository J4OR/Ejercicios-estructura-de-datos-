public class ColaPeaje {
    private Vehiculo salida;
    private Vehiculo entrada;
    private int tamanio;

    public ColaPeaje() {
        this.salida  = null;
        this.entrada = null;
        this.tamanio = 0;
    }

    public boolean isEmpty() {
        return salida == null;
    }

    public int size() {
        return tamanio;
    }

    public Vehiculo peek() {
        if (isEmpty()) {
            System.out.println("Carril vacío — no hay vehículos.");
            return null;
        }
        return salida;
    }

    public void enqueue(Vehiculo vehiculo) {
        if (isEmpty()) {
            salida  = vehiculo;
            entrada = vehiculo;
        } else {
            entrada.siguiente = vehiculo;
            entrada = vehiculo;
        }
        tamanio++;
    }

    public Vehiculo dequeue() {
        if (isEmpty()) {
            System.out.println("Carril vacío.");
            return null;
        }
        Vehiculo dato = salida;
        salida = salida.siguiente;
        if (salida == null) entrada = null;
        tamanio--;
        return dato;
    }

    public void imprimir() {
        if (isEmpty()) {
            System.out.println("[ Carril vacío ]");
            return;
        }
        System.out.print("SALIDA -> ");
        Vehiculo actual = salida;
        while (actual != null) {
            System.out.print("[" + actual.placa +
                             " | $" + actual.tarifa +
                             (actual.esExento ? " EXENTO" : "") + "]");
            if (actual.siguiente != null) System.out.print(" -> ");
            actual = actual.siguiente;
        }
        System.out.println(" -> ENTRADA");
    }

    
    public void cerrarTurno() {
        if (isEmpty()) {
            System.out.println("No hay vehículos en el carril.");
            return;
        }
        double totalRecaudado = 0.0;
        int vehiculosCobrados = 0;
        int vehiculosExentos  = 0;

        System.out.println("\n========== CIERRE DE TURNO ==========");
        while (!isEmpty()) {
            Vehiculo v = dequeue();
            if (v.esExento) {
                System.out.println("  EXENTO  -> " + v.placa +
                                   " (" + v.tipoVehiculo + ") — sin cobro");
                vehiculosExentos++;
            } else {
                System.out.printf("  COBRADO -> %s (%s) — $%.2f%n",
                                  v.placa, v.tipoVehiculo, v.tarifa);
                totalRecaudado += v.tarifa;
                vehiculosCobrados++;
            }
        }
        System.out.println("=====================================");
        System.out.println("Vehiculos cobrados : " + vehiculosCobrados);
        System.out.println("Vehiculos exentos  : " + vehiculosExentos);
        System.out.printf("TOTAL RECAUDADO    : $%.2f%n", totalRecaudado);
    }
}
