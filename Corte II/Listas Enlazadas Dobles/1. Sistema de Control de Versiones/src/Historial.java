public class Historial {
    Cambio cabeza;
    Cambio cola;
    
    public Historial(){
        this.cabeza = null;
        this.cola = null;
    }

    public void agregarCambio(Cambio cambio){
        if(cabeza == null){
            cabeza = cambio;
            cola = cambio;
        }
        else{
            cola.siguiente = cambio;
            cambio.anterior = cola;
            cola = cambio;
        }
    }

    public Cambio deshacer(Cambio cambio){
        
        if(cambio.anterior == null){
            System.out.println("No hay cambios anteriores para deshacer.");
            return cambio;
        }
        return cambio.anterior;
    }

    public Cambio rehacer(Cambio cambio){
        if(cambio.siguiente == null){
            System.out.println("No hay cambios posteriores para rehacer.");
            return cambio;
        }

        return cambio.siguiente;   
    }
}
