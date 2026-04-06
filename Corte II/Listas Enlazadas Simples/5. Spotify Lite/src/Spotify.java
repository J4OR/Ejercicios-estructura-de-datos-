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

    public void MostrarDuracionTotal(){
        int duracionTotal = 0;
        Cancion actual = cabeza; 
        if (cabeza==null) {
            System.out.println("La lista está vacía.");
            return;
        }
        while (actual != null){
            duracionTotal += actual.duracionSegundos;
            System.out.println("-Titulo: " + actual.titulo + " |Artista: " + actual.artista + 
                " |Duracion: " + actual.duracionSegundos + " segundos" + " |Genero: " + actual.genero + "\n");
            actual = actual.siguiente;
        }
        int minutos = duracionTotal / 60;
        int segundos = duracionTotal % 60;
        if(segundos < 10){
            System.out.println("Duración Total: " + minutos + ":0" + segundos);
        }else{
            System.out.println("Duración Total: " + minutos + ":" + segundos);
        }
    }
}
