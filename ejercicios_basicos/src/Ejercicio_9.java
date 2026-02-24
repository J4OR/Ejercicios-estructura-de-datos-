// Ejercicio 9 — Notas de un curso
// Un profesor tiene las notas de 4 estudiantes en un arreglo. 
// El coordinador recibe una referencia al mismo arreglo para revisarlas.

// El coordinador corrige la nota del estudiante 2 (índice 1) de 2.5 a 3.0.
// Muestra que el arreglo del profesor también refleja el cambio.
// Añade comentarios explicando el concepto de referencia en memoria.

public class Ejercicio_9 {
    public static void main(String[] args) {
        float[] notas = {3.5f, 2.5f, 4.0f, 3.0f}; 
        float[] notasCoordinador = notas; 

        System.out.println("Notas antes de la corrección:");
        for (int i=0; i < notas.length; i++){
            System.out.println("Estudiante " + (i+1) + ": " + notas[i]);}
        
            notasCoordinador[2]=1.0f;

            System.out.println("Notas después de la corrección:");
            for (int i=0; i < notas.length; i++){
                System.out.println("Estudiante " + (i+1) + ": " + notas[i]);}
                                
            }
        }
// El arreglo notasCoordinador es una referencia al mismo arreglo que notas.
// Cambiar una nota a través de notasCoordinador también cambia el valor en notas
// porque ambos apuntan al mismo lugar en memoria donde se almacenan las notas.
        