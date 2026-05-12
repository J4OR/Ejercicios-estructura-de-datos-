// El Problema: Si el sensor detecta una pieza defectuosa, la línea de producción debe detenerse inmediatamente.
// Reto: Crea un método limpiarHastaDefecto() que extraiga (pop) todas las piezas de la pila hasta encontrar la primera que tenga esDefectuosa = true. El método debe imprimir el nombre de todas las piezas "buenas" que tuvieron que ser retiradas y descartadas antes de llegar a la pieza fallida.
public class PilaEnsamblaje {
    private Pieza tope;
    private int tamanio;
        
    public PilaEnsamblaje() {
        this.tope = null;
        this.tamanio = 0;
    }

    public boolean isEmpty() {
        return tope == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public Pieza pop(){
        if (isEmpty()) {
            return null;
        }
        Pieza aux = tope;
        tope = tope.siguiente;
        tamanio--;
        aux.siguiente = null;
        return aux;
    }
    public Pieza peek() {
        return tope;
    }

    public void push(Pieza nueva) {
        if (nueva == null) {
            System.out.println("No se puede agregar una pieza nula.");
            return;
        }
        nueva.siguiente = tope;
        tope = nueva;
        tamanio++;
    }

    public void limpiarHastaDefecto() {
        if (isEmpty()) {
            System.out.println("La línea de producción está vacía.");
            return;
        }
        System.out.println("Iniciando limpieza hasta encontrar pieza defectuosa...");
        while (!isEmpty()) {
            Pieza actual = pop();
            if (actual.esDefectuosa) {
                System.out.println("¡Pieza defectuosa encontrada! Deteniendo la línea de producción.");
                break;
            } else {
                System.out.println("Pieza buena retirada: " + actual.nombrePieza);
            }
        }
    }

    public void imprimir() {
        if (isEmpty()) {
            System.out.println("La línea de producción está vacía.");
            return;
        }
        Pieza actual = tope;
        System.out.println("=== ESTADO DE LA LÍNEA DE ENSAMBLAJE (De Tope a Base) ===");
        while (actual != null) {
            if (actual == tope) {
                System.out.print("  TOPE -> ");
            } else {
                System.out.print("          ");
            }
            System.out.println(actual.toString());
            actual = actual.siguiente;
        }
        System.out.println("=====================================================");
    }






}
