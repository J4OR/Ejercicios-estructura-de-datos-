import java.util.Scanner;

public class E2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese cuantos puntajes desea ingresar: ");
        int n=sc.nextInt();
        sc.nextLine();
        int[] puntajes = new int[n];

        System.out.println("--- INGRESO DE PUNTAJES ---");
        for (int i = 0; i < n; i++) {
            System.out.print("Puntaje del intento " + (i+1)+ ": " );
            int puntaje = sc.nextInt();
            puntajes[i]=puntaje;
        }
        selectionSort(puntajes);
        
        System.out.println("--- TABLA DE RESULTADOS (De mayor a menor) ---");
        for (int i = 0; i < puntajes.length; i++) {
            System.out.println((i+1)+"° Lugar: " + puntajes[i] );
        }

        int suma = 0;
        for (int i = 0; i < puntajes.length; i++) {
            suma+=puntajes[i];
        }
        double promedio = (suma/puntajes.length);

        System.out.println("El promedio total de los puntajes fue: " + promedio);

        System.out.println("--- BÚSQUEDA LINEAL ---");
        System.out.println("Ingrese el puntaje a buscar: ");
        int buscar = sc.nextInt();

        int posicion = busquedaLineal(puntajes, buscar);

        if (posicion != -1) {
            System.out.println(">> El puntaje " + buscar + " se encuentra en el " + (posicion+1) + "° lugar de la tabla.");
            
        }
        else{
            System.out.println("Puntaje no encontrado");
        }
        
        sc.close();
    }
     // selection sort mayor a menor
    public static void selectionSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int indiceMayor = i;

            for (int j = i + 1; j < n; j++) {

                if (arr[j] > arr[indiceMayor]) {
                    indiceMayor = j;
                }
            }

            // Intercambio
            int temp = arr[indiceMayor];
            arr[indiceMayor] = arr[i];
            arr[i] = temp;
        }
    }

    // busqueda lineal 
    public static int busquedaLineal(int[] arr, int objetivo) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == objetivo) {
                return i;
            }
        }

        return -1;
    }
}
