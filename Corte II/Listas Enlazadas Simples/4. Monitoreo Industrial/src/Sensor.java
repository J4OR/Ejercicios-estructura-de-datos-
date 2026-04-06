public class Sensor {
    Lectura cabeza;

    public Sensor() {
        this.cabeza = null;
    }
    public void agrgarLectura(Lectura nuevaLectura) {
        nuevaLectura.siguiente = cabeza;
        cabeza = nuevaLectura;
    }
    public void lecturaMasAlta(){
        if (cabeza == null){
            System.out.println("No hay lecturas disponibles.");
            return;
        }
        Lectura actual = cabeza;
        Lectura maxLectura = cabeza;
        while (actual != null){
            if (actual.temperatura > maxLectura.temperatura){
                maxLectura = actual;
            }
            actual = actual.siguiente;
        }
        System.out.println("Lectura más alta: " + maxLectura.temperatura);
    }
}
