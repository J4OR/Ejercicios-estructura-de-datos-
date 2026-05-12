// El Problema: Por norma de seguridad, no se puede despachar un medicamento si le quedan menos de 10 días para vencer.
// Reto: Implementa un método validarDespacho() que revise el medicamento en el tope. Si está a punto de vencer, debe ser retirado automáticamente y el sistema debe revisar el siguiente. El proceso se repite hasta que el tope sea un medicamento seguro o la pila quede vacía.
public class PilaMedicamentos {

    private Medicamento tope;
    private int tamanio;

    public PilaMedicamentos() {

        this.tope = null;
        this.tamanio = 0;
    }

    public boolean isEmpty() {

        return tope == null;
    }

    public int getTamanio() {

        return tamanio;
    }

    public void push(Medicamento nuevo) {

        if (nuevo == null) {

            System.out.println("No se puede agregar un medicamento nulo. ");
            return;
        }

        nuevo.siguiente = tope;

        tope = nuevo;

        tamanio++;
    }

    public Medicamento pop() {

        if (isEmpty()) {

            System.out.println("La pila está vacía.");
            return null;
        }

        Medicamento eliminado = tope;

        tope = tope.siguiente;

        eliminado.siguiente = null;

        tamanio--;

        return eliminado;
    }

    public Medicamento peek() {

        return tope;
    }

    public void imprimir() {

        if (isEmpty()) {

            System.out.println("Pila vacía.");
            return;
        }

        Medicamento actual = tope;

        System.out.println("\n=== MEDICAMENTOS EN EL DISPENSADOR ===");

        while (actual != null) {

            if (actual == tope) {
                System.out.print(" TOPE -> ");
            } else {
                System.out.print("          ");
            }

            System.out.println(actual);

            actual = actual.siguiente;
        }

        System.out.println("======================================");
    }

    public void validarDespacho() {

        while (!isEmpty()) {

            Medicamento actual = peek();

            if (actual.diasParaVencer < 10) {

                System.out.println("Medicamento retirado: " + actual.nombre + 
                " | Quedan " + actual.diasParaVencer + " días para vencer.");

                pop();

            } else {

                System.out.println("Medicamento seguro para despacho:");
                System.out.println(actual);

                return;
            }
        }

        System.out.println("No quedan medicamentos seguros.");
    }
}
