// El Problema: El historial mantiene un puntero cursor al comando que se está consultando. Navegar con "arriba" mueve el cursor al anterior (anterior); "abajo" lo mueve al siguiente (siguiente). El usuario puede eliminar el comando actual (para borrar contraseñas escritas por error), y el cursor pasa automáticamente al siguiente.
// Reto: Implementa los métodos arriba(), abajo(), mostrarCursor() y eliminarActual(). Simula: agrega 5 comandos, navega 3 veces hacia arriba, elimina el comando actual, navega una vez hacia abajo y muestra el historial completo con el cursor marcado.

public class Historial {
    Comando cabeza;
    Comando cola;

    public Historial() {
        this.cabeza = null;
        this.cola = null;
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
        if (cola != null && cola.siguiente != null) {
            cola = cola.siguiente; // Mover el cursor al siguiente comando (más reciente)
        }
    }
    
    public void abajo() {
        if (estaVacia()){
            System.out.println("El historial está vacío.");
            return;
        } 
        if (cabeza != null && cabeza.anterior != null) {
            cabeza = cabeza.anterior; // Mover el cursor al comando anterior (más antiguo)
        }
    }

    public void mostrarCursor(){
        if (estaVacia()){
            System.out.println("El historial está vacío.");
            return;
        } 
        
    }
}
