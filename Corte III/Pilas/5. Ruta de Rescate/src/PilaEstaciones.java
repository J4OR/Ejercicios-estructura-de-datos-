// El Problema: Para salir de la cueva, el equipo debe seguir las estaciones en el orden inverso al que fueron colocadas (de la más profunda a la entrada).
// Reto: Implementa el método retrocederASuperficie(). Este debe mostrar el nombre de cada estación a medida que se desapila. Importante: Si en alguna estación el nivelOxigeno es inferior al 18%, el sistema debe imprimir una alerta de "Uso de Tanque de Emergencia Requerido" al pasar por ese punto.
public class PilaEstaciones {

    private Estacion tope;
    private int tamanio;

    public PilaEstaciones() {

        this.tope = null;
        this.tamanio = 0;
    }

    public boolean isEmpty() {

        return tope == null;
    }

    public int getTamanio() {

        return tamanio;
    }

    public void push(Estacion nueva) {

        if (nueva == null) {

            System.out.println("No se puede agregar una estación nula.");
            return;
        }

        nueva.siguiente = tope;

        tope = nueva;

        tamanio++;
    }

    public Estacion pop() {

        if (isEmpty()) {

            System.out.println("La pila está vacía.");
            return null;
        }

        Estacion eliminada = tope;

        tope = tope.siguiente;

        eliminada.siguiente = null;

        tamanio--;

        return eliminada;
    }

    public Estacion peek() {

        return tope;
    }

    public void imprimir() {

        if (isEmpty()) {

            System.out.println("Pila vacía.");
            return;
        }

        Estacion actual = tope;

        System.out.println("\n=== ESTACIONES EN LA CUEVA ===");

        while (actual != null) {

            if (actual == tope) {
                System.out.print(" TOPE -> ");
            } else {
                System.out.print("          ");
            }

            System.out.println(actual);

            actual = actual.siguiente;
        }

        System.out.println("================================");
    }

    public void retrocederASuperficie() {

        if (isEmpty()) {

            System.out.println("No hay estaciones registradas.");
            return;
        }

        System.out.println("\n=== INICIANDO RETROCESO ===");

        while (!isEmpty()) {

            Estacion actual = pop();
            System.out.println(actual);

            System.out.println("Retrocediendo por: " + actual.nombrePunto);

            if (actual.nivelOxigeno < 18) {
                System.out.println();
                System.out.println("ALERTA:");
                System.out.println("Uso de Tanque de Emergencia Requerido");
            }
        }

        System.out.println("El equipo ha salido de la cueva.");
    }
}