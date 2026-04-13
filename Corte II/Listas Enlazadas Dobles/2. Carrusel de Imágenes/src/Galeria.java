public class Galeria {
    Fotografia cabeza;
    Fotografia cola;
    Fotografia actual;

    public Galeria(){
        this.cabeza = null;
        this.cola = null;
        this.actual = null;
    }

    public void agregarFoto(Fotografia foto) {

        if (cabeza == null) {
            cabeza = foto;
            cola = foto;
        } else {
            cola.siguiente = foto;
            foto.anterior = cola;
            cola = foto;
        }
    }

    public void fotoSiguiente() {
        if (cabeza == null) {
            System.out.println("No hay fotos en la galería.");
            return;
        }

        if (actual == null) {
            actual = cabeza; 
        }   
        else if (actual.siguiente != null) {
            actual = actual.siguiente;
        } 
        else {
            System.out.println("Ya estás en la última foto.");
            return;
        }
        System.out.println("Foto: " + actual.nombreArchivo + " | Tamaño: " + actual.tamanoMB + "MB" + " | Resolución: " + actual.resolucion);
    }

    public void fotoAnterior() {
        if (cabeza == null) {
            System.out.println("No hay fotos en la galería.");
            return;
        }

        if (actual == null) {
            actual = cabeza; 
        }   
        else if (actual.anterior != null) {
            actual = actual.anterior;
        } 
        else {
            System.out.println("Ya estás en la primera foto.");
            return;
        }
        System.out.println("Foto: " + actual.nombreArchivo + " | Tamaño: " + actual.tamanoMB + "MB" + " | Resolución: " + actual.resolucion);
    }
}


