// El Problema: La pantalla necesita saber cuánto tiempo total lleva encendida y cuál es el anuncio que más veces se ha repetido.
// Reto: Implementa el método reproducir(int ciclos) que simule ciclos pasadas completas por todos los anuncios, incrementando vecesRepetido en cada paso e imprimiendo qué anuncio está en pantalla. Al finalizar, muestra el anuncio más repetido y el tiempo total acumulado en pantalla.
public class Reproductor {
    Anuncio cabeza;
    Anuncio cola;
    int tiempoTotal;


    public Reproductor() {
        this.cabeza = null;
        this.cola = null;
        this.tiempoTotal = 0;

    }

    public void agregarAnuncio(Anuncio anuncio) {
        if (cabeza == null) {
            cabeza = anuncio;
            cabeza.siguiente = cabeza; // Apunta a sí mismo para formar la circularidad
        } else {
            Anuncio temp = cabeza;
            while (temp.siguiente != cabeza) {
                temp = temp.siguiente;
            }
            temp.siguiente = anuncio;
            anuncio.siguiente = cabeza; // Apunta al inicio para mantener la circularidad
        }
    }

    public void reproducir(int ciclos) {
        if (cabeza == null) {
            System.out.println("No hay anuncios para reproducir.");
            return;
        }

        Anuncio actual = cabeza;
        for (int i = 0; i < ciclos; i++) {
            do {
                System.out.println("Reproduciendo: " + actual.titulo);
                actual.vecesRepetido++;
                tiempoTotal += actual.duracionSegundos;
                actual = actual.siguiente;
            } while (actual != cabeza);
        }

        // Encontrar el anuncio más repetido
        Anuncio masRepetido = cabeza;
        Anuncio temporal = cabeza.siguiente;
        while (temporal != cabeza) {
            if (temporal.vecesRepetido > masRepetido.vecesRepetido) {
                masRepetido = temporal;
            }
            temporal = temporal.siguiente;
        }

        System.out.println("Anuncio más repetido: " + masRepetido.titulo + " con " + masRepetido.vecesRepetido + " repeticiones.");
        System.out.println("Tiempo total acumulado en pantalla: " + tiempoTotal + " segundos.");
    }
}
