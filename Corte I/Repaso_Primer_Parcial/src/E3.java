import java.util.Scanner;

public class E3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de notas: ");
        int n = sc.nextInt();
        float[] notas = new float[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese nota del Estudiante " + (i+1) + ": ");
            float nota = sc.nextFloat();
            notas[i] = nota;
        }

        float mayor = notas[0];
        float menor = notas[0];

        for (int i = 0; i < notas.length; i++) {
            if(notas[i]>mayor){
                mayor = notas[i];
            }
            if (notas[i]<menor) {
                menor = notas[i];                
            }
        }
        System.out.println("--- INFORME ACADÉMICO ---");
        System.out.println("La nota más ALTA del grupo es: " + mayor);
        System.out.println("La nota más BAJA del grupo es: " + menor);

        System.out.println("--- LISTA DE NOTAS ORDENADA (Menor a Mayor) ---");
        selectionSort(notas);
        
        System.out.print("[");
        for (int i = 0; i < notas.length; i++) {
            System.out.print(notas[i] );
            if (i <notas.length-1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        sc.close();
    }

    // selection sort
    public static void selectionSort(float[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int indiceMinimo = i;

            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }

            // Intercambio
            float temp = arr[indiceMinimo];
            arr[indiceMinimo] = arr[i];
            arr[i] = temp;
        }
    }
}
