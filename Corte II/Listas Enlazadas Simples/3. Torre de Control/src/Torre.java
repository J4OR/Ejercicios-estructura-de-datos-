public class Torre {
    Vuelo cabeza;

    public Torre() {
        this.cabeza = null;
    }

    public void agregarVuelo(Vuelo nuevoVuelo){
        if (cabeza == null){
            cabeza = nuevoVuelo;
        }else{
            if (nuevoVuelo.combustibleRestante < 10){
                nuevoVuelo.siguiente = cabeza;
                cabeza = nuevoVuelo;
            }else{
                Vuelo actual = cabeza;
                while (actual.siguiente != null){
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevoVuelo;
            }
        }
    }

    public void reportarEmergencia(String numeroVuelo) {
        if (cabeza == null) {
            System.out.println("La lista de vuelos está vacía.");
            return; 
        }

        if (cabeza.numeroVuelo.equals(numeroVuelo)) {
            return;
        }

        Vuelo anterior = null;
        Vuelo actual = cabeza;

        while (actual != null && !actual.numeroVuelo.equals(numeroVuelo)) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (actual == null) {
            System.out.println("Vuelo no encontrado: " + numeroVuelo);
            return; 
        }

        if (anterior != null) {
            anterior.siguiente = actual.siguiente; 
            actual.siguiente = cabeza; 
            cabeza = actual; 
        }
    }
    public void mostrarColaVuelos() {
        if (cabeza == null) {
            System.out.println("No hay vuelos en la cola.");
            return;
        }
        Vuelo actual = cabeza;
        System.out.println("Cola de vuelos:");
        while (actual != null) {
            System.out.println("Número de vuelo: " + actual.numeroVuelo + ", Aerolínea: " + actual.aerolinea + ", Combustible restante: " + actual.combustibleRestante + ", Pasajeros: " + actual.pasajeros);
            actual = actual.siguiente;
        }
    }
}
