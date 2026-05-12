public class Pieza {
    String nombrePieza;
    String numeroSerie;
    Boolean esDefectuosa;
    Pieza siguiente;

    public Pieza(String nombrePieza, String numeroSerie, Boolean esDefectuosa) {
        this.nombrePieza = nombrePieza;
        this.numeroSerie = numeroSerie;
        this.esDefectuosa = esDefectuosa;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        return "[" + nombrePieza + " | " + numeroSerie + " | " + esDefectuosa + "]";
    }
}
