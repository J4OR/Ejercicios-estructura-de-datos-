// El Problema: La galería mantiene un puntero actual a la foto que se está viendo. Navegar con "siguiente" o "anterior" mueve ese puntero. Marcar como favorita simplemente alterna el campo esFavorita de la foto actual. Eliminar la foto actual desconecta el nodo en O(1) y mueve actual a la siguiente.
// Reto: Implementa los métodos siguiente(), anterior(), toggleFavorita(), eliminarActual() y mostrarGaleria(). mostrarGaleria() recorre todas las fotos marcando con [★] las favoritas y con [▶] la foto actual. Simula: carga 5 fotos, avanza dos veces, marca la actual como favorita, retrocede una, elimina esa foto y muestra el estado final de la galería.
public class Galeria {
    Foto cabeza;
    Foto cola;


    public Galeria() {
        this.cabeza = null;
        this.cola = null;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void agregarFoto(String titulo, String fecha) {
        Foto nuevaFoto = new Foto(titulo, fecha);
        if (cabeza == null) {
            cabeza = nuevaFoto;
            cola = nuevaFoto;
            nuevaFoto.siguiente = nuevaFoto;
            nuevaFoto.anterior = nuevaFoto;
        } else {
            cola.siguiente = nuevaFoto;
            nuevaFoto.anterior = cola;
            nuevaFoto.siguiente = cabeza;
            cabeza.anterior = nuevaFoto;
            cola = nuevaFoto;
        }
    }

    public void siguiente() {
       if (estaVacia()){
            System.out.println("La galería está vacía.");
            return;
        }
        cabeza = cabeza.siguiente;
        mostrarFotoActual();
    }

    public void anterior() {
        if (estaVacia()){
            System.out.println("La galería está vacía.");
            return;
        }
        cabeza = cabeza.anterior;
        mostrarFotoActual();
    }
    public void toggleFavorita() {
        if (estaVacia()){
            System.out.println("La galería está vacía.");
            return;
        }
        cabeza.esFavorita = !cabeza.esFavorita;
    }
    public void mostrarFotoActual() {
        if (estaVacia()){
            System.out.println("La galería está vacía.");
            return;
        }
        System.out.println("Foto Actual: " + cabeza.titulo + " (" + cabeza.fecha + ") " + (cabeza.esFavorita ? "[FAVORITA]" : ""));
    }

    public void eliminarActual(){
        if(estaVacia()){
            System.out.println("La galería está vacía.");
            return;
        }
        if (cabeza == cabeza.siguiente) {
            cabeza = null;
            cola = null;
        } else {
            cabeza.anterior.siguiente = cabeza.siguiente;
            cabeza.siguiente.anterior = cabeza.anterior;
            if (cabeza == cola) {
                cola = cabeza.anterior;
            }
            cabeza = cabeza.siguiente;
        }
    }
    public void mostrarGaleria() {
        if (estaVacia()) {
            System.out.println("La galería está vacía.");
            return;
        }
        Foto actual = cabeza;
        do {
            String favorito = actual.esFavorita ? "[F]" : "";
            String actualMarker = (actual == cabeza) ? "[A]" : "";
            System.out.println(actualMarker + favorito + " " + actual.titulo + " (" + actual.fecha + ")");
            actual = actual.siguiente;
        } while (actual != cabeza);
    }


}

