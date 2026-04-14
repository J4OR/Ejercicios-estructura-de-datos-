// El Problema: La pantalla necesita saber cuánto tiempo total lleva encendida y cuál es el anuncio que más veces se ha repetido.
// Reto: Implementa el método reproducir(int ciclos) que simule ciclos pasadas completas por todos los anuncios, incrementando vecesRepetido en cada paso e imprimiendo qué anuncio está en pantalla. Al finalizar, muestra el anuncio más repetido y el tiempo total acumulado en pantalla.
public class Reproductor {
    Anuncio cabeza;

    public Reproductor() {
        this.cabeza = null;
    }

    public void agregarAnuncio(Anuncio nuevoAnuncio) {
        if (cabeza == null) {
            cabeza = nuevoAnuncio;
            cabeza.siguiente = cabeza; 
        } else {
            Anuncio temp = cabeza;
            while (temp.siguiente != cabeza) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoAnuncio;
            nuevoAnuncio.siguiente = cabeza; 
        }
    }

    public void reproducir(int ciclos) {
        if (cabeza == null) {
            System.out.println("No hay anuncios para reproducir.");
            return;
        }

        Anuncio actual = cabeza;
        int tiempoTotal = 0;

        for (int i = 0; i < ciclos; i++) {
            System.out.println("Ciclo " + (i + 1) + ": " + actual.titulo);
            actual.vecesRepetido++;
            tiempoTotal += actual.duracionSegundos;
            actual = actual.siguiente; 
        }

       
        Anuncio anuncioMasRepetido = cabeza;
        Anuncio temp = cabeza.siguiente;

        while (temp != cabeza) {
            if (temp.vecesRepetido > anuncioMasRepetido.vecesRepetido) {
                anuncioMasRepetido = temp;
            }
            temp = temp.siguiente;
        }

        System.out.println("\nAnuncio más repetido: " + anuncioMasRepetido.titulo + " con " + anuncioMasRepetido.vecesRepetido + " repeticiones.");
        System.out.println("Tiempo total acumulado en pantalla: " + tiempoTotal + " segundos.");
    }
}
