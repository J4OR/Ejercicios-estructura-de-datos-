// El Problema: El historial mantiene un puntero cursor al comando que se está consultando. Navegar con "arriba" mueve el cursor al anterior (anterior); "abajo" lo mueve al siguiente (siguiente). El usuario puede eliminar el comando actual (para borrar contraseñas escritas por error), y el cursor pasa automáticamente al siguiente.
// Reto: Implementa los métodos arriba(), abajo(), mostrarCursor() y eliminarActual(). Simula: agrega 5 comandos, navega 3 veces hacia arriba, elimina el comando actual, navega una vez hacia abajo y muestra el historial completo con el cursor marcado.

public class Historial {
    Comando cabeza;
    Comando cola;
    Comando cursor;

    public Historial() {
        cabeza = null;
        cola = null;
        cursor = null;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void agregarComando(String texto, boolean exitoso, String directorio) {
        Comando nuevo = new Comando(texto, exitoso, directorio);

        if (cabeza == null) {
            nuevo.siguiente = nuevo;
            nuevo.anterior = nuevo;
            cabeza = cola = cursor = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cola = nuevo;
        }
    }

    public void arriba() {
        if (estaVacia()){
            System.out.println("No hay comandos");
            return;
        }
        cursor = cursor.anterior;
        mostrarCursor();
    }

    public void abajo() {
        if (estaVacia()){
            System.out.println("No hay comandos");
            return;
        }
        cursor = cursor.siguiente;
        mostrarCursor();
    }

    public void mostrarCursor() {
         if (estaVacia()){
            System.out.println("No hay comandos");
            return;
        }

        System.out.println(">> " + cursor.texto + " | " + (cursor.exitoso ? "SI" : "NO") + " | " + cursor.directorio);
    }

    public void eliminarActual() {
    if (cabeza == null) return;
    if (cursor == null) return;

    Comando actual = cabeza;

    do {
        if (actual == cursor) {

            if (actual.siguiente == actual) {
                cabeza = null;
                cola = null;
                cursor = null;
                return;
            }
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;

         
            if (actual == cabeza) cabeza = actual.siguiente;
            if (actual == cola) cola = actual.anterior;

           
            cursor = actual.siguiente;

            return;
        }

        actual = actual.siguiente;
    } while (actual != cabeza);
}

    public void mostrarHistorial() {
        if (estaVacia()) {
            System.out.println("Historial vacío.");
            return;
        }

        System.out.println("\n=== Historial de Comandos ===");
        Comando actual = cabeza;
        int i = 1;

        do {
            String marca = (actual == cursor) ? " <-- [CURSOR]" : "";

            System.out.println(i + ". " + actual.texto +
                    " | " + (actual.exitoso ? "SI" : "NO") +
                    " | " + actual.directorio + marca);

            actual = actual.siguiente;
            i++;
        } while (actual != cabeza);
    }
}
