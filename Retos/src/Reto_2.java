import java.util.Scanner;

public class Reto_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] cuentasVip = {10, 25, 40, 80, 150};
        double[] transacciones = {5000.0, 15000.0, 25000.0, 35000.0, 45000.0};
        double[] montosMayores= new double[transacciones.length];
        int[] cuentasMayores = new int[cuentasVip.length];
        int low = 0;
        int high= transacciones.length -1;

        
        for (int i = 0; i < transacciones.length; i++) {
            if (transacciones[i]>5000){
                montosMayores[i]+= transacciones[i];
                while (low<=high) {
                    int mid = (low + high) / 2;
                    if(cuentasVip[mid]==cuentasVip[i]){
                        cuentasMayores[i]+=cuentasVip[mid];
                        break;
                    } 
                    if (cuentasVip[i] < cuentasVip[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }
        for (int i = 0; i < cuentasMayores.length; i++) {
            System.out.println("Cuenta " + i + ": " + cuentasMayores[i]);
        }
        for (int i = 0; i < montosMayores.length; i++) {
            System.out.println("Monto " + i + ": "+ montosMayores[i]);
        }
    }
}