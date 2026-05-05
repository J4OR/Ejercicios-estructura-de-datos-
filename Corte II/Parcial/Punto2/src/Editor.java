public class Editor {
    Capa cabeza;
    Capa cola;
    Capa capaActiva;

    public Editor() {
        cabeza = null;
        cola = null;
        capaActiva = null;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void agregarCapa(String nombre, boolean visible) {
        Capa nueva = new Capa(nombre, visible);

        if (cabeza == null) {
            nueva.siguiente = nueva;
            nueva.anterior = nueva;
            cabeza = cola = capaActiva = nueva;
        } else {
            cola.siguiente = nueva;
            nueva.anterior = cola;
            nueva.siguiente = cabeza;
            cabeza.anterior = nueva;
            cola = nueva;
        }
    }
    public void subirCapa() {
        if (estaVacia()) {
            System.out.println("No hay capas para subir.");  
            return;
        } 
        capaActiva = capaActiva.siguiente;
    }

    public void bajarCapa() {
         if (estaVacia()) {
            System.out.println("No hay capas para bajar.");  
            return;
        } 
        capaActiva = capaActiva.anterior;
    }

    public void toggleVisibilidad() {
        if (capaActiva == null) return;
        capaActiva.visible = !capaActiva.visible;
    }

    public void eliminarActiva() {
        if (capaActiva == null) return;

        if (capaActiva.siguiente == capaActiva) {
            cabeza = cola = capaActiva = null;
            return;
        }

        Capa actual = capaActiva;

        actual.anterior.siguiente = actual.siguiente;
        actual.siguiente.anterior = actual.anterior;

        if (actual == cabeza) cabeza = actual.siguiente;
        if (actual == cola) cola = actual.anterior;

        capaActiva = actual.siguiente;
    }

    public void mostrarCapas() {
        if (estaVacia()) {
            System.out.println("No hay capas.");
            return;
        }

        System.out.println("\n====== Capas ======");

        Capa actual = cabeza;

        do {
            String activa = (actual == capaActiva) ? "[x] " : "[ ] ";
            String visible = actual.visible ? "Visible: SI" : "Visible: NO";

            System.out.println(activa + actual.nombre + " - " + visible);

            actual = actual.siguiente;
        } while (actual != cabeza);
    }
}

