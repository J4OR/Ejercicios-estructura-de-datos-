// El Problema: El supervisor necesita saber cuánta carga total hay en el callejón sin mover los camiones físicamente (solo consultando la estructura).
// Reto: Implementa un método que recorra la pila (sin destruirla permanentemente, o reconstruyéndola) y calcule la suma total de cargaToneladas de todos los camiones estacionados.

public class PilaCamiones {
    private Camion tope;
    private int tamanio;

    public PilaCamiones() {
        this.tope = null;
        this.tamanio = 0;
    }

    public boolean isEmpty(){
        return this.tope == null;
    }

    public int getTamanio(){
        return this.tamanio;
    }

    public void push(Camion nuevoCamion){
        if (nuevoCamion == null) {
            System.out.println("No se puede agregar un camión nulo a la pila.");
            return;
        }
        nuevoCamion.siguiente = tope;
        tope = nuevoCamion;
        tamanio++;
    }
    
    public Camion pop(){
        if (isEmpty()) {
            System.out.println("La pila está vacía. No se puede eliminar ningún camión.");
            return null;
        }
        Camion camionEliminado = this.tope;
        this.tope = this.tope.siguiente;
        camionEliminado.siguiente = null; 
        this.tamanio--;
        return camionEliminado;
    }

    public Camion peek(){
        if (isEmpty()) {
            System.out.println("La pila está vacía. No hay camión en la cima.");
            return null;
        }
        return this.tope;
    }

    public void imprimir() {

        if (isEmpty()) {

            System.out.println("Pila vacía.");
            return;
        }

        Camion actual = tope;

        System.out.println("\n=== CAMIONES EN EL CALLEJÓN ===");

        while (actual != null) {

            if (actual == tope) {
                System.out.print(" TOPE -> ");
            } else {
                System.out.print("          ");
            }

            System.out.println(actual.toString());

            actual = actual.siguiente;
        }

        System.out.println("================================");
    }

    public double calcularCargaTotal() {
        double suma = 0.0;
        PilaCamiones auxiliar = new PilaCamiones();

        while (!isEmpty()) {
            Camion actual = pop();
            suma += actual.cargaToneladas;
            auxiliar.push(actual);
        }
        while (!auxiliar.isEmpty()) {
            push(auxiliar.pop());
        }
        return suma;
    }
}

