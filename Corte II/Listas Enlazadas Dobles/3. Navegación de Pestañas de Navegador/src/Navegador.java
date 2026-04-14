// El Problema: Las pestañas se abren una tras otra. A veces el usuario quiere cerrar la pestaña actual y el foco debe pasar a la pestaña anterior.
// Reto: Implementar el método cerrarPestanaActual(String url) que busque la pestaña por URL, la elimine de la lista y reconecte el nodo anterior con el siguiente correctamente (¡Cuidado con la Cabeza y la Cola!).
public class Navegador {
    Pestana cabeza;
    Pestana cola;

    public Navegador() {
        this.cabeza = null;
        this.cola = null;
    }

    public void abrirPestana(Pestana pestana) {
        if (cabeza == null) {
            cabeza = pestana;
            cola = pestana;
        } else {
            cola.siguiente = pestana;
            pestana.anterior = cola;
            cola = pestana;
        }
    }

    public void cerrarPestanaActual(String url) {
        Pestana actual = cabeza;
        while (actual != null) {
            if (actual.url.equals(url)) {
                if (actual.anterior != null) {
                    actual.anterior.siguiente = actual.siguiente;
                } else {
                    cabeza = actual.siguiente; // Si es la cabeza
                }
                if (actual.siguiente != null) {
                    actual.siguiente.anterior = actual.anterior;
                } else {
                    cola = actual.anterior; // Si es la cola
                }
                System.out.println("Pestaña cerrada: " + url);
                return;
            }
            actual = actual.siguiente;
        }
        System.out.println("Pestaña no encontrada: " + url);
    }
    public void mostrarPestanas() {
        Pestana actual = cabeza;
        while (actual != null) {
            System.out.println("Título: " + actual.tituloPagina + ", URL: " + actual.url + ", Hora de Apertura: " + actual.horaApertura);
            actual = actual.siguiente;
        }
    }

}
