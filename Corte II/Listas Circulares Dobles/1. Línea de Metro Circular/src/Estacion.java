// La Clase Estacion (Nodo): Debe contener nombre (String), zona (int — del 1 al 3) y pasajerosDiarios (int).
public class Estacion {
    String nombre;
    int zona;
    int pasajerosDiarios;

    Estacion siguiente;
    Estacion anterior;

    public Estacion(String nombre, int zona, int pasajerosDiarios) {
        this.nombre = nombre;
        this.zona = zona;
        this.pasajerosDiarios = pasajerosDiarios;
    }



}
