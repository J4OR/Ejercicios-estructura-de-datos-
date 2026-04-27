// 4. Galería de Fotos
// Una app de galería muestra las fotos de un álbum de una en una. El usuario puede pasar a la foto siguiente, volver a la anterior, y marcar cualquier foto como favorita. Al eliminar una foto, la galería continúa desde la siguiente sin interrupciones.

// La Clase Foto (Nodo): Debe contener titulo (String), fecha (String) y esFavorita (boolean).
// El Problema: La galería mantiene un puntero actual a la foto que se está viendo. Navegar con "siguiente" o "anterior" mueve ese puntero. Marcar como favorita simplemente alterna el campo esFavorita de la foto actual. Eliminar la foto actual desconecta el nodo en O(1) y mueve actual a la siguiente.
// Reto: Implementa los métodos siguiente(), anterior(), toggleFavorita(), eliminarActual() y mostrarGaleria(). mostrarGaleria() recorre todas las fotos marcando con [★] las favoritas y con [▶] la foto actual. Simula: carga 5 fotos, avanza dos veces, marca la actual como favorita, retrocede una, elimina esa foto y muestra el estado final de la galería.


public class App {
    public static void main(String[] args) throws Exception {
    }
}
