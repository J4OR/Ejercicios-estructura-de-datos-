public class Capa {
    String nombre;
    boolean visible;

    Capa siguiente;
    Capa anterior;

    public Capa(String nombre, boolean visible) {
        this.nombre = nombre;
        this.visible = visible;
        this.siguiente = null;
        this.anterior = null;
    }
}
