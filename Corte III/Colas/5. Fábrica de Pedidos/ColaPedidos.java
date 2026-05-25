public class ColaPedidos {
    private Pedido salida;
    private Pedido entrada;
    private int tamanio;

    public ColaPedidos() {
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

    public Pedido peek() {
        if (isEmpty()) {
            System.out.println("Cola vacía — no hay pedidos pendientes.");
            return null;
        }
        return salida;
    }

    public void enqueue(Pedido pedido) {
        if (isEmpty()) {
            salida  = pedido;
            entrada = pedido;
        } else {
            entrada.siguiente = pedido;
            entrada = pedido;
        }
        tamanio++;
    }

    public Pedido dequeue() {
        if (isEmpty()) {
            System.out.println("Cola vacía — no hay pedidos pendientes.");
            return null;
        }
        Pedido dato = salida;
        salida = salida.siguiente;
        if (salida == null) entrada = null;
        tamanio--;
        return dato;
    }

    public void imprimir() {
        if (isEmpty()) {
            System.out.println("[ Cola vacía ]");
            return;
        }
        System.out.print("SALIDA -> ");
        Pedido actual = salida;
        while (actual != null) {
            System.out.print("[" + actual.numeroPedido +
                             " | " + actual.cliente +
                             (actual.cancelado ? " CANCELADO" : "") + "]");
            if (actual.siguiente != null) System.out.print(" -> ");
            actual = actual.siguiente;
        }
        System.out.println(" -> ENTRADA");
    }

    // Reto: vacía la cola, despacha vigentes y descarta cancelados con conteo separado
    public void procesarPedidos() {
        if (isEmpty()) {
            System.out.println("No hay pedidos para procesar.");
            return;
        }
        int totalDespachados = 0;
        int totalCancelados  = 0;

        System.out.println("\n========== PROCESANDO COLA DE PEDIDOS ==========");
        while (!isEmpty()) {
            Pedido p = dequeue();
            if (p.cancelado) {
                System.out.println("  X DESCARTADO -> Pedido " + p.numeroPedido +
                                   " de " + p.cliente + " (cancelado por el cliente)");
                totalCancelados++;
            } else {
                System.out.printf("  OK DESPACHADO -> Pedido %s | Cliente: %s | Total: $%.2f%n",
                                  p.numeroPedido, p.cliente, p.totalPagar);
                totalDespachados++;
            }
        }
        System.out.println("=================================================");
        System.out.println("Pedidos despachados : " + totalDespachados);
        System.out.println("Pedidos cancelados  : " + totalCancelados);
        System.out.println("Total procesados    : " + (totalDespachados + totalCancelados));
    }
}
