// Ejercicio 6 — Turno en un banco
// Un cajero de banco trabaja con el número del turno actual. Se crea una variable turnoActual y 
// se asigna a turnoEnPantalla.

// Demuestra con código que cambiar turnoEnPantalla no afecta a turnoActual (comportamiento por valor).
// Explica en un comentario por qué ocurre esto.

public class Ejercicio_6 {
    public static void main(String[] args) {
        int turnoActual = 444;
        int turnoEnPantalla = turnoActual; // Se asigna el valor de turnoActual a turnoEnPantalla
        
        System.out.println("Turno actual: " + turnoActual);
        System.out.println("Turno en pantalla: " + turnoEnPantalla);
        
        // Cambiamos el valor de turnoEnPantalla
        turnoEnPantalla = 777;
        
        System.out.println("Después de cambiar turnoEnPantalla:");
        System.out.println("Turno actual: " + turnoActual);
        System.out.println("Turno en pantalla: " + turnoEnPantalla);
        
    }
}
