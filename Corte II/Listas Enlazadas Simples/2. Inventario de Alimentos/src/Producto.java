// La Clase Producto (Nodo): Debe contener nombre (String), cantidad (int) y diasParaVencer (int).
public class Producto {
    String nombre;
    int cantidad;
    int diasParaVencer;

    Producto siguiente; 



    public Producto(String nombre, int cantidad, int diasParaVencer) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.diasParaVencer = diasParaVencer;
        this.siguiente = null;
    }
}
