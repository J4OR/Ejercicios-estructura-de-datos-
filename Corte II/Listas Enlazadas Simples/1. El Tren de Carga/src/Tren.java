public class Tren {
    Vagon cabeza;

    public Tren(){
        this.cabeza = null;
    }

    public void agregarVagon(Vagon nueVagon){
        if(cabeza == null){
            cabeza = nueVagon;
        }else{
            Vagon actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nueVagon;
        }
    }

    public double calcularPesoTotal(){
        double pesoTotal = 0.0;
        Vagon actual = cabeza;
        while (actual != null) {
            pesoTotal += actual.pesoToneladas;
            actual = actual.siguiente;
        }
        return pesoTotal;
    }
}

