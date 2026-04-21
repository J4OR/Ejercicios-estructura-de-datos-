// El Problema: El historial mantiene un puntero cursor al comando que se está consultando. Navegar con "arriba" mueve el cursor al anterior (anterior); "abajo" lo mueve al siguiente (siguiente). El usuario puede eliminar el comando actual (para borrar contraseñas escritas por error), y el cursor pasa automáticamente al siguiente.
// Reto: Implementa los métodos arriba(), abajo(), mostrarCursor() y eliminarActual(). Simula: agrega 5 comandos, navega 3 veces hacia arriba, elimina el comando actual, navega una vez hacia abajo y muestra el historial completo con el cursor marcado.

public class Historial {
    Comando cabeza;
    Comando cola;
    Comando cursor;

    public Historial() {
        this.cabeza = null;
        this.cola = null;
        this.cursor = null;
    }
    
    public boolean estaVacia() {
            return cabeza == null;
        }

        public void agregarComando(String texto, boolean exitoso, String directorio) {
            Comando nueva = new Comando(texto, exitoso, directorio);
            if (cabeza == null) {
                nueva.siguiente = nueva;
                nueva.anterior = nueva;
                cabeza = nueva;
                cola = nueva;
            } else {
                cola.siguiente = nueva;
                nueva.anterior = cola;
                nueva.siguiente = cabeza;
                cabeza.anterior = nueva;
                cola = nueva;
            }
        }
    
    public void arriba(){

        if (estaVacia()){
            System.out.println("El historial está vacío.");
            return;
        } 
        if (cursor != null && cursor.siguiente != null) {
            cursor = cursor.siguiente; // Mover el cursor al siguiente comando (más reciente)

        }
    }
    
    public void abajo() {
        if (estaVacia()){
            System.out.println("El historial está vacío.");
            return;
        } 
        if (cursor != null && cursor.anterior != null) {
            cursor = cursor.anterior; // Mover el cursor al comando anterior (más antiguo)
        }
    }

    public void mostrarCursor() {
        if (estaVacia()){
            System.out.println("El historial está vacío.");
            return;
        } 
         System.out.println(">> " + cursor.texto + " | " + (cursor.exitoso ? "SI" : "NO") + " | " + cursor.directorio);
    }

    public void eliminarActual(String texto) {
        if (estaVacia()){
            System.out.println("El historial está vacío.");
            return;
        } 
        if (cursor == null) {
            System.out.println("No hay comando seleccionado para eliminar.");
            return;
        }
        if (cursor == cabeza && cursor == cola) {
            cabeza = null;
            cola = null;
            cursor = null;
        } else {
            cursor.anterior.siguiente = cursor.siguiente;
            cursor.siguiente.anterior = cursor.anterior;
            if (cursor == cabeza) {
                cabeza = cursor.siguiente;
            }
            if (cursor == cola) {
                cola = cursor.anterior;
            }
            cursor = cursor.siguiente; 
        }
    }
    public void mostrarHistorial() {
        if (estaVacia()){
            System.out.println("El historial está vacío.");
            return;
        } 
        Comando actual = cabeza;
        do {
            String marcador = (actual == cursor) ? ">> " : "   ";
            System.out.println(marcador + actual.texto + " | " + (actual.exitoso ? "SI" : "NO") + " | " + actual.directorio);
            actual = actual.siguiente;
        } while (actual != cabeza);
    }
    
}
