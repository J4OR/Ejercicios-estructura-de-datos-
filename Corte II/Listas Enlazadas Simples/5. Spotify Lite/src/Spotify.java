public class Spotify {
    Cancion cabeza;

    public Spotify() {
        this.cabeza = null;
    }

    public void agregarCancion(Cancion nuevaCancion) {
        if (cabeza == null) {
            cabeza = nuevaCancion;
        } else {
            nuevaCancion.siguiente = cabeza;
            cabeza = nuevaCancion;
        }
    }
    public void agregarCancionAlFinal(Cancion nuevaCancion) {
        if (cabeza == null) {
            cabeza = nuevaCancion;
        } else {
            Cancion actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevaCancion;
        }
    }

    public void mostrarDuracionTotal() {
        int duracionTotal = 0;
        Cancion actual = cabeza;
        while (actual != null) {
            duracionTotal += actual.duracionSegundos;
            actual = actual.siguiente;
        }
        System.out.println("Duración Total de la Lista: " + duracionTotal + " segundos");
    }
}
