public class Galeria {
    Fotografia primeraFoto;
    Fotografia ultimaFoto;

    public Galeria(){
        this.primeraFoto = null;
        this.ultimaFoto = null;
    }

    public void agregarFoto(String nombreArchivo, double tamanoMB, String resolucion){
        Fotografia nuevaFoto = new Fotografia(nombreArchivo, tamanoMB, resolucion);
        if (primeraFoto == null) {
            primeraFoto = nuevaFoto;
            ultimaFoto = nuevaFoto;
        } else {
            ultimaFoto.siguiente = nuevaFoto;
            nuevaFoto.anterior = ultimaFoto;
            ultimaFoto = nuevaFoto;
        }
    }

    public void reproducirGaleria() {
        // Recorrer hacia adelante
        System.out.println("Recorriendo hacia adelante:");
        Fotografia actual = primeraFoto;
        while (actual != null) {
            System.out.println("Nombre: " + actual.nombreArchivo + ", Tamaño: " + actual.tamanoMB + "MB, Resolución: " + actual.resolucion);
            actual = actual.siguiente;
        }

        // Recorrer hacia atrás
        System.out.println("\nRecorriendo hacia atrás:");
        actual = ultimaFoto;
        while (actual != null) {
            System.out.println("Nombre: " + actual.nombreArchivo + ", Tamaño: " + actual.tamanoMB + "MB, Resolución: " + actual.resolucion);
            actual = actual.anterior;
        }
    }

}
