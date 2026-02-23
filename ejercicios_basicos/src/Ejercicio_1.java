import java.util.Scanner;

public class Ejercicio_1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        String nombre;
        int codigo;
        int semestre;
        double promedio;
        boolean matriculado;

        System.out.println("Ingrese el nombre del estudiante: ");
        nombre = sc.nextLine();
        System.out.println("Ingrese el codigo del estudiante: ");
        codigo = sc.nextInt();
        System.out.println("Ingrese el semestre del estudiante: ");
        semestre = sc.nextInt();
        System.out.println("Ingrese el promedio del estudiante: ");
        promedio = sc.nextDouble();
        System.out.println("Ingrese si el estudiante está matriculado (true/false): ");
        matriculado = sc.nextBoolean();

        System.out.println("Nombre: " + nombre);
        System.out.println("Codigo: " + codigo);    
        System.out.println("Semestre: " + semestre);
        System.out.println("Promedio: " + promedio);
        System.out.println("Matriculado: " + matriculado);

        sc.close();
    }
}
