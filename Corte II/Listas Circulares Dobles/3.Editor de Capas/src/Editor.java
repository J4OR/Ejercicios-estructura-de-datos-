// El Problema: El editor mantiene un puntero capaActiva a la capa seleccionada. El usuario puede moverse entre capas, alternar la visibilidad 
// de la activa y eliminarla (el foco pasa a la siguiente).
// Reto: Implementa los métodos subirCapa(), bajarCapa(), toggleVisibilidad(), eliminarActiva() y mostrarCapas().
//  mostrarCapas() imprime todas las capas marcando la activa con [✓] e indicando si cada una es visible. Simula: 
// crea 4 capas, activa la del medio, sube una vez, oculta la activa, elimínala y muestra el estado final.
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

    public void agregarCapa(String nombre, boolean visible, String tipo) {
        Capa nueva = new Capa(nombre, visible, tipo);

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
            String vis = actual.visible ? "Visible" : "Oculta";

            System.out.println(
                activa + actual.nombre +
                " (" + actual.tipo + ") - " + vis
            );

            actual = actual.siguiente;
        } while (actual != cabeza);
    }
}
