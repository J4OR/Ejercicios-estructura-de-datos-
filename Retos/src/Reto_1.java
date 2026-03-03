import java.util.Scanner;

public class Reto_1 {
      public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(System.in);

        double[] precios= new double [5];
        for (int i=0; i < precios.length; i++){
            System.out.println("Ingrese el precio del producto " + (i+1) + ":");
            precios[i] = sc.nextDouble();
        }
        double total=0;
        for (int i=0; i < precios.length; i++){
            total += precios[i];
        }
        double precioMasAlto= precios[0];
        for (int i=1; i < precios.length; i++){
            if (precios[i] > precioMasAlto){
                precioMasAlto = precios[i];
            }
        }
        if (total>20000) {
            double totalDescuento= total - 2000;
            System.out.println("El total con descuento es: " + totalDescuento);
        }
        else {
            System.out.println("El total es: " + total);
        }   
        System.out.println("El precio mas alto es: " + precioMasAlto);
        sc.close();
    }  
}
