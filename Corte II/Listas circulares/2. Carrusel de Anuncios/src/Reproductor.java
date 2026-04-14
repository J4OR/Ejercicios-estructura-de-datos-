public class Reproductor {
    Anuncio cabeza;
    int tiempoTotalEnPantalla;

    public Reproductor() {
        this.cabeza = null;
        this.tiempoTotalEnPantalla = 0;
    }

    public void agregarAnuncio(Anuncio nuevoAnuncio) {
        if (cabeza == null) {
            cabeza = nuevoAnuncio;
        } else {
            Anuncio actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoAnuncio;
        }
    }

    public void reproducir(int ciclos) {
        for (int i = 0; i < ciclos; i++) {
            Anuncio actual = cabeza;
            while (actual != null) {
                actual.vecesRepetido++;
                tiempoTotalEnPantalla += actual.duracionSegundos;
                System.out.println("Ciclo " + (i + 1) + ": " + actual.titulo);
                actual = actual.siguiente;
            }
        }

        Anuncio anuncioMasRepetido = cabeza;
        Anuncio actual = cabeza;
        while (actual != null) {
            if (actual.vecesRepetido > anuncioMasRepetido.vecesRepetido) {
                anuncioMasRepetido = actual;
            }
            actual = actual.siguiente;
        }

        System.out.println("Anuncio más repetido: " + anuncioMasRepetido.titulo);
        System.out.println("Tiempo total en pantalla: " + tiempoTotalEnPantalla + " segundos");
    }
}
