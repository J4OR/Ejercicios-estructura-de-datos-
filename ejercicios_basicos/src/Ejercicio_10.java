// Ejercicio 10 — Copiando configuración
// Una app tiene un objeto int[] configuracion = {1920, 1080, 60} (resolución y FPS).

// Crea una copia real del arreglo (no una referencia) usando un nuevo arreglo y copiando 
// elemento por elemento.
// Modifica la copia y demuestra que el original no cambia.
// Comenta la diferencia con la asignación directa.
public class Ejercicio_10 {
    public static void main(String[] args) {
        int[] configuracion = {1920, 1080, 60}; // Arreglo original con resolución y FPS
        int[] copiaConfiguracion = new int[configuracion.length]; // Creamos un nuevo arreglo para la copia

        // Copiamos elemento por elemento
        for (int i = 0; i < configuracion.length; i++) {
            copiaConfiguracion[i] = configuracion[i];
        }

        // Modificamos la copia
        copiaConfiguracion[2] = 120; // Cambiamos los FPS a 120

        // Mostramos ambas configuraciones
        System.out.println("Configuración original:");
        for (int i = 0; i < configuracion.length; i++) {
            System.out.println(configuracion[i]);
        }

        System.out.println("Copia de configuración modificada:");
        for (int i = 0; i < copiaConfiguracion.length; i++) {
            System.out.println(copiaConfiguracion[i]);
        }    
    }
}
