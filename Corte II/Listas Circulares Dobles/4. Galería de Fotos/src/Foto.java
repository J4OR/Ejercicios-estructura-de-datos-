// La Clase Foto (Nodo): Debe contener titulo (String), fecha (String) y esFavorita (boolean).
public class Foto {
    String titulo;
    String fecha;
    boolean esFavorita;

    Foto siguiente;
    Foto anterior;

    public Foto(String titulo, String fecha) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.esFavorita = false;
        this.siguiente = null;
        this.anterior = null;
    }
}
