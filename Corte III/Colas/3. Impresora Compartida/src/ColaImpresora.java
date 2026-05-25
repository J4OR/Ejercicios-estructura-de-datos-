public class ColaImpresora {
    private Documento salida;
    private Documento entrada;
    private int tamanio;

    public ColaImpresora() {
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

    public Documento peek() {
        if (isEmpty()) {
            System.out.println("Cola vacía — no hay documentos pendientes.");
            return null;
        }
        return salida;
    }

    public void enqueue(Documento doc) {
        if (isEmpty()) {
            salida  = doc;
            entrada = doc;
        } else {
            entrada.siguiente = doc;
            entrada = doc;
        }
        tamanio++;
    }

    public Documento dequeue() {
        if (isEmpty()) {
            System.out.println("Cola vacía.");
            return null;
        }
        Documento dato = salida;
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
        Documento actual = salida;
        while (actual != null) {
            System.out.print("[" + actual.nombreArchivo +
                             " | " + actual.numeroPaginas + "p" +
                             (actual.esColor ? " COLOR" : " BN") + "]");
            if (actual.siguiente != null) System.out.print(" -> ");
            actual = actual.siguiente;
        }
        System.out.println(" -> ENTRADA");
    }

    
    public int calcularPaginasTotales() {
        int total = 0;
        Documento auxiliar = salida;   
        while (auxiliar != null) {
            total    += auxiliar.numeroPaginas;
            auxiliar  = auxiliar.siguiente;
        }
        return total;
    }
}
